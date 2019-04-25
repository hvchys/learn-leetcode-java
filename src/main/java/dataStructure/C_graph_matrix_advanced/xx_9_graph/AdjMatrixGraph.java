package dataStructure.C_graph_matrix_advanced.xx_9_graph;


public class AdjMatrixGraph {
    int vertex;
    int matrix[][];

    public AdjMatrixGraph(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination) {
        // 加一条边
        matrix[source][destination]=1;

        // 如果是无向图的话，把反向边也加上
        matrix[destination][source] = 1;
    }

    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j <vertex ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j = 0; j <vertex ; j++) {
                if(matrix[i][j]==1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

}