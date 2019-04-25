package algoProblems.graph.dijkstra;

import algoProblems.graph.structures.Graph;

public class run {
    public static void main(String[] args) {
        int vertices = 6;
        String[] nodeNameArr = {"a_0", "a_1", "a_2", "a_3", "a_4", "a_5"};
        Graph graph = new Graph(vertices, nodeNameArr); // 边里面的点 用 点的idx 表示
        int sourceVertex = 0;
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 5, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
//        Graph.printVertices(graph);
//        Graph.printAdjlist(graph);

        xx_MinHeap.dijkstra_GetMinDistances(graph, sourceVertex);

        /*
        [(0)a_0]dist: 0
        [(1)a_1]dist: 1
        [(2)a_2]dist: 2
        [(3)a_3]dist: 3
        [(4)a_4]dist: 5
        [(5)a_5]dist: 2
        */
    }
}
