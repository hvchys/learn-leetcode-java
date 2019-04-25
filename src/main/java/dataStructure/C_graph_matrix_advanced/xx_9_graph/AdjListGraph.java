package dataStructure.C_graph_matrix_advanced.xx_9_graph;

import java.util.LinkedList;

public class AdjListGraph {
    int vertex;
    LinkedList<Integer> list[];

    /*
    name: 点的个数
    list[]: list[x] 是 点x 的 邻接表: list[x][i]: 存在边 x -> i
     */

    public AdjListGraph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        // 增加一条边
        list[source].addFirst(destination);

        // 如果是无向图的话，加上反向边
        list[destination].addFirst(source);
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            if(list[i].size()>0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

}