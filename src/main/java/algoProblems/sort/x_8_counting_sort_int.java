package algoProblems.sort;

import Util.printIntData;

public class x_8_counting_sort_int {

    // leetCode.arr 里面元素取值范围: [0, max(leetCode.arr)]
    public static void sort(int[] arr) {
        int eleNum = arr.length;

        // 输出结果，排好序了
        int[] output = new int[eleNum];

        int maxVal = util.getMax(arr);

        System.out.println("max: " + maxVal);

        // 对每个元素 出现次数 计数
        int[] countArr = new int[maxVal+1];
        // int数组的元素的默认值 就是 0

        for (int x: arr)
            countArr[x]++;

        // countArr[] --> arr_2[]: arr_2[i]: 值<=i的元素的个数
        for (int i = 1; i <= maxVal; i++)
            countArr[i] += countArr[i-1];

        printIntData.arrWithIdx("countArr", countArr);

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = eleNum - 1; i >= 0; i--) {
            printIntData.arrWithIdx("\nstep " + i + ", before, output", output);
            printIntData.arrWithIdx("step " + i + ", before, countArr", countArr);

            output[countArr[arr[i]]-1] = arr[i];
            countArr[arr[i]]--;

            printIntData.arrWithIdx("step " + i + ", after, output", output);
            printIntData.arrWithIdx("step " + i + ", after, countArr", countArr);
        }

        printIntData.arrWithIdx("countArr", countArr);

        // 把结果 output[] 拷贝到 leetCode.arr[]
        System.arraycopy(output, 0, arr, 0, eleNum);
    }



    // Driver method
    public static void main(String args[]) {
        int[] arr = {2,13,14,22,2,5,1,3};
        sort(arr);

        printIntData.arrWithIdx("ans", arr);
    }
}
