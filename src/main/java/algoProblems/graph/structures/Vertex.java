package algoProblems.graph.structures;

public class Vertex {
    public int idx;
    public String name;

    public Vertex(){};

    public Vertex(int idx){
        this.idx = idx;
    }

    public Vertex(int idx, String name){
        this.idx = idx;
        this.name = name;
    }

    @Override
    public String toString() {
        if(this.name == null){
            return "[" + this.idx + "]";
        }else{
            return "[(" + this.idx + ")" + this.name + "]";
        }
    }

    public static Vertex deepCopy(Vertex v1){
        return new Vertex(v1.idx, v1.name);
    }

}
