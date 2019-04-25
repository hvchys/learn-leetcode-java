package algoProblems.sort;

import Util.printIntData;

public class x_1_quickSort_hard {

    private static void QuickSort(int arr[], int low, int high) {
        /* 目标: 从小到大排序
           x_5_clone[low..high)
          每一轮对序列的调整，使得所有大于第一个元素key的元素位于key的右边，
          以及所有小于key的元素位于key左边
          最后分别对key左右两边的子序列作快速排序
        * */
        System.out.println("\nQuickSort: low: " + low + ", high: " + high);

        if (high - low < 2) {
            // 单元素区间
            System.out.println("单元素区间");
            return;
        }

        int key = arr[low];	/* 保存第一个元素 */
        int i = low, j = high - 1;

        while (i < j) {
            System.out.println("i: " + i + ", j: " + j + ", key: " + key);
            while (i < j && key <= arr[j]) {
                // 从后往前，找小于key的元素
                j--;
            }
            if (i < j) {
                // 将小于key的元素调整至key左边
                printIntData.arrWithIdx("if_1, step1: i: " + i + ", j: " + j, arr);
                // ver1arr[i++] = ver1arr[j];
                arr[i] = arr[j];
                i++;
                printIntData.arrWithIdx("      step2: i: " + i + ", j: " + j, arr);
            }
            while (i < j && arr[i] <= key) {
                // 从前往后，找大于key的元素
                i++;
            }
            if (i < j) {
                // 将大于key的元素调整至key右边
                printIntData.arrWithIdx("if_2, step1: i: " + i + ", j: " + j, arr);
                // ver1arr[j--] = ver1arr[i];
                arr[j] = arr[i];
                j--;
                printIntData.arrWithIdx("      step2: i: " + i + ", j: " + j, arr);
            }
        }
        arr[i] = key;	/* 将key置于正确位置 */
        printIntData.arrWithIdx("after while: i: " + i + ", j: " + j, arr);

        QuickSort(arr, low, i);
        QuickSort(arr, i + 1, high);
    }

    public static void main(String[] args){
        int arr_1[] = {88, 20, 54, 97, 45, 40, 51, 19, 6, 8, 84, 9, 27, 79, 99};
        int xxLen = arr_1.length;
        printIntData.arrWithIdx("", arr_1);
        QuickSort(arr_1, 0, xxLen);
        printIntData.arrWithIdx("\n", arr_1);
    }

}
