package dataStructure.C_graph_matrix_advanced.xx_9_graph;

public class run_1 {
    public static void main(String args[]) {
        AdjListGraphSimple gph_1 = new AdjListGraphSimple(5);
        gph_1.addEdge(0, 1);
        gph_1.addEdge(0, 2);
        gph_1.addEdge(0, 3);
        gph_1.addEdge(1, 2);
        gph_1.addEdge(2, 4);
        gph_1.printGraph();

        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><>");
        /*
        ------------------------------------------------------------------------------------------------------------
         */

        AdjMatrixGraph gph_2 = new AdjMatrixGraph(5);
        gph_2.addEdge(0, 1);
        gph_2.addEdge(0, 4);
        gph_2.addEdge(1, 2);
        gph_2.addEdge(1, 3);
        gph_2.addEdge(1, 4);
        gph_2.addEdge(2, 3);
        gph_2.addEdge(3, 4);
        gph_2.printGraph();

        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><>");
        /*
        ------------------------------------------------------------------------------------------------------------
         */

        AdjListGraph gph_3 = new AdjListGraph(5);
        gph_3.addEdge(0,1);
        gph_3.addEdge(0, 4);
        gph_3.addEdge(1, 2);
        gph_3.addEdge(1, 3);
        gph_3.addEdge(1, 4);
        gph_3.addEdge(2, 3);
        gph_3.addEdge(3, 4);
        gph_3.printGraph();

        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><>");
        /*
        ------------------------------------------------------------------------------------------------------------
         */

        WeightedGraph gph_4 = new WeightedGraph(6);
        gph_4.addEgde(0, 1, 4);
        gph_4.addEgde(0, 2, 3);
        gph_4.addEgde(1, 3, 2);
        gph_4.addEgde(1, 2, 5);
        gph_4.addEgde(2, 3, 7);
        gph_4.addEgde(3, 4, 2);
        gph_4.addEgde(4, 0, 4);
        gph_4.addEgde(4, 1, 4);
        gph_4.addEgde(4, 5, 6);
        gph_4.printGraph();
    }
}

