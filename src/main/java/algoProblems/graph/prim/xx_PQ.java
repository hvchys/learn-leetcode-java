package algoProblems.graph.prim;

import algoProblems.graph.structures.Edge;
import algoProblems.graph.structures.Graph;
import algoProblems.graph.structures.Vertex;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class xx_PQ {

    public static PriorityQueue<Edge> createPQ(Graph graph, int sourceNodeIdx){
        // 把所有点加到优先队列里面，每个点，对应的初始的边，是空的
        // pq: 点V的Edge: 点null -> 点V, weght = MAX
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.vertexNum,
                new Comparator<Edge>() {
                    @Override
                    public int compare(Edge o1, Edge o2) {
                        return o1.weight - o2.weight;
                    }
                });
        for(Vertex vertex: graph.vertexArr){
            if(vertex.idx == sourceNodeIdx){
                pq.offer(new Edge(Vertex.deepCopy(vertex), Vertex.deepCopy(vertex), 0));
            }else{
                pq.offer(new Edge(new Vertex(), Vertex.deepCopy(vertex), Integer.MAX_VALUE));
            }
        }
        return pq;
    }

    public static Edge[] getMST(Graph graph, int sourceNodeIdx){
        boolean[] inPQArr = new boolean[graph.vertexNum];
        Edge[] resultArr = new Edge[graph.vertexNum];
        int[] key = new int[graph.vertexNum];
        // keys used to store the key to know whether priority queue update is required

        for (int i = 0; i < graph.vertexNum; i++) {
            inPQArr[i] = true;
            key[i] = Integer.MAX_VALUE;
        }

        // 把所有点加到优先队列里面
        PriorityQueue<Edge> pq = createPQ(graph, sourceNodeIdx);

        while(!pq.isEmpty()){
            // 取出最小值
            Edge curMinEdge = pq.poll();
            int curMinNodeIdx = curMinEdge.endVertex.idx;
            inPQArr[curMinNodeIdx] = false;

            if(curMinNodeIdx != sourceNodeIdx){
                // 更新结果
                resultArr[curMinNodeIdx] = Edge.deepCopy(curMinEdge);
            }

            // 遍历当前点的 邻接表
            LinkedList<Edge> curAdjList = graph.adjlist[curMinNodeIdx];
            for(Edge e: curAdjList){
                int vIdx = e.endVertex.idx;
                // 点 v 在 队列里面
                if(inPQArr[vIdx]) {
                    int newKey = e.weight;
                    // 如果 新的key < 现有key, 就更新
                    if(newKey < key[vIdx]) {
                        decreaseKey(pq, e);
                        key[vIdx] = newKey;
                    }
                }
            }
        }
        return resultArr;
    }

    public static void decreaseKey(PriorityQueue<Edge> pq, Edge newE){
        Iterator it = pq.iterator();
        while (it.hasNext()) {
            Edge curE = (Edge) it.next();
            if(curE.endVertex.idx == newE.endVertex.idx) {
                pq.remove(curE);
                curE.weight = newE.weight;
                curE.startVertex = Vertex.deepCopy(newE.startVertex);
                pq.offer(curE);
                break;
            }
        }
    }
}
