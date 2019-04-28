package leetCode.binarySearch;

import Util.printIntData;
import Util.randNum;
import algoProblems.sort.x_1_quickSort_clear;
//
//public class x_704_other_question {
//
//    /*
//    【二分查找、更复杂的版本】
//    修改了问题:
//    1 arr[i~j]里面, 找 k，使得 arr[k] <= x < arr[k+1]: 如果 arr 里面有多个元素和 x 相等，返回 最前面 那个
//    2 arr里面可以有重复内容
//
//     */
//
//    public static int binarySearch(int[] arr, int i, int j, int x){
//        int idxStart = i;
//        int idxEnd = j;
//        int mid = (idxStart + idxEnd)/2;
//
//        while(idxEnd - idxStart > 1){
//            if(arr[mid] > x){
//                idxEnd = mid;
//                mid = (idxStart + idxEnd)/2;
//            }else if(arr[mid] < x){
//                idxStart = mid;
//                mid = (idxStart + idxEnd)/2;
//            }else{
//                // arr[mid] == x
//                // 如果 arr 里面有多个元素和 x 相等，返回 最前面 那个
//                for(int k = mid; k >= i; k--){
//                    if(arr[k] < x)
//                        return (k+1);
//                }
//                return i; // 都相等
//            }
//        }
//        // System.out.println("idxStart: " + i + ", idxEnd: " + j + ", mid: " + mid);
//        // 还是 有可能 的 idxStart, idxEnd
//        if(x < arr[idxStart] || x > arr[idxEnd])
//            return -1;
//        else{
//            // x >= arr[idxStart] && x <= arr[idxEnd]
//            for(int k = idxEnd; k >= i; k--){
//                if(arr[k] < x)
//                    return (k+1);
//            }
//            return idxStart;
//        }
//    }
//
//
//
//    public static void checkBinarySearch(){
//        int valMin = 10;
//        int valMax = 25;
//        int eleNum = 8;
//        int[] arr = new int[eleNum];
//        randNum.getIntArr(arr, valMin, valMax);
//        x_1_quickSort_clear.sort(arr);
//
//        int x = randNum.randInt(valMin, valMax);
//        int ans = binarySearch(arr, 0, eleNum-1, x);
//        int ans_2 = simpleSearch(arr, 0, eleNum-1, x);
//        if(ans != ans_2){
//            System.out.println();
//            printIntData.arrWithIdx("", arr);
//            System.out.println("x: " + x);
//            System.out.println("my: " + ans + ", simple: " + ans_2);
//        }
//
//    }
//
//    public static void main(String[] args) {
//        int i = 0;
//        int errNum = 0;
//        while(i < 500){
//            checkBinarySearch();
//            i++;
//            errNum++;
//        }
//        System.out.println("errNum: " + errNum);
//
////        int i = 0;
////        while(i < 50000){
////            checkSimpleSearch();
////            i++;
////        }
//    }
//
//
//    public static int simpleSearch(int[] arr, int i, int j, int x){
//        /*
//        arr 是 升序 排列
//        1 arr[i~j]里面, 找 k，使得 arr[k] <= x < arr[k+1]: 如果 arr 里面有多个元素和 x 相等，返回 最前面 那个
//        2 arr里面可以有重复内容
//
//        01123566, 4
//         */
//
//        for(int k = i; k <= j-1; k++){
//            if(arr[k] <= x && x < arr[k+1])
//                return k;
//            else if(arr[k] > x)
//                return -1;
//        }
//        if(arr[j] == x)
//            return j;
//        else
//            return -100;
//    }
//
//    public static void checkSimpleSearch(){
//        int valMin = 10;
//        int valMax = 25;
//        int eleNum = 8;
//        int[] arr = new int[eleNum];
//        randNum.getIntArr(arr, valMin, valMax);
//        x_1_quickSort_clear.sort(arr);
//
//        int x = randNum.randInt(valMin, valMax);
//        int ans_2 = simpleSearch(arr, 0, eleNum-1, x);
//
//        // && !(x > arr[7])
//        if(ans_2 == -100 && !(x >= arr[7])){
//            System.out.println();
//            printIntData.arrWithIdx("", arr);
//            System.out.println("x: " + x);
//            System.out.println("simple: " + ans_2);
//        }
//    }
//}
