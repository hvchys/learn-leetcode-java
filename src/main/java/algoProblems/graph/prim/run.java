package algoProblems.graph.prim;

import algoProblems.graph.structures.Edge;
import algoProblems.graph.structures.Graph;

public class run {

    public static void printEdges(String info, Edge[] edgeArr){
        int total_min_weight = 0;
        System.out.println(info + ": ");
        for(Edge e: edgeArr){
            if(e != null){
                System.out.println(e);
                total_min_weight += e.weight;
            }
        }
        System.out.println("Total minimum key: " + total_min_weight);
    }

    public static void printEdgesSum(String info, Edge[] edgeArr){
        int total_min_weight = 0;
        for(Edge e: edgeArr){
            if(e != null){
                total_min_weight += e.weight;
            }
        }
        System.out.println(info + ": " + total_min_weight);
    }

    public static void test(Graph graph, int sourceIdx){
        Edge[] edgeArr;

        edgeArr = xx_MinHeap.getMST(graph, sourceIdx);
        printEdges("解法, 最小堆", edgeArr);

        edgeArr = xx_PQ.getMST(graph, sourceIdx);
        printEdges("解法, PQ", edgeArr);

        edgeArr = xx_PQBetter.getMST(graph, sourceIdx);
        printEdges("解法, PQBetter", edgeArr);
    }

    public static void test_2(Graph graph, int sourceIdx){
        Edge[] edgeArr;

        edgeArr = xx_MinHeap.getMST(graph, sourceIdx);
        printEdgesSum("解法, 最小堆", edgeArr);

        edgeArr = xx_PQ.getMST(graph, sourceIdx);
        printEdgesSum("解法, PQ", edgeArr);

        edgeArr = xx_PQBetter.getMST(graph, sourceIdx);
        printEdges("解法, PQBetter", edgeArr);
    }

    public static void main(String[] args) {
        int vertices = 6;
        String[] nodeNameArr = {"a_0", "a_1", "a_2", "a_3", "a_4", "a_5"};
        Graph graph = new Graph(vertices, nodeNameArr); // 边里面的点 用 点的idx 表示
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

//        Edge[] edgeArr = xx_PQ.getMST(graph, 2);
//        printEdges("解法, PQ", edgeArr);

        System.out.println("\n\n############################");
        test(graph, 0);

        System.out.println("\n\n############################");
        test(graph, 1);

        System.out.println("\n\n############################");
        test(graph, 2);

        System.out.println("\n\n############################");
        test(graph, 3);
    }
}
