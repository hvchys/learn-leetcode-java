package dataStructure.C_graph_matrix_advanced.xx_9_graph;

import java.util.LinkedList;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class WeightedGraph {
    int vertices;
    LinkedList<Edge>[] adjacencylist;

    /*
    LinkedList<Edge>[] adjacencylist: 是数组，adjacencylist[x] 是 点x 的邻接表
     */

    WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i <vertices ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEgde(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        // 有向图
        adjacencylist[source].addFirst(edge);
    }

    public void printGraph(){
        for (int i = 0; i < this.vertices ; i++) {
            LinkedList<Edge> list = this.adjacencylist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println("name-" + i + " is connected to " +
                        list.get(j).destination + " with weight " +  list.get(j).weight);
            }
        }
    }
}