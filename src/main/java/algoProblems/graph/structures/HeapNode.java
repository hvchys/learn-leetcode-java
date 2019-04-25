package algoProblems.graph.structures;

public class HeapNode{
    public Vertex vertex;
    public int key;

    public HeapNode(){};

    public HeapNode(Vertex vertex, int key){
        this.vertex = vertex;
        this.key = key;
    }

    @Override
    public String toString() {
        return "[" + this.vertex + ", key: " + this.key + "]";
    }

    public static HeapNode[] createHeapNodeSFromGraph(Graph graph, int sourceNodeIdx){
        // 每个点，建立一个 HeapNode
        // sourceNodeIdx: 值为0的点的idx
        HeapNode[] heapNodeArr = new HeapNode[graph.vertexNum];
        for (int i = 0; i < graph.vertexNum; i++) {
            heapNodeArr[i] = new HeapNode(graph.vertexArr[i], Integer.MAX_VALUE);
        }
        // decrease the key for the source node
        heapNodeArr[sourceNodeIdx].key = 0;

        return heapNodeArr;
    }

    public static HeapNode[] createHeapNodeSFromGraph(Graph graph){
        // 每个点，建立一个 HeapNode
        // sourceNodeIdx: 值为0的点的idx
        HeapNode[] heapNodeArr = new HeapNode[graph.vertexNum];
        for (int i = 0; i < graph.vertexNum; i++) {
            heapNodeArr[i] = new HeapNode(graph.vertexArr[i], Integer.MAX_VALUE);
        }
        return heapNodeArr;
    }

}


