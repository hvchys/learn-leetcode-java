package algoProblems.sort;

import Util.printIntData;

public class x_7_radix_sort {

    // exp 代表的位数为 XX
    // 对于 leetCode.arr[0~(n-1)], 根据 XX位数 排序
    public static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] digitCountArr = new int[10];
        // Arrays.fill(digitCountArr,0);

        // 对于 leetCode.arr[0~(n-1)], 记录XX位数的各个数字出现的次数
        for (i = 0; i < n; i++)
            digitCountArr[ (arr[i]/exp)%10 ]++;

        // 对于 leetCode.arr[0~(n-1)], digitCountArr[i]: 数组里面 XX位数 <= i 的元素个数
        for (i = 1; i < 10; i++)
            digitCountArr[i] += digitCountArr[i - 1];

        // 得到输出数组
        for (i = n - 1; i >= 0; i--) {
            // !!! 这里这样子循环，可以保证，当前XX位数相同的元素 他们的新的顺序和 以前的 一样
            output[digitCountArr[ (arr[i]/exp)%10 ] - 1] = arr[i];
            digitCountArr[ (arr[i]/exp)%10 ]--;
        }

        // 把 output[] 拷贝到 leetCode.arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }

    // The main function to that sorts leetCode.arr[] of size n using
    // Radix Sort
    // 对 leetCode.arr[0~(n-1)] 排序
    public static void sort(int arr[], int n) {
        // 找最大值，从而知道最多多少位数
        int m = util.getMax(arr, n);

        // 从 个位数 开始 排序
        for (int exp = 1; m/exp > 0; exp *= 10){
            countSort(arr, n, exp);
            printIntData.ver1arr("exp: " + exp, arr);
        }

    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        sort(arr, n);

        printIntData.ver1arr("", arr);
    }
}

