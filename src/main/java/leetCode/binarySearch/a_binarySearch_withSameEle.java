package leetCode.binarySearch;

import Util.printIntData;

import Util.randNum;
import algoProblems.sort.x_1_quickSort_clear;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class a_binarySearch_withSameEle {

    // 【这个问题我想不清楚】【答案没错，但是我不是很理解】
    // arr[i~j]里面, 找 k，使得 arr[k] < x < arr[k+1]: 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
    // 如果 x 比所有元素大 or x 比所有元素小 返回 -1
    // 如果 x < arr[i]: 返回 -1
    // 如果 x > arr[j]: 返回 -1

    public static int count_a1 = 0;
    public static int count_a2 = 0;
    public static int count_a3 = 0;
    public static int count_a4 = 0;
    public static int count_a5 = 0;
    public static int count_a6 = 0;
    public static int count_a7 = 0;
    public static int count_a8 = 0;
    public static ArrayList<String> xxCheck_1 = new ArrayList<String>();
    public static ArrayList<String> xxCheck_2 = new ArrayList<String>();
    public static ArrayList<String> xxCheck_3 = new ArrayList<String>();
    public static ArrayList<String> xxCheck_4 = new ArrayList<String>();
    public static ArrayList<String> xxCheck_5 = new ArrayList<String>();
    public static ArrayList<String> xxCheck_6 = new ArrayList<String>();

    public static String getCurStr(int[] arr, int idxStart, int idxEnd, int midIdx, double x){
        int eleNum = arr.length;
        String arrStr = printIntData.intArrPartToStr(arr, 0, eleNum-1);
        String curPosiStr = "idxStart: " + idxStart + ", idxEnd: " + idxEnd + ", midIdx: " + midIdx;
        return arrStr + "\nx: " + x + "\n" + curPosiStr;
    }

    public static Pair<Integer, String> binarySearch(int[] arr, double x){
        int idxStart = 0;
        int idxEnd = arr.length - 1;
        int mid = (idxStart + idxEnd)/2;

        String curStr;

        while(idxEnd - idxStart > 1){
            if(arr[mid] > x){
                idxEnd = mid;
                mid = (idxStart + idxEnd)/2;
            }else if(arr[mid] < x){
                idxStart = mid;
                mid = (idxStart + idxEnd)/2;
            }else{
                // arr[mid] == x
                // 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
                for(int k = mid; k >= 0; k--){
                    if(arr[k] < x){
                        count_a7++; // 会在这里出现
                        // return (k+1);
                        return new Pair<>(k+1, getCurStr(arr, idxStart, idxEnd, mid, x));
                    }
                }
                count_a8++; // 会在这里出现
                // return 0; // 都相等
                return new Pair<>(0, getCurStr(arr, idxStart, idxEnd, mid, x));
            }
        }

        // 还是 有可能 的 idxStart, idxEnd
        /*
        经过检查，idxStart, idxEnd之间的关系只有两种:
        [*1] idxEnd - idxStart == 1
        [*2] idxStart == idxEnd (这个 好像 也 不可能 ???) (检查了，是不可能，但是我想不通)
        [*3] 再不会有别的了，为啥

         */

        // count_a1: 不会在这里出现，不知道为啥
        if(idxEnd == idxStart){
            count_a1++;
            System.out.println("idxStart == idxEnd");
        }

        // count_a2: 会在这里出现
        if(x < arr[idxStart] || x > arr[idxEnd]){
            count_a2++;
            curStr = getCurStr(arr, idxStart, idxEnd, mid, x);
            xxCheck_2.add(curStr);
            return new Pair<>(-1, curStr);
        }
        // 到这里了，那就只能是这种: arr[idxStart] <= x <= arr[idxEnd]
        // count_a3: 会在这里出现
        if(arr[idxStart] < x && x <= arr[idxEnd]){
            count_a3++;
            curStr = getCurStr(arr, idxStart, idxEnd, mid, x);
            xxCheck_3.add(curStr);
            return new Pair<>(idxStart, curStr);
        }
        if(arr[idxStart] == x){
            if(idxStart != 0){ // 这里，idxStart 肯定是 0
                curStr = getCurStr(arr, idxStart, idxEnd, mid, x);
                System.out.println("\n" + curStr);
            }

            for(int k = idxStart; k >= 0; k--){
                if(arr[k] < x){
                    // count_a4: 不会在这里出现，不知道为啥
                    count_a4++;
                    curStr = getCurStr(arr, idxStart, idxEnd, mid, x);
                    xxCheck_4.add(curStr);
                    // return (k+1);
                    return new Pair<>(k+1, curStr);
                }
            }
            // count_a5: 会在这里出现
            count_a5++;
            curStr = getCurStr(arr, idxStart, idxEnd, mid, x);
            xxCheck_5.add(curStr);
            return new Pair<>(0, curStr);
        }
        // count_a6: 不会在这里出现，不知道为啥
        count_a6++;
        curStr = getCurStr(arr, idxStart, idxEnd, mid, x);
        xxCheck_6.add(curStr);
        return new Pair<>(-1000, curStr);

    }



    public static int binarySearch_2(int[] arr, double x){
        // arr[i~j]里面, 找 k，使得 arr[k] < x < arr[k+1]: 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
        // 如果 x 比所有元素大 or x 比所有元素小 返回 -1
        // 如果 x < arr[i]: 返回 -1
        // 如果 x > arr[j]: 返回 -1
        int idxStart = 0;
        int idxEnd = arr.length - 1;
        int mid = (idxStart + idxEnd)/2;

        while(idxEnd - idxStart > 1){
            if(arr[mid] > x){
                idxEnd = mid;
                mid = (idxStart + idxEnd)/2;
            }else if(arr[mid] < x){
                idxStart = mid;
                mid = (idxStart + idxEnd)/2;
            }else{
                // arr[mid] == x
                // 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
                for(int k = mid; k >= 0; k--){
                    if(arr[k] < x){
                        return (k+1);
                    }
                }
                return 0;
            }
        }

        /*
        经过检查，idxStart, idxEnd之间的关系只有 1 种:
        [*1] idxEnd - idxStart == 1

        (00)11 (01)14 (02)14 (03)17 (04)17 (05)17 (06)20 (07)24
        x: 24
        my: 6, simple: 7

         */

        if(x < arr[idxStart] || x > arr[idxEnd]){
            return -1;
        }
        // 到这里了，那就只能是: arr[idxStart] <= x <= arr[idxEnd]
        if(arr[idxStart] < x && x < arr[idxEnd]){
            return idxStart;
        }
        if(x == arr[idxStart])
            return idxStart;

        if(x == arr[idxEnd])
            return idxEnd;

        // return i;
//        if(arr[idxStart] == x){ // 这里，idxStart 肯定是 0
//            return 0;
//        }
//        return -100;
        return -100;

    }


    public static boolean checkOnlyBinarySearch(){
        int valMin = 10;
        int valMax = 25;
        int eleNum = 40;
        int[] arr = new int[eleNum];
        randNum.getIntArr(arr, valMin, valMax);
        x_1_quickSort_clear.sort(arr);

        int x = randNum.randInt(valMin, valMax);
        Pair<Integer, String> ans = binarySearch(arr, x);
        // System.out.println(ans.getKey());
        if(ans.getKey() == -1000){
            System.out.println(ans.getValue());
            return true;
        }
        else
            return false;
    }

    public static boolean checkBinarySearch(){
        int valMin = 10;
        int valMax = 25;
        int eleNum = 8;
        int[] arr = new int[eleNum];
        randNum.getIntArr(arr, valMin, valMax);
        x_1_quickSort_clear.sort(arr);

        int x = randNum.randInt(valMin, valMax);
        int ans = binarySearch_2(arr, x);
        int ans_2 = simpleSearch(arr, x);
        if(ans != ans_2){
            System.out.println();
            printIntData.arrWithIdx("", arr);
            System.out.println("x: " + x);
            System.out.println("my: " + ans + ", simple: " + ans_2);
            return false;
        }else
            return true;
    }

    public static void main(String[] args) {
        int i = 0;
        int errNum = 0;
        while(i < 500){
            if(!checkBinarySearch()){
                errNum++;
            }
            i++;
        }
        System.out.println("errNum: " + errNum);



//
//        int i = 0;
//        int errNum = 0;
//        while(i < 500000){
//            if(checkOnlyBinarySearch()){
//                errNum++;
//            }
//            i++;
//        }
//
//        System.out.println("errNum: " + errNum);
//        System.out.println("count_a1: " + count_a1);
//        System.out.println("count_a2: " + count_a2);
//        System.out.println("count_a3: " + count_a3);
//        System.out.println("count_a4: " + count_a4);
//        System.out.println("count_a5: " + count_a5);
//        System.out.println("count_a6: " + count_a6);
//        System.out.println("count_a7: " + count_a7);
//        System.out.println("count_a8: " + count_a8);

    }


    public static int simpleSearch(int[] arr, int x){
        /*
        arr 是 升序 排列
        1 arr[i~j]里面, 找 k，使得 arr[k] <= x < arr[k+1]: 如果 arr 里面有多个元素和 x 相等，返回 最前面 那个
        2 arr里面可以有重复内容

        01123566, 4
         */

        int eleNum = arr.length;

        // 情形1: 有元素 和 x 相等
        HashSet<Integer> eleSet = new HashSet<Integer>();
        for(int cur: arr){
            eleSet.add(cur);
        }
        if(eleSet.contains(x)){
            // 从前往后找吧
            for(int i = 0; i < eleNum; i++){
                if(arr[i] == x)
                    return i;
            }
        }

        // 情形2: 没有元素 和 x 相等
        for(int i = 0; i < eleNum-1; i++){
            if(arr[i] < x && x < arr[i+1])
                return i;
        }
        return -1;
    }

    public static void checkSimpleSearch(){
        int valMin = 10;
        int valMax = 25;
        int eleNum = 8;
        int[] arr = new int[eleNum];
        randNum.getIntArr(arr, valMin, valMax);
        x_1_quickSort_clear.sort(arr);

        int x = randNum.randInt(valMin, valMax);
        int ans_2 = simpleSearch(arr, x);

        // && !(x > arr[7])
        if(ans_2 == -100 && !(x >= arr[7])){
            System.out.println();
            printIntData.arrWithIdx("", arr);
            System.out.println("x: " + x);
            System.out.println("simple: " + ans_2);
        }
    }


    public static int simpleSearch(int[] arr, int idx1, int idx2, int x){
        int eleNum = idx2 - idx1 + 1;

        // 情形1: 有元素 和 x 相等
        HashSet<Integer> eleSet = new HashSet<Integer>();
        for(int cur: arr){
            eleSet.add(cur);
        }
        if(eleSet.contains(x)){
            // 从前往后找吧
            for(int i = idx1; i < eleNum; i++){
                if(arr[i] == x)
                    return i;
            }
        }

        // 情形2: 没有元素 和 x 相等
        for(int i = idx1; i <= idx2; i++){
            if(arr[i] < x && x < arr[i+1])
                return i;
        }
        return -1;
    }
}
