package algoProblems.getKth;

import Util.printIntData;
import Util.randNum;
import algoProblems.sort.x_1_quickSort_clear;

public class useQuickSort {
    // 找 第 k 小

    // 互换 leetCode.arr[i] 和 leetCode.arr[j]
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 把 最后一个元素 当做 pivot, 小于pivot的放在前面，大于pivot的放在后面
    // 处理 leetCode.arr[idxStart]~leetCode.arr[idxEnd]
    public static int partition(int[] arr, int idxStart, int idxEnd) {
        int pivot = arr[idxEnd], i = idxStart;
        for (int j = idxStart; j <= idxEnd - 1; j++) {
            if (arr[j] <= pivot) {
                // 互换 leetCode.arr[i] 和 leetCode.arr[j]
                swap(arr, i, j);
                i++;
            }
        }

        // 互换 leetCode.arr[i] 和 leetCode.arr[idxEnd]
        swap(arr, i, idxEnd);

        return i;
    }

    // 对于 leetCode.arr[idxStart]~leetCode.arr[idxEnd], 找第 k 小元素
    // 假设: leetCode.arr[] 里面的元素是互不相同的
    public static int kthSmallest(int[] arr, int idxStart, int idxEnd, int k) {
        // 判断 k 是合理的值
        if(k > 0 && k <= idxEnd - idxStart + 1){
            // 做 Partiton
            int partition = partition(arr, idxStart, idxEnd);

            // 如果 position 正好是 k, 就可以返回了
            if (partition - idxStart == k-1)
                return arr[partition];
            else if(partition - idxStart > k-1){
                // 当前 partition 偏右，答案在左边
                return kthSmallest(arr, idxStart, partition-1, k);
            }else{
                // 当前 partition 偏左，答案在右边
                return kthSmallest(arr, partition+1, idxEnd, k-partition+idxStart-1);
            }
        }else{
            return Integer.MAX_VALUE;
        }
    }

    public static void check(int eleNum, int k){
        int[] oriArr = new int[eleNum];
        randNum.getUniqueIntArr(oriArr, 10, 60);

        int[] copyArr = new int[eleNum];
        System.arraycopy(oriArr, 0, copyArr, 0, oriArr.length);

        x_1_quickSort_clear.sort(copyArr);
        printIntData.ver1arr("ori_sort", copyArr);

        int ans = kthSmallest(oriArr, 0, oriArr.length - 1, k);
        System.out.println("第 " + k + " 小: " + ans);
    }

    public static void main(String[] args){
        check(10, 3);

        check(10, 13);
    }
}
