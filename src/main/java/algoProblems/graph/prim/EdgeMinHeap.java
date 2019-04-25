package algoProblems.graph.prim;

import Util.printIntData;
import algoProblems.graph.structures.Edge;
import algoProblems.graph.structures.Graph;
import algoProblems.graph.structures.Vertex;

public class EdgeMinHeap {
    public int capacity;
    public int currentSize;
    public Edge[] mH; // 从 1 开始
    // Edge: 点的oriIdx, 点的name, 点的distance, 点的end
    // 数组 Edge[] 代表了这个堆
    public int[] oriToHeapidxArr; // 从 0 开始
    // 一个点，有俩idx, 一个是 Edge 里面的oriIdx, 一个是 mH 里面的 idx
    // oriToHeapIdxArr[oriIdx] = idx;
    // mH[idx] = oriIdx

    public Edge oriIdxToEdge(int oriIdx){
        int idx = this.oriToHeapidxArr[oriIdx];
        // System.out.println("oriIdxToEdge: oriIdx: " + oriIdx + ", idx: " + idx);
        return this.mH[idx];
    }

    public static void printIdxArr(EdgeMinHeap minHeap){
        printIntData.arrWithIdx("oriToHeapIdxArr", minHeap.oriToHeapidxArr);
    }

    public static void printEdges(EdgeMinHeap minHeap){
        System.out.println("-----------------------------");
        System.out.println("最小堆 Edge:");
        Edge edge;
        for(int i = 1; i < minHeap.currentSize + 1; i++){
            edge = minHeap.mH[i];
            System.out.println("idx: " + i + ": " + edge);
        }
        System.out.println("-----------------------------");
    }

    public static EdgeMinHeap createMinHeapFromGraph(Graph graph, int sourceNodeIdx){
        EdgeMinHeap edgeMinHeap = new EdgeMinHeap(graph.vertexNum);
        Edge curEdge;
        Vertex curNode;
        for(Vertex node: graph.vertexArr){
            curNode = Vertex.deepCopy(node);
            curEdge = new Edge(new Vertex(-1, "xxEmpty"), curNode, Integer.MAX_VALUE);
            edgeMinHeap.insert(curEdge);
        }
        // 起点X的边，改成: Edge(X -> X), weight = 0
        edgeMinHeap.decreaseKey(0, sourceNodeIdx);
        Vertex sourceNode = graph.vertexArr[sourceNodeIdx];
        Edge sourceNodeEdge = edgeMinHeap.oriIdxToEdge(sourceNodeIdx);
        sourceNodeEdge.startVertex = Vertex.deepCopy(sourceNode);
        // edgeMinHeap.mH[edgeMinHeap.oriToHeapidxArr[sourceNodeIdx]]
        return edgeMinHeap;
    }

    public EdgeMinHeap(int capacity) {
        this.capacity = capacity;
        this.mH = new Edge[capacity + 1]; // !! mH[0] 没东西 ??
        this.oriToHeapidxArr = new int[capacity];
        this.mH[0] = new Edge(new Vertex(-1, "xxEmpty"), new Vertex(-1, "xxEmpty"), Integer.MIN_VALUE);
        this.currentSize = 0;
    }

    // 把点 idx 的 key 改变，然后调整堆
    // 这里的 idx, 是 oriIdx
    public void decreaseKey(int newKey, int oriIdx){
        int idx = this.oriToHeapidxArr[oriIdx];
        Edge curNodeEdge = this.mH[idx];
        curNodeEdge.weight = newKey;
        bubbleUp(idx);
    }

    public void insert(Edge edge) {
        this.currentSize++;
        int idx = this.currentSize;
        this.mH[idx] = edge;
        this.oriToHeapidxArr[edge.endVertex.idx] = idx;
        bubbleUp(idx);
    }

    public void bubbleUp(int pos) {
        int parentIdx = pos/2;
        int currentIdx = pos;
        while (currentIdx > 0 && this.mH[parentIdx].weight > this.mH[currentIdx].weight) {
            Edge currentNodeEdge = this.mH[currentIdx];
            Edge parentNodeEdge = this.mH[parentIdx];

            // insert the positions
            this.oriToHeapidxArr[currentNodeEdge.endVertex.idx] = parentIdx;
            this.oriToHeapidxArr[parentNodeEdge.endVertex.idx] = currentIdx;
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx/2;
        }
    }

    public Edge extractMin() {
        if(isEmpty()){
            System.out.println("heap is empty!!!");
            return this.mH[0];
        }else{
            Edge min = this.mH[1];
            Edge lastNodeEdge = this.mH[this.currentSize];

            this.oriToHeapidxArr[lastNodeEdge.endVertex.idx] = 1;
            this.mH[1] = lastNodeEdge;
            this.mH[this.currentSize] = null;
            this.currentSize--;
            sinkDown(1);
            return min;
        }
    }

    public void sinkDown(int k) {
        int smallest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k+1;
        // 这里写的非常非常 tricky!!! 比较的时候 用 smallest 来比较
        if (leftChildIdx < heapSize() && this.mH[smallest].weight > this.mH[leftChildIdx].weight) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < heapSize() && this.mH[smallest].weight > this.mH[rightChildIdx].weight) {
            smallest = rightChildIdx;
        }
        if (smallest != k) {
            Edge smallestNodeEdge = this.mH[smallest];
            Edge kNodeEdge = this.mH[k];

            // insert the positions
            this.oriToHeapidxArr[smallestNodeEdge.endVertex.idx] = k;
            this.oriToHeapidxArr[kNodeEdge.endVertex.idx] = smallest;
            swap(k, smallest);
            sinkDown(smallest);
        }
    }

    public void swap(int a, int b) {
        Edge temp = this.mH[a];
        this.mH[a] = this.mH[b];
        this.mH[b] = temp;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public int heapSize(){
        return this.currentSize;
    }
}