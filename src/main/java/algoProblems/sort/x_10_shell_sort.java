package algoProblems.sort;

import Util.printIntData;
import Util.randNum;

public class x_10_shell_sort {

    public static void sort(int arr[]) {
        int eleNum = arr.length;

        // Start with a big gap, then reduce the gap
        // 一开始 gap 比较大，然后减小 gap
        for (int gap = eleNum/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < eleNum; i++) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
    }

    // Driver method
    public static void main(String args[]) {
        int[] oriArr = new int[8];
        randNum.getIntArr(oriArr, 10, 60);

        printIntData.ver1arr("", oriArr);
        sort(oriArr);
        printIntData.ver1arr("", oriArr);

    }
}