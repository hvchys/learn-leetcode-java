package algoProblems.sort;

import Util.printIntData;
import Util.randNum;

public class x_6_merge_sort_simple {

    public static void mergeSort(int[] arr, int idxStart, int idxEnd){
        /*
        mergeSort(leetCode.arr, l, r)
        如果 r > 1:
        1 找中间点: middle m = (l+r)/2
        2 对于前半部分: mergeSort(leetCode.arr, l, m)
        3 对于后半部分: mergeSort(leetCode.arr, m+1, r)
        4 把step2/3的俩结果合并: merge(leetCode.arr, l, m, r)
         */
        if(idxStart == idxEnd)
            return;
        if(idxEnd == 1 && idxStart == 0 && arr[idxStart] > arr[idxEnd]){
            util.swap(arr, idxStart, idxEnd);
            return;
        }

        if(idxEnd > 1){
            int mid = (idxStart + idxEnd)/2;
            mergeSort(arr, idxStart, mid);
            mergeSort(arr, mid + 1, idxEnd);
            int[] mergeArr = merge(arr, idxStart, idxEnd, mid);
            System.arraycopy(mergeArr, 0, arr, idxStart, idxEnd - idxStart + 1);
        }
        // idxEnd = 0 以及 其他情况
    }

    private static int[] merge(int[] arr, int idxStart, int idxEnd, int mid){
        int len1 = mid - idxStart + 1;
        int len2 = idxEnd - mid;
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len1];
        System.arraycopy(arr, idxStart, arr1, 0, len1);
        System.arraycopy(arr, mid + 1, arr2, 0, len2);
        return merge(arr1, arr2);
    }

    // 依次遍历这俩数组，把当前最小的那个放到结果里面
    private static int[] merge(int[] arr1, int[] arr2){
        // printIntData.ver1arr("merge: arr_1", arr1);
        // printIntData.ver1arr("merge: arr_2", arr2);

        int[] temp = new int[arr1.length + arr2.length];

        int index_1 = 0; // current index in arr1
        int index_2 = 0; // current index in arr2
        int index_3 = 0; // current index in temp

        while(index_1 < arr1.length && index_2 < arr2.length){
            if(arr1[index_1] < arr2[index_2]){
                temp[index_3] = arr1[index_1];
                index_1++;
                index_3++;
            } else{
                temp[index_3] = arr2[index_2];
                index_2++;
                index_3++;
            }
        }

        while(index_1 < arr1.length){
            temp[index_3] = arr1[index_1];
            index_1++;
            index_3++;
        }

        while(index_2 < arr2.length){
            temp[index_3] = arr2[index_2];
            index_2++;
            index_3++;
        }
        // printIntData.ver1arr("merge: ans", temp);
        return temp;
    }

    public static void sort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String args[]) {
        int[] oriArr = new int[8];
        randNum.getIntArr(oriArr, 10, 60);

        printIntData.ver1arr("", oriArr);
        sort(oriArr);
        printIntData.ver1arr("", oriArr);
    }
}
