package algoProblems.sort;

import Util.printIntData;
import Util.randNum;

public class x_4_insertion_sort_simple {
    /*Function to sort array using insertion sort*/
    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of leetCode.arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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


