package algoProblems.graph.structures;

import java.util.LinkedList;

public class Graph {
    public int vertexNum;
    public Vertex[] vertexArr;
    public LinkedList<Edge>[] adjlist;

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.adjlist = new LinkedList[vertexNum];
        // 初始化 邻接表
        for (int i = 0; i < vertexNum; i++) {
            this.adjlist[i] = new LinkedList<>();
        }
    }

    public Graph(int vertexNum, String[] nodeNameArr) {
        this.vertexNum = vertexNum;
        this.adjlist = new LinkedList[vertexNum];
        this.vertexArr = new Vertex[vertexNum];
        // 初始化 邻接表
        for (int i = 0; i < vertexNum; i++) {
            this.adjlist[i] = new LinkedList<>();
            this.vertexArr[i] = new Vertex(i, nodeNameArr[i]);
        }
    }

    public void addEdge(Vertex startVertex, Vertex endVertex, int weight) {
        Edge edge = new Edge(startVertex, endVertex, weight);
        this.adjlist[startVertex.idx].addFirst(edge);

        // 如果是无向图的话
        edge = new Edge(endVertex, startVertex, weight);
        this.adjlist[endVertex.idx].addFirst(edge);
    }

    public void addEdge(int startIdx, int endIdx, int weight) {
        Vertex startVertex = this.vertexArr[startIdx];
        Vertex endVertex = this.vertexArr[endIdx];
        addEdge(startVertex, endVertex, weight);
    }

    public static void printVertices(Graph graph){
        System.out.println("图的点:");
        for(Vertex v: graph.vertexArr){
            System.out.println(v);
        }
        System.out.println("--------------------------");
    }

    public static void printAdjlist(Graph graph){
        System.out.println("图的邻接表:");
        for(LinkedList<Edge> v: graph.adjlist){
            System.out.println(v);
        }
        System.out.println("--------------------------");
    }

}