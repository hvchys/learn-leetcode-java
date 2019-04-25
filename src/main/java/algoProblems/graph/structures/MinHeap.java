package algoProblems.graph.structures;

import Util.printIntData;

public class MinHeap {
    public int capacity;
    public int currentSize;
    public HeapNode[] mH; // 从 1 开始
    // HeapNode: 点的idx, 点的name, 点的distance
    // 数组 HeapNode[] 代表了这个堆
    // 改变堆里面的点的位置: 改变 数组 HeapNode[] 的顺序
    public int[] oriToHeapIdxArr; // 从 0 开始
    // 一个点，有俩idx, 一个是 HeapNode里面的oriIdx, 一个是 mH 里面的 idx
    // oriToHeapIdxArr[oriIdx] = idx;
    // mH[idx] = oriIdx

    public HeapNode oriIdxToNode(int oriIdx){
        int idx = this.oriToHeapIdxArr[oriIdx];
        // System.out.println("oriIdxToEdge: oriIdx: " + oriIdx + ", idx: " + idx);
        return this.mH[idx];
    }

    public static void printIdxArr(MinHeap minHeap){
        printIntData.arrWithIdx("oriToHeapIdxArr", minHeap.oriToHeapIdxArr);
    }

    public static void printHeapNodes(MinHeap minHeap){
        System.out.println("-----------------------------");
        System.out.println("最小堆 HeapNode:");
        HeapNode heapNode;
        for(int i = 1; i < minHeap.currentSize + 1; i++){
            heapNode = minHeap.mH[i];
            System.out.println("idx: " + i + ": " + heapNode);
        }
        System.out.println("-----------------------------");
    }

    public static MinHeap createMinHeapFromGraph(Graph graph, int sourceNodeIdx){
        // 得到 所有点 的 HeapNode
        HeapNode[] heapNodeArr = HeapNode.createHeapNodeSFromGraph(graph, sourceNodeIdx);
        // 把所有点，放到，堆里面
        MinHeap minHeap = new MinHeap(graph.vertexNum);
        for(HeapNode heapNode: heapNodeArr){
            minHeap.insert(heapNode);
        }
        return minHeap;
    }

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.mH = new HeapNode[capacity + 1]; // !! mH[0] 没东西 !!!
        this.oriToHeapIdxArr = new int[capacity];
        this.mH[0] = new HeapNode(new Vertex(-1, "xxEmpty"), Integer.MIN_VALUE);
        this.currentSize = 0;
    }

    // 把点 oriIdx 的 key 改变，然后调整堆
    public void decreaseKey(int newKey, int oriIdx){
        int idx = this.oriToHeapIdxArr[oriIdx];
        HeapNode node = this.mH[idx];
        node.key = newKey;
        bubbleUp(idx);
    }

    public void insert(HeapNode x) {
        // 把 要添加的点 放在 堆的最末尾，修改 mH 和 oriToHeapIdxArr
        // 然后，bubbleUp
        this.currentSize++;
        int idx = this.currentSize;
        this.mH[idx] = x;
        this.oriToHeapIdxArr[x.vertex.idx] = idx;
        bubbleUp(idx);
    }

    public void bubbleUp(int pos) {
        int parentIdx = pos/2;
        int currentIdx = pos;
        while (currentIdx > 0 && this.mH[parentIdx].key > this.mH[currentIdx].key) {
            HeapNode currentNode = this.mH[currentIdx];
            HeapNode parentNode = this.mH[parentIdx];

            // insert the positions
            this.oriToHeapIdxArr[currentNode.vertex.idx] = parentIdx;
            this.oriToHeapIdxArr[parentNode.vertex.idx] = currentIdx;
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx/2;
        }
    }

    public HeapNode extractMin() {
        if(isEmpty()){
            System.out.println("heap is empty!!!");
            return this.mH[0];
        }else{
            HeapNode min = this.mH[1];
            HeapNode lastNode = this.mH[this.currentSize];

            this.oriToHeapIdxArr[lastNode.vertex.idx] = 1;
            this.mH[1] = lastNode;
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
        if (leftChildIdx < heapSize() && this.mH[smallest].key > this.mH[leftChildIdx].key) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < heapSize() && this.mH[smallest].key > this.mH[rightChildIdx].key) {
            smallest = rightChildIdx;
        }
        if (smallest != k) {

            HeapNode smallestNode = this.mH[smallest];
            HeapNode kNode = this.mH[k];

            // insert the positions
            this.oriToHeapIdxArr[smallestNode.vertex.idx] = k;
            this.oriToHeapIdxArr[kNode.vertex.idx] = smallest;
            swap(k, smallest);
            sinkDown(smallest);
        }
    }

    public void swap(int a, int b) {
        HeapNode temp = this.mH[a];
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