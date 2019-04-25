package Util.printGraph;

import java.io.*;
import java.util.Properties;

/*
 GraphViz gv = new GraphViz();
 gv.addln(gv.start_graph());
 gv.addln("A -> B;");
 gv.addln("A -> C;");
 gv.addln(gv.end_graph());
 System.out.println(gv.getDotSource());

 String type = "gif";
 File out = new File("out." + type);   // out.gif in this example
 gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );

 */

/**
 * <dl>
 * <dt>Purpose: GraphViz Java API
 * <dd>
 *
 * @version v0.5.1, 2013/03/18 (March) -- Patch of Juan Hoyos (Mac support)
 * @version v0.5, 2012/04/24 (April) -- Patch of Abdur Rahman (OS detection + start subgraph +
 * read config file)
 * @version v0.4, 2011/02/05 (February) -- Patch of Keheliya Gallaba is added. Now you
 * can specify the type of the output file: gif, dot, fig, pdf, ps, svg, png, etc.
 * @version v0.3, 2010/11/29 (November) -- Windows support + ability to read the graph from a text file
 * @version v0.2, 2010/07/22 (July) -- bug fix
 * @version v0.1, 2003/12/04 (December) -- first release
 * @author  Laszlo Szathmary (<a href="jabba.laci@gmail.com">jabba.laci@gmail.com</a>)
 */
public class GraphViz {
    /**
     * Detects the client's operating system.
     */
    private final static String osName = System.getProperty("os.name").replaceAll("\\s","");

    /**
     * Load the config.properties file.
     * 加载配置路径
     */
    private final static String cfgProp = "/Users/huangweichen/Desktop/MyProjects/xx_download/java_util_190410/Graphviz/config.properties";
    private final static Properties configFile = new Properties() {
        private final static long serialVersionUID = 1L; {
            try {
                load(new FileInputStream(cfgProp));
            } catch (Exception e) {}
        }
    };

    /**
     * The dir. where temporary files will be created.
     * 输出的路径
     */
    // private static String TEMP_DIR = "E:\\Java\\WorkSpace\\Demo1\\src\\Graphviz";
    private static String TEMP_DIR = "/Users/huangweichen/Desktop/MyProjects/xx_download/java_util_190410/Graphviz";
    private static String TEMP_DIR_2 = "/Users/huangweichen/Desktop/MyProjects/xx_download/java_util_190410/Graphviz_2";

    /**
     * Where is your dot program located? It will be called externally.
     */
    private static String DOT = configFile.getProperty("dotFor" + osName);

    /**
     * The image size in dpi. 96 dpi is normal size. Higher values are 10% higher each.
     * Lower values 10% lower each.
     *
     * dpi patch by Peter Mueller
     */
    private int[] dpiSizes = {46, 51, 57, 63, 70, 78, 86, 96, 106, 116, 128, 141, 155, 170, 187, 206, 226, 249};

    /**
     * Define the index in the image size array.
     */
    private int currentDpiPos = 7;

    /**
     * Increase the image size (dpi).
     */
    public void increaseDpi() {
        if ( this.currentDpiPos < (this.dpiSizes.length - 1) ) {
            ++this.currentDpiPos;
        }
    }

    /**
     * Decrease the image size (dpi).
     */
    public void decreaseDpi() {
        if (this.currentDpiPos > 0) {
            --this.currentDpiPos;
        }
    }

    public int getImageDpi() {
        return this.dpiSizes[this.currentDpiPos];
    }

    /**
     * The sourceIdx of the graph written in dot language.
     */
    private StringBuilder graph = new StringBuilder();

    /**
     * Constructor: creates a new GraphViz object that will contain
     * a graph.
     */
    public GraphViz() {
    }

    /**
     * Returns the graph's sourceIdx description in dot language.
     * @return Source of the graph in dot language.
     */
    public String getDotSource() {
        return this.graph.toString();
    }

    /**
     * Adds a string to the graph's sourceIdx (without newline).
     */
    public void add(String line) {
        this.graph.append(line);
    }

    /**
     * Adds a string to the graph's sourceIdx (with newline).
     */
    public void addln(String line) {
        this.graph.append(line + "\n");
    }

    /**
     * Adds a newline to the graph's sourceIdx.
     */
    public void addln() {
        this.graph.append('\n');
    }

    public void clearGraph(){
        this.graph = new StringBuilder();
    }

    /**
     * Returns the graph as an image in binary format.
     * @param dot_source Source of the graph to be drawn.
     * @param type Type of the output image to be produced, e.g.: gif, dot, fig, pdf, ps, svg, png.
     * @return A byte array containing the image of the graph.
     */
    public byte[] getGraph(String dot_source, String type) {
        File dot;
        byte[] img_stream = null;

        try {
            dot = writeDotSourceToFile(dot_source);
            if (dot != null) {
                System.out.println("getGraph dot not null");
                img_stream = get_img_stream(dot, type);
                if (dot.delete() == false)
                    System.err.println("Warning: " + dot.getAbsolutePath() + " could not be deleted!");
                return img_stream;
            }
            return null;
        } catch (java.io.IOException ioe) { return null; }
    }

    /**
     * Writes the graph's image in a file.
     * @param img   A byte array containing the image of the graph.
     * @param file  Name of the file to where we want to write.
     * @return Success: 1, Failure: -1
     */
    public int writeGraphToFile(byte[] img, String file)
    {
        File to = new File(file);
        return writeGraphToFile(img, to);
    }

    /**
     * Writes the graph's image in a file.
     * @param img   A byte array containing the image of the graph.
     * @param to    A File object to where we want to write.
     * @return Success: 1, Failure: -1
     */
    public int writeGraphToFile(byte[] img, File to)
    {
        try {
            FileOutputStream fos = new FileOutputStream(to);
            fos.write(img);
            fos.close();
        } catch (java.io.IOException ioe) { return -1; }
        return 1;
    }

    /**
     * It will call the external dot program, and return the image in
     * binary format.
     * @param dot Source of the graph (in dot language).
     * @param type Type of the output image to be produced, e.g.: gif, dot, fig, pdf, ps, svg, png.
     * @return The image of the graph in .gif format.
     */
    private byte[] get_img_stream(File dot, String type)
    {
        File img;
        byte[] img_stream = null;

        try {
            File file = new File(GraphViz.TEMP_DIR);// D;/temp 为一个目录
            img = File.createTempFile("graph_", "."+type, file);
            System.out.println("get_img_stream line 220");
            // img = File.createTempFile("graph_", "."+type, new File(GraphViz.TEMP_DIR));
            Runtime rt = Runtime.getRuntime();

            System.out.println("DOT: " + DOT);
            System.out.println("-Gdpi="+dpiSizes[this.currentDpiPos]);
            System.out.println("dot: " + dot.getAbsolutePath());
            System.out.println("img: " + img.getAbsolutePath());

            // patch by Mike Chenault
            String[] args = {DOT, "-T"+type, "-Gdpi="+dpiSizes[this.currentDpiPos], dot.getAbsolutePath(), "-o", img.getAbsolutePath()};
            Process p = rt.exec(args);
            System.out.println("get_img_stream line 227");
            p.waitFor();

            FileInputStream in = new FileInputStream(img.getAbsolutePath());
            img_stream = new byte[in.available()];
            in.read(img_stream);
            // Close it if we need to
            if( in != null ) in.close();

            if (img.delete() == false)
                System.err.println("Warning: " + img.getAbsolutePath() + " could not be deleted!");
        }
        catch (java.io.IOException ioe) {
            System.err.println("Error:    in I/O processing of tempfile in dir " + GraphViz.TEMP_DIR+"\n");
            System.err.println("       or in calling external command");
            ioe.printStackTrace();
        }
        catch (InterruptedException ie) {
            System.err.println("Error: the execution of the external program was interrupted");
            ie.printStackTrace();
        }

        return img_stream;
    }

    /**
     * Writes the sourceIdx of the graph in a file, and returns the written file
     * as a File object.
     * @param str Source of the graph (in dot language).
     * @return The file (as a File object) that contains the sourceIdx of the graph.
     */
    private File writeDotSourceToFile(String str) throws java.io.IOException {
        File temp;
        try {
            // temp = File.createTempFile("dorrr",".dot", new File(GraphViz.TEMP_DIR));
            File file = new File(GraphViz.TEMP_DIR);// D;/temp 为一个目录
            temp = File.createTempFile("msg", ".tmp", file);

            FileWriter fout = new FileWriter(temp);
            fout.write(str);
            // BufferedWriter br=new BufferedWriter(new FileWriter("dotsource.dot"));
            BufferedWriter br=new BufferedWriter(new FileWriter(GraphViz.TEMP_DIR_2));
            br.write(str);
            br.flush();
            br.close();
            fout.close();
            System.out.println("line 274");
        }
        catch (Exception e) {
            System.err.println("Error: I/O error while writing the dot sourceIdx to temp file!");
            return null;
        }
        return temp;
    }

    /**
     * Returns a string that is used to start a graph.
     * @return A string to open a graph.
     */
    public String start_graph() {
        return "digraph G {";
    }

    /**
     * Returns a string that is used to end a graph.
     * @return A string to close a graph.
     */
    public String end_graph() {
        return "}";
    }

    /**
     * Takes the cluster or subgraph id as input parameter and returns a string
     * that is used to start a subgraph.
     * @return A string to open a subgraph.
     */
    public String start_subgraph(int clusterid) {
        return "subgraph cluster_" + clusterid + " {";
    }

    /**
     * Returns a string that is used to end a graph.
     * @return A string to close a graph.
     */
    public String end_subgraph() {
        return "}";
    }

    /**
     * Read a DOT graph from a text file.
     *
     * @param input Input text file containing the DOT graph
     * sourceIdx.
     */
    public void readSource(String input)
    {
        StringBuilder sb = new StringBuilder();

        try
        {
            FileInputStream fis = new FileInputStream(input);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            dis.close();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        this.graph = sb;
    }

}