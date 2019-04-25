package algoProblems.graph.structures;

import Util.printIntData;

import static Util.randNum.shuffleArr;

public class a_test {

    public static MinHeap createMinHeapFromGraph_2(Graph graph, int sourceNodeIdx, int[] keyArr){
        // 每个点，建立一个 HeapNode
        HeapNode[] heapNodes = new HeapNode[graph.vertexNum];
        for (int i = 0; i < graph.vertexNum; i++) {
            heapNodes[i] = new HeapNode(graph.vertexArr[i], keyArr[i]);
            System.out.println(graph.vertexArr[i] + ", " + keyArr[i]);
        }

        // add all the vertices to the MinHeap_intArr
        MinHeap minHeap = new MinHeap(graph.vertexNum);
        // add all the vertices to priority queue
        for (int i = 0; i < graph.vertexNum; i++) {
            minHeap.insert(heapNodes[i]);
        }

        return minHeap;
    }

    public static void extract(MinHeap minHeap){
        System.out.println("\n*******************************");
        HeapNode minNode = minHeap.extractMin();
        System.out.println("minNode: " + minNode);
        MinHeap.printHeapNodes(minHeap);
        MinHeap.printIdxArr(minHeap);
        System.out.println("*******************************\n");
    }

    public static void main(String[] args) {
        int vertices = 6;
        String[] nodeNameArr = {"a_0", "a_1", "a_2", "a_3", "a_4", "a_5"};
        Graph graph = new Graph(vertices, nodeNameArr); // 边里面的点 用 点的idx 表示
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 5, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        Graph.printVertices(graph);
        Graph.printAdjlist(graph);

        int[] keyArr = shuffleArr(6);

        printIntData.ver1arr("leetCode/arr", keyArr);

        System.out.println("\n\n><><><><><><><><><><><><><><><><><><><><><><><><>\n\n");
        /*
        ------------------------------------------------------------------------------------------------------------
         */

        MinHeap minHeap = createMinHeapFromGraph_2(graph, 0, keyArr);
        MinHeap.printHeapNodes(minHeap);
        MinHeap.printIdxArr(minHeap);

        System.out.println("decreaseKey");
        minHeap.decreaseKey(minHeap.mH[minHeap.oriToHeapIdxArr[3]].key - 5, 3);
        MinHeap.printHeapNodes(minHeap);
        MinHeap.printIdxArr(minHeap);

        extract(minHeap);

        extract(minHeap);

        extract(minHeap);
    }
}

