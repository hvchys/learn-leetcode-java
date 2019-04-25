package algoProblems.sort;

import Util.printIntData;
import dataStructure.B_tree_heap_hash.xx_7_heap.MinHeap_intArr;

public class x_5_heap_sort {
    // 堆排序

    // 目标: 从小到大排序

    /*
      max heap: 每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
      min heap: 或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。

      解法: 建立一个 minHeap 然后把里面的元素，一个一个拿出来，就行了
     */

    private static int[] heapSort(int[] arr) {
        int arrLen = arr.length;
        MinHeap_intArr minHeap = new MinHeap_intArr(arr.length);
        minHeap.createHeap(arr);
        int[] ans = new int[arrLen];

        for(int i = 0; i < arrLen; i++)
            ans[i] = minHeap.extractRoot();

        return ans;
    }


    public static void main(String[] args){
        int[] inputArr = {8, 2, 5, 9, 1, 4, 7, 6};

        int[] ans = heapSort(inputArr);

        printIntData.ver1arr("heap sort", ans);

    }

}
