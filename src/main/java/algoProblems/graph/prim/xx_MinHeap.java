package algoProblems.graph.prim;

import algoProblems.graph.structures.Edge;
import algoProblems.graph.structures.Graph;
import algoProblems.graph.structures.Vertex;

import java.util.LinkedList;

public class xx_MinHeap {

    public static Edge[] getMST(Graph graph, int sourceNodeIdx){
        boolean[] inHeap = new boolean[graph.vertexNum];
        Edge[] resultArr = new Edge[graph.vertexNum];
        // 堆里面的 mH[]: 记录MST里面，加入每个点的时候，用的的边，的权
        //               也就是 chapter13 里面提到的 key[]
        //               mH[点V]: Edge(点XX -> 点V)

        for (int i = 0; i < graph.vertexNum; i++) {
            inHeap[i] = true;
        }

        EdgeMinHeap minHeap = EdgeMinHeap.createMinHeapFromGraph(graph, sourceNodeIdx);

        // 把 堆 里面的东西 一个一个拿出来
        while(!minHeap.isEmpty()){
            // 取出来 最小值
            Edge minNodeEdge = minHeap.extractMin();

            int minNodeOriIdx = minNodeEdge.endVertex.idx;
            inHeap[minNodeOriIdx] = false;
            resultArr[minNodeOriIdx] = Edge.deepCopy(minNodeEdge);

            // 点 u:
            Vertex curNode = minNodeEdge.endVertex;
            // 遍历 点u 的所有 邻居: u -> v
            LinkedList<Edge> curEdgeList = graph.adjlist[minNodeOriIdx];
            for(Edge uToVEdge: curEdgeList){
                // 对于所有 u 的邻居结点v:
                // 如果 v 不在MST里面，边(u,v)的权 < key[v], 则: key[v]更新为: 边(u,v)的权
                if(inHeap[uToVEdge.endVertex.idx]) {
                    int VOriIdx = uToVEdge.endVertex.idx;
                    int newKey = uToVEdge.weight;
                    Edge VCurEdge = minHeap.oriIdxToEdge(VOriIdx);
                    if(VCurEdge.weight > newKey) {
                        VCurEdge.startVertex = Vertex.deepCopy(curNode);
                        minHeap.decreaseKey(newKey, VOriIdx);
                        uToVEdge.weight = newKey;
                    }
                }
            }
        }

        // EdgeMinHeap.printEdges(minHeap);
        return resultArr;
    }

}
