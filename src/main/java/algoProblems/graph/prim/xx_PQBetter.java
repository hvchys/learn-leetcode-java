package algoProblems.graph.prim;

import algoProblems.graph.structures.Edge;
import algoProblems.graph.structures.Graph;
import algoProblems.graph.structures.Vertex;
import javafx.util.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class xx_PQBetter {

    public static Edge[] initializeAndEdges(Graph graph, int sourceNodeIdx){
        Edge[] selEdgeArr = new Edge[graph.vertexNum];
        Vertex curNode;
        for(int i = 0; i < graph.vertexNum; i++){
            curNode = graph.vertexArr[i];
            selEdgeArr[i] = new Edge(Vertex.deepCopy(curNode), Vertex.deepCopy(curNode), Integer.MAX_VALUE);
        }
        selEdgeArr[sourceNodeIdx].weight = 0;
        return selEdgeArr;
    }

    public static Edge[] getMST(Graph graph, int sourceNodeIdx){
        boolean[] mst = new boolean[graph.vertexNum];
        int[] key = new int[graph.vertexNum];  // keys used to store the key to know whether priority queue update is required
        // key: 保存每个点，在 MST 里面 指向它的边的权
        Edge[] selEdgeArr = initializeAndEdges(graph, sourceNodeIdx);

        // 初始化PQ
        // PQ里面的元素 <key[V], VOriIdx>
        // override the comparator to do the sorting based keys
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertexNum,
                new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                        // sort using key values
                        int key1 = p1.getKey();
                        int key2 = p2.getKey();
                        return key1 - key2;
                    }
                });

        // Initialize all the keys to infinity and
        // initialize resultArr for all the vertices
        for (int i = 0; i < graph.vertexNum ; i++) {
            key[i] = Integer.MAX_VALUE;

        }

        // 源点，在 PQ 里面的元素
        key[sourceNodeIdx] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(key[sourceNodeIdx], sourceNodeIdx);
        pq.offer(p0);

        // while priority queue is not empty
        while(!pq.isEmpty()){
            // 取出最小值，把这个点放到 MST 里面
            Pair<Integer, Integer> minPair = pq.poll();
            int minNodeOriIdx = minPair.getValue();
            mst[minNodeOriIdx] = true;

            Vertex curMinNode = graph.vertexArr[minNodeOriIdx];
            // 遍历当前点的邻居
            LinkedList<Edge> curEdgeList = graph.adjlist[minNodeOriIdx];
            for(Edge uToVEdge: curEdgeList){
                int vOriIdx = uToVEdge.endVertex.idx;
                // 对于 u 的所有邻居结点 v:
                // 如果 v 不在MST里面，边(u,v)的权 < key[v], 则: key[v]更新为: 边(u,v)的权
                if(!mst[vOriIdx]) {
                    int newKey = uToVEdge.weight;
                    //check if updated key < existing key, if yes, update if
                    if(key[vOriIdx] > newKey) {
                        // add it to the priority queue
                        Pair<Integer, Integer> p = new Pair<>(newKey, vOriIdx);
                        pq.offer(p);
                        // update the resultArr for destination vertex
                        selEdgeArr[vOriIdx].startVertex = Vertex.deepCopy(curMinNode);
                        selEdgeArr[vOriIdx].weight = newKey;
                        // update the key[]
                        key[vOriIdx] = newKey;
                    }
                }
            }
        }
        // print mst
        // printMST(resultArr);
        return selEdgeArr;
    }

}