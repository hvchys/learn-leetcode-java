package dataStructure.B_tree_heap_hash.xx_7_heap;

public class run_2_heap_pq {
    public static void main(String args[]){
        int[] arrA = { 1, 6, 2, 9, 4, 3, 8 };
        MinHeap_PQ i = new MinHeap_PQ();
        i.insert(arrA);
        i.print();
        System.out.println("返回，并删除最小元素: " + i.extractMin());
        System.out.println("返回，并删除最小元素: " + i.extractMin());
        System.out.println("返回，并删除最小元素: " + i.extractMin());
        System.out.println("queue size: " + i.getSize());
    }
}
