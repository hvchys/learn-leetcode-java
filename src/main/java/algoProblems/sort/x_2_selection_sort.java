package algoProblems.sort;

import Util.printIntData;
import Util.randNum;

public class x_2_selection_sort {

    // 找到 leetCode.arr[idxStart] ~ leetCode.arr[idxEnd] 里面的最小值 的 idx
    // 这部分数组是无序的
    public static int getMin(int arr[], int idxStart, int idxEnd){
        int curMin = Integer.MAX_VALUE;
        int curMinIdx = -1;
        for(int i = idxStart; i <= idxEnd; i++){
            if(arr[i] < curMin){
                curMin = arr[i];
                curMinIdx = i;
            }
        }
        return curMinIdx;
    }

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) {
            int minIdx = getMin(arr, i, n-1);
            util.swap(arr, minIdx, i);
        }
    }

    public static void main(String args[]) {
        int[] oriArr = new int[8];
        randNum.getUniqueIntArr(oriArr, 10, 60);

        printIntData.ver1arr("", oriArr);
        sort(oriArr);
        printIntData.ver1arr("", oriArr);
    }
}
