package algoProblems.sort;

import Util.printIntData;

public class x_3_bubble_sort {
    // 冒泡排序

    /**
     1 要排序的数据是整数
     2 数据存储在数组中
     3 数据以升序(从小到大)排列
     */

    public static void sort(int[] arr){
        boolean needNextPass = true;

        for(int k = 1; k < arr.length && needNextPass; k++){
            // System.out.println("k: "+k);

            // 这里先默认，不需要 next pass
            needNextPass = false;
            // 进行第 k 次的 pass:
            // 总共 N 个 元素
            // 第 k 次，处理: leetCode.arr[0] ~ leetCode.arr[N - k - 1]
            for(int i = 0; i < arr.length - k; i++){
                // System.out.println("i: " + i);

                // 如果逆序存在的话:
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    needNextPass = true;
                    // 为什么这里就需要 next pass了?
                    // 答: 不能确定 temp 比后面的内容小
                    //     可以确定 temp 比前面的内容大
                    // 目标: 升序(从小到大)

                    // printIntData.arrWithMark("", leetCode.arr, new int[]{leetCode.arr[i], leetCode.arr[i+1]}, "value");
                }
            }

        }
    }

    /*
    (00)88 (01)20 (02)54 (03)97 (04)19 (05)40 (06)51
    k: 1
    (**00)20 (**01)88 (02)54 (03)97 (04)19 (05)40 (06)51
    (00)20 (**01)54 (**02)88 (03)97 (04)19 (05)40 (06)51
    (00)20 (01)54 (02)88 (**03)19 (**04)97 (05)40 (06)51
    (00)20 (01)54 (02)88 (03)19 (**04)40 (**05)97 (06)51
    (00)20 (01)54 (02)88 (03)19 (04)40 (**05)51 (**06)97
    k: 2
    (00)20 (01)54 (**02)19 (**03)88 (04)40 (05)51 (06)97
    (00)20 (01)54 (02)19 (**03)40 (**04)88 (05)51 (06)97
    (00)20 (01)54 (02)19 (03)40 (**04)51 (**05)88 (06)97
    k: 3
    (00)20 (**01)19 (**02)54 (03)40 (04)51 (05)88 (06)97
    (00)20 (01)19 (**02)40 (**03)54 (04)51 (05)88 (06)97
    (00)20 (01)19 (02)40 (**03)51 (**04)54 (05)88 (06)97
    k: 4
    (**00)19 (**01)20 (02)40 (03)51 (04)54 (05)88 (06)97
    k: 5
    (00)19 (01)20 (02)40 (03)51 (04)54 (05)88 (06)97
     */


    public static void main(String[] args){
        int arr_1[] = {88, 20, 54, 97, 19, 40, 51};
        printIntData.arrWithIdx("", arr_1);
        sort(arr_1);
        printIntData.arrWithIdx("", arr_1);
    }

}
