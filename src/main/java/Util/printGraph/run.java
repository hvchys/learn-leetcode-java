package Util.printGraph;

import java.io.File;

public class run {
    public static void createDotGraph(String dotFormat, String outputPath) {
        GraphViz gv=new GraphViz();
        gv.addln(gv.start_graph());
        gv.add(dotFormat);
        gv.addln(gv.end_graph());
        // png为输出格式，还可改为pdf，gif，jpg等
        String type = "png";
        // gv.increaseDpi();
        gv.decreaseDpi();
        gv.decreaseDpi();
        // File out = new File(fileName+"."+ type);
        File out = new File(outputPath);
        byte[] xx = gv.getGraph( gv.getDotSource(), type );
        System.out.println(xx.length);
        gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
    }

    public static void main(String[] args) throws Exception {
        // String temp_dir = "/Users/huangweichen/Desktop/MyProjects/xx_download/java_util_190410/Graphviz";
        // temp = File.createTempFile("dorrr",".dot", new File(temp_dir));

        String osName = System.getProperty("os.name").replaceAll("\\s","");
        System.out.println("osName: " + osName);

        String outputPath = "/Users/huangweichen/Desktop/test.png";
        String dotFormat="1->2;1->3;1->4;4->5;4->6;6->7;5->7;3->8;3->6;8->7;2->8;2->5;";
        createDotGraph(dotFormat, outputPath);
    }
}
