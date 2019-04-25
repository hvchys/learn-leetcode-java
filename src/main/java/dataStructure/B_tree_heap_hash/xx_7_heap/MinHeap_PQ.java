package dataStructure.B_tree_heap_hash.xx_7_heap;

import java.util.PriorityQueue;

public class MinHeap_PQ {
    PriorityQueue<Integer> pq;

    public MinHeap_PQ() {
        this.pq = new PriorityQueue<Integer>();
    }

    public void insert(int[] x) {
        for (int i = 0; i < x.length; i++) {
            this.pq.offer(x[i]);
        }
    }

    public int peek() {
        return this.pq.peek();
    }

    public int extractMin() {
        return this.pq.poll();
    }

    public int getSize() {
        return this.pq.size();
    }

    public void print() {
        System.out.println(this.pq);
    }

}