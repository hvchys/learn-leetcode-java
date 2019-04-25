package algoProblems.sort;

import Util.printIntData;
import Util.randNum;

public class x_1_quickSort_clear_partition {
    // 找 第 k 小

    public static void checkPartition(){
        int[] oriArr = new int[10];
        randNum.getIntArr(oriArr, 10, 60);

        int idxStart = 2;
        int idxEnd = 7;
        int[] idxArr = {idxStart, idxEnd};
        printIntData.arrWithMarkPart("ori", oriArr, idxArr, "index", idxStart, idxEnd);
        int partition = partition_v2(oriArr, idxStart, idxEnd);
        printIntData.arrWithIdxPart("", oriArr, idxStart, idxEnd);
        System.out.println("partition: " + partition);
    }

    /*
    // 把 idx / value 是 selArr 的值，标注出来
    // mark = "index" or "value"
    public static void arrWithMark(String info, int[] leetCode.arr, int[] selArr, String mark){
     */

    public static int partition_v2(int[] arr, int idxStart, int idxEnd) {
        int pivot = arr[idxEnd], i = idxStart;
        System.out.println("pivot: " + pivot + ", i: " + i);
        for (int j = idxStart; j <= idxEnd - 1; j++) {
            if (arr[j] <= pivot) {
                String info = "\nenter if: j: " + j + ", a[j]: " + arr[j] + ":";
                System.out.println(info);
                int[] selArr = {pivot, arr[j]};
                printIntData.arrWithMarkPart("", arr, selArr, "value", idxStart, idxEnd);
                // 互换 leetCode.arr[i] 和 leetCode.arr[j]
                util.swap(arr, i, j);
                System.out.println("after switch:");
                printIntData.arrWithMarkPart("", arr, selArr, "value", idxStart, idxEnd);
                i++;
                System.out.println("i: " + i);
            }
        }

        // 互换 leetCode.arr[i] 和 leetCode.arr[idxEnd]
        util.swap(arr, i, idxEnd);

        return i;
    }


    public static void main(String[] args){
        // 理解 partition
        checkPartition();

    }
}
