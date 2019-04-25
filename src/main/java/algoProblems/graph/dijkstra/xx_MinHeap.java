package algoProblems.graph.dijkstra;

import algoProblems.graph.structures.Edge;
import algoProblems.graph.structures.Graph;
import algoProblems.graph.structures.HeapNode;
import algoProblems.graph.structures.MinHeap;

import java.util.LinkedList;

public class xx_MinHeap {

    public static void dijkstra_GetMinDistances(Graph graph, int sourceVertexIdx) {
        boolean[] SPT = new boolean[graph.vertexNum];

        int[] ans = new int[graph.vertexNum];
        // key: oriIdx, val: minDistance

        MinHeap minHeap = MinHeap.createMinHeapFromGraph(graph, sourceVertexIdx);
        // MinHeap_intArr.printHeapNodes(minHeap);
        // MinHeap_intArr.printIdxArr(minHeap);

        // 当 最小堆 非空
        while (!minHeap.isEmpty()) {
            // 取出最小的点 minNode
            HeapNode curMinNode = minHeap.extractMin();

            // 把 minNode 放到 SPT 里面
            int minNodeOriIdx = curMinNode.vertex.idx;
            SPT[minNodeOriIdx] = true;
            ans[minNodeOriIdx] = curMinNode.key;

            // 遍历 minNode 的所有邻接结点
            LinkedList<Edge> curNodeEdgeList = graph.adjlist[minNodeOriIdx];
            // System.out.println("curNodeEdgeList: " + curNodeEdgeList);
            HeapNode vNode;
            for (Edge edge : curNodeEdgeList) {
                int vOriIdx = edge.endVertex.idx;
                // 如果 点destination 不在 最短路径树(SPT) 里面
                if (!SPT[vOriIdx]) {
                    // System.out.println("vOriIdx: " + vOriIdx);
                    // 检查是否需要更新 key
                    vNode = minHeap.oriIdxToNode(vOriIdx);
                    // !!! 防止没有意义的加法, 会超出 Integer.MAX 吗? 好像不会?
                    // newDist 肯定不会超过 Integer.MAX
                    int newDist = curMinNode.key + edge.weight;
                    int curDist = vNode.key;
                    // 如果 newDist 更小，说明应该把 点v 的距离更新
                    if (curDist > newDist) {
                        // !!! 到这里，说明改变了结果
                        // 这一，改变了一个，就把 heap 全变了，就会影响后面
                        // System.out.println("!!! change");
                        minHeap.decreaseKey(newDist, vOriIdx);
                        // vNode.key = newDist;
                        // MinHeap_intArr.printHeapNodes(minHeap);
                    }
                }
            }
        }

        // print SPT
        printDijkstra(ans, sourceVertexIdx, graph);

        // MinHeap_intArr.display("minHeap", minHeap);
    }

    public static void printDijkstra(int[] ans, int sourceNode, Graph graph) {
        System.out.println("Dijkstra算法: 邻接表 + 最小堆");
        System.out.println("源点: " + graph.vertexArr[sourceNode]);
        System.out.println("每个点到源点的距离: ");
        for (int oriIdx = 0; oriIdx < ans.length; oriIdx++) {
            System.out.println("node: " + graph.vertexArr[oriIdx] + ", dist: " + ans[oriIdx]);
        }
    }


}