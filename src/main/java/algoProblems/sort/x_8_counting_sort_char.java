package algoProblems.sort;

import Util.printIntData;


public class x_8_counting_sort_char {

    public static void sort(char arr[]) {
        int eleNum = arr.length;

        // 输出结果，排好序了
        char[] output = new char[eleNum];

        // 对每个元素 出现次数 计数
        int[] countArr = new int[256];
        for (int i = 0; i < 256; ++i)
            countArr[i] = 0;

        for (char c: arr)
            countArr[c]++;

        // arr_1[] --> arr_2[]: arr_2[i]: 值<=i的元素的个数
        for (int i = 1; i <= 255; ++i)
            countArr[i] += countArr[i-1];

        printIntData.ver1arr("countArr", countArr);

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = eleNum - 1; i >= 0; i--) {
            output[countArr[arr[i]]-1] = arr[i];
            countArr[arr[i]]--;
        }

        printIntData.ver1arr("countArr", countArr);

        // 把结果 output[] 拷贝到 leetCode.arr[]
        System.arraycopy(output, 0, arr, 0, eleNum);
    }

    public static void printCharArr(char[] arr){
        for(char i: arr)
            System.out.print(i + " ");
        System.out.println();
    }



    // Driver method
    public static void main(String args[]) {
        char[] arr = {'v', 'e', 'd', 'a', 'b'};
        sort(arr);

        printCharArr(arr);

//        System.out.println((int)'a'); // 97
//        System.out.println((int)'e'); // 101
//        System.out.println((int)'z'); // 122
    }
}
