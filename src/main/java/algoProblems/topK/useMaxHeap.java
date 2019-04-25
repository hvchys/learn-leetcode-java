package algoProblems.topK;

import dataStructure.B_tree_heap_hash.xx_7_heap.MaxHeap_intArr;

public class useMaxHeap implements SolveTopK {

    public int[] getTopK(int[] arr, int topK){
        int[] ansArr = new int[topK];

        MaxHeap_intArr maxHeap = new MaxHeap_intArr(arr.length);
        maxHeap.createHeap(arr);
        maxHeap.printHeap("最大堆");

        for(int i = 0; i < topK; i++){
            ansArr[i] = maxHeap.extractRoot();
        }

        return ansArr;
    }
}
