package algoProblems.sort;

import Util.printIntData;
import Util.randNum;

public class x_1_quickSort_clear {
    // 目标: 从小到大排序

    // 把 最后一个元素 当做 pivot, 小于pivot的放在前面，大于pivot的放在后面
    // 处理 leetCode.arr[idxStart]~leetCode.arr[idxEnd]
    public static int partition(int[] arr, int idxStart, int idxEnd) {
        int pivot = arr[idxEnd], i = idxStart;
        for (int j = idxStart; j <= idxEnd - 1; j++) {
            if (arr[j] <= pivot) {
                // 互换 leetCode.arr[i] 和 leetCode.arr[j]
                util.swap(arr, i, j);
                i++;
            }
        }

        // 互换 leetCode.arr[i] 和 leetCode.arr[idxEnd]
        util.swap(arr, i, idxEnd);

        return i;
    }

    public static void sort(int[] arr, int idxStart, int idxEnd){
        // System.out.println("start: " + idxStart + ", end: " + idxEnd);
        if(idxStart >= idxEnd){
            return;
        }else if(idxEnd - idxStart == 1){
            if(arr[idxStart] > arr[idxEnd])
                util.swap(arr, idxStart, idxEnd);
        }else{
            int curPartition = partition(arr, idxStart, idxEnd);
            /*
             注意对子问题的划分: 这样写可能会出现这种错误:
             某次 idxStart idxEnd 对应的 partition 是这个数组的 idxEnd 然后这个程序就停不下来了
             sort(leetCode.arr, idxStart, curPartition);
             sort(leetCode.arr, curPartition + 1, idxEnd);
             */
            sort(arr, idxStart, curPartition - 1);
            sort(arr, curPartition + 1, idxEnd);
        }
    }


    public static void sort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args){
        int[] oriArr = new int[10];
        randNum.getIntArr(oriArr, 10, 60);

        printIntData.ver1arr("", oriArr);
        sort(oriArr);
        printIntData.ver1arr("", oriArr);


    }

}
