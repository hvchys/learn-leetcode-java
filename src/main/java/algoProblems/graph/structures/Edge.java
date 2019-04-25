package algoProblems.graph.structures;

public class Edge {
    public Vertex startVertex;
    public Vertex endVertex;
    public int weight;

    public Edge(Vertex startVertex, Vertex endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.startVertex + " --" + this.weight + "--> " + this.endVertex;
    }

    public static Edge deepCopy(Edge e){
        Vertex startVertex = Vertex.deepCopy(e.startVertex);
        Vertex endVertex = Vertex.deepCopy(e.endVertex);
        return new Edge(startVertex, endVertex, e.weight);
    }

}