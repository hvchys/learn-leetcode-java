package algoProblems.sort;

import Util.printIntData;
import Util.randNum;

public class x_4_insertion_sort_binary {
    // 目标: 从小到大排序

    // 把 leetCode.arr[idxEnd+1] 插到 leetCode.arr[0~idxEnd] 里面，插入位置是 idx
    public static void insert(int[] arr, int idxEnd, int idx){
        if(idxEnd + 1 == idx)
            return;

        int insertVal = arr[idxEnd + 1];

        for(int j = idxEnd + 1; j > idx; j--){
            arr[j] = arr[j - 1];
        }
        arr[idx] = insertVal;
    }

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int newIdx = BinarySearch.getXPlace(arr, 0, i-1, i);
            System.out.println("\n\ni: " + i + ", newIdx: " + newIdx);
            printIntData.arrWithIdx("before insert: ", arr);
            insert(arr, i - 1, newIdx);
            printIntData.arrWithIdx("after insert: ", arr);
        }
    }

    public static void main(String args[]) {
        int[] oriArr = new int[8];
        randNum.getIntArr(oriArr, 10, 60);

        printIntData.ver1arr("", oriArr);
        sort(oriArr);
        printIntData.ver1arr("", oriArr);
    }
}


