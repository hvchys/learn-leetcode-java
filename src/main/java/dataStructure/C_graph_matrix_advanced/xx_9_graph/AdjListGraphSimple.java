package dataStructure.C_graph_matrix_advanced.xx_9_graph;

// Create adjacency node
class adjNode {
    int source;
    int destination;
    adjNode next;

    public adjNode(int source, int destination) {
        this.source = source;
        this.destination = destination;
        next = null;
    }
}

class adjList {
    adjNode head;
}

public class AdjListGraphSimple {
    int V;
    adjList array[];

    /*
    V: 点的个数
    adjList array[]: 邻接表。点 x 对应的linked list: array[x]
    array[x]的类型: adjList: 它代表了head
     */

    // 图的初始化:
    // 1. 点的个数
    // 2. adjList array[]: 邻接表: 初始化: 都是null
    public AdjListGraphSimple(int V) {
        this.V = V;
        array = new adjList[V];

        for (int i = 0; i < V; i++) {
            array[i] = new adjList();
            array[i].head = null;
        }
    }

    // 增加一条边: 点source -> 点destination
    public void addEdge(int source, int destination) {
        adjNode adn = new adjNode(source, destination);

        /*
        把新的点 adn 放到 array[sourceIdx] 里面:

        对于点source, 它的 array[sourceIdx]: head: adjNode(sourceIdx:A, destinationIdx: B, next: blabla...)
        原来: array[sourceIdx]: adjNode(A,B) -> next: blabla...
        现在: adn -> array[sourceIdx]
              adn(adjNode(sourceIdx, destinationIdx)) -> next: adjNode(A,B) -> next: blabla...
         */
        adn.next = array[source].head;
        array[source].head = adn;

        // 如果是无向图的话，再增加一条反向的结点
//		adn = new adjNode(destinationIdx, sourceIdx);
//		adn.next = array[destinationIdx].head;
//		array[destinationIdx].head = adn;
    }

    public void printGraph() {
        int vertex = this.V;
        adjNode ad;
        for (int i = 0; i < vertex; i++) {
            ad = this.array[i].head;
            if(ad!=null){
                System.out.print("\n和点 " + ad.source + " 相连的点有: ");
                while (ad != null) {
                    System.out.print(ad.destination + " ");
                    ad = ad.next;
                }
            }
        }
    }

}
