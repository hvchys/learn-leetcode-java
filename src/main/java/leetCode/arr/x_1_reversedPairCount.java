package leetCode.arr;

import Util.randNum;
import algoProblems.sort.x_3_bubble_sort;

public class x_1_reversedPairCount {

    public static int getReversedPairNum(int[] arr, int idxStart, int idxEnd){
        // 返回 leetCode.arr[idxStart] ~ leetCode.arr[idxEnd] 里面的逆序数量
        if(idxStart >= idxEnd)
            return 0;

        if(idxEnd - idxStart == 1){
            if(arr[idxStart] > arr[idxEnd])
                return 1;
            else
                return 0;
        }

        int mid = (idxStart + idxEnd)/2;

//        String[] nameArr = {"idxStart", "mid", "idxEnd"};
//        int[] valArr = {idxStart, mid, idxEnd};
//        printInfo.infoArr(nameArr, valArr);
//
//        int part1 = getReversedPairNum(leetCode.arr, idxStart, mid);
//        int part2 = getReversedPairNum(leetCode.arr, mid + 1, idxEnd);
//        int midAns = getPairBetweenToArrs(leetCode.arr, idxStart, mid, idxEnd);
//        String[] nameArr2 = {"part1", "part2", "midAns"};
//        int[] valArr2 = {part1, part2, midAns};
//        printInfo.infoArr(nameArr, valArr);
//        printInfo.infoArr(nameArr2, valArr2);

        return getReversedPairNum(arr, idxStart, mid) + getReversedPairNum(arr, mid + 1, idxEnd)
                + getPairBetweenToArrs(arr, idxStart, mid, idxEnd);
        // return part1 + part2 + midAns;
    }

    public static int getPairBetweenToArrs(int[] arr, int idxStart, int mid, int idxEnd){
        int len1 = mid - idxStart + 1;
        int len2 = idxEnd - mid;
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        System.arraycopy(arr, idxStart, arr1, 0, len1);
        System.arraycopy(arr, mid + 1, arr2, 0, len2);

        x_3_bubble_sort.sort(arr1);
        x_3_bubble_sort.sort(arr2);

        return getPairBetweenArrs(arr1, arr2);
    }

    public static int getPairBetweenArrs(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        /*
        1 2 3 7 8
        4 5 6 9
         */
        int count = 0;
        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < len1 && idx2 < len2){
            // System.out.println("idx1: " + idx1 + ", idx2: " + idx2);
            if(arr1[idx1] <= arr2[idx2]){
                idx1++;
            }else{
                count += (len1 - idx1);
                idx2++;
            }
        }

        return count;
    }


    public static int getPairAnsSimple(int[] arr1, int[] arr2){
        int count = 0;
        for(int x1: arr1){
            for(int x2: arr2){
                if(x1 > x2)
                    count++;
            }
        }
        return count;
    }

    public static int getArrAnsSimple(int[] arr, int idxStart, int idxEnd){
        // 返回 leetCode.arr[idxStart] ~ leetCode.arr[idxEnd] 里面的逆序数量
        int count = 0;
        for(int i = idxStart; i <= idxEnd; i++){
            for(int j = i + 1; j <= idxEnd; j++){
                if(arr[i] > arr[j])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
//        int[] arr1 = {1,3,4,6,9};
//        int[] arr2 = {2,5,7,8};
//
//        int ans = getPairBetweenArrs(arr1, arr2);
//        int ans_2 = getPairAnsSimple(arr1, arr2);
//
//        System.out.println(ans);
//        System.out.println(ans_2);

        int[] arr = new int[13];
        randNum.getIntArr(arr, 10, 40);

        // int[] leetCode.arr = {1,3,2};

        int ans1 = getReversedPairNum(arr, 0, arr.length - 1);
        int ans2 = getArrAnsSimple(arr, 0, arr.length - 1);

        System.out.println(ans1);
        System.out.println(ans2);

    }

}
