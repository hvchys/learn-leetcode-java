package algoProblems.sort;

import Util.printIntData;
import Util.randNum;

public class x_6_merge_sort_save_space {
    // 目标: 从小到大排列

    // 把 俩 subarray 合并
    // leetCode.arr[idxStart..mid] 和 leetCode.arr[mid+1..idxEnd]
    public static void merge(int arr[], int idxStart, int mid, int idxEnd) {
        // Find sizes of two subarrays to be merged
        int len1 = mid - idxStart + 1;
        int len2 = idxEnd - mid;

        // 创建临时数组
        int[] arrLeft = new int[len1];
        int[] arrRight = new int[len2];

        System.arraycopy(arr, idxStart, arrLeft,0, len1);
        System.arraycopy(arr, mid + 1, arrRight,0, len2);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = idxStart;
        while (i < len1 && j < len2) {
            if (arrLeft[i] <= arrRight[j]) {
                arr[k] = arrLeft[i];
                i++;
            }
            else {
                arr[k] = arrRight[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of arrLeft[] if any */
        while (i < len1) {
            arr[k] = arrLeft[i];
            i++;
            k++;
        }

        /* Copy remaining elements of arrRight[] if any */
        while (j < len2) {
            arr[k] = arrRight[j];
            j++;
            k++;
        }
    }

    // Main function that sorts leetCode.arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void sort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }


    public static void main(String args[]) {
        int[] oriArr = new int[8];
        randNum.getUniqueIntArr(oriArr, 10, 60);

        printIntData.ver1arr("", oriArr);
        sort(oriArr);
        printIntData.ver1arr("", oriArr);
    }
}

