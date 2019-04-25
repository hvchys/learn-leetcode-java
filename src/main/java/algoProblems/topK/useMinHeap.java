package algoProblems.topK;

import dataStructure.B_tree_heap_hash.xx_7_heap.MinHeap_intArr;

public class useMinHeap implements SolveTopK {
    /*
    假设要找数组 leetCode.arr 的 前 k 大元素
    1 用 leetCode.arr[0]~leetCode.arr[k-1] 建一个最小堆: 时间复杂度: O(k) (???)
    2 对于 leetCode.arr[k]~leetCode.arr[n-1] 的每一个元素 x，把这个元素和 堆 的root 比较:
      a. x <= root: 跳过
      b. x > root: 把 root 替换成 x, 对 新的root 做 sinkDown
    3 最终，留在堆里面的就是 topK
     */

    public int[] getTopK(int[] arr, int topK){
        int[] tempArr = new int[topK];
        System.arraycopy(arr, 0, tempArr, 0, topK);

        MinHeap_intArr minHeap = new MinHeap_intArr(topK);
        minHeap.createHeap(tempArr);

        int root;
        for(int i = topK; i < arr.length; i++){
            root = minHeap.peekRoot();
            if(arr[i] <= root)
                continue;
            else{
                minHeap.mH[1] = arr[i];
                minHeap.sinkDown(1);
            }
        }

        int[] ansArr = new int[topK];
        System.arraycopy(minHeap.mH, 1, ansArr, 0, topK);
        return ansArr;
    }



}
