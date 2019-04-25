package Util;

import java.text.DecimalFormat;
import java.util.HashSet;

public class printIntData {

    public static String intArrPartToStr(Integer[] arr, int startIdx, int endIdx){
        // 打印: arr[startIdx] ~ arr[endIdx]
        StringBuilder sb = new StringBuilder();
        assert endIdx > startIdx;
        for(int i = startIdx; i < endIdx; i++){
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[endIdx]);
        return sb.toString();
    }

    public static String intArrPartToStr(int[] arr, int startIdx, int endIdx){
        // 打印: arr[startIdx] ~ arr[endIdx]
        StringBuilder sb = new StringBuilder();
        assert endIdx > startIdx;
        for(int i = startIdx; i < endIdx; i++){
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[endIdx]);
        return sb.toString();
    }

    public static String strArrToStr(String[] arr){
        StringBuilder sb = new StringBuilder();
        for(String i: arr){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    // --------------------------------------------------------------------------------------
    // 带格式的话，这里默认 数组元素 和 index，都最多是两位数

    private static String strWithFormat(int x, String strFormat){
        // String strFormat = "00";
        DecimalFormat df = new DecimalFormat(strFormat);
        return df.format(x);
    }

    private static String addValMark(int cur_idx, int cur_val, HashSet<Integer> valSet){
        if(valSet.contains(cur_val)){
            return "(**" + strWithFormat(cur_idx, "00") + ")" + strWithFormat(cur_val, "00");
        }else{
            return "(" + strWithFormat(cur_idx, "00") + ")" + strWithFormat(cur_val, "00");
        }
    }

    private static String addIdxMark(int cur_idx, int cur_val, HashSet<Integer> idxSet){
        if(idxSet.contains(cur_idx)){
            return "(**" + strWithFormat(cur_idx, "00") + ")" + strWithFormat(cur_val, "00");
        }else{
            return "(" + strWithFormat(cur_idx, "00") + ")" + strWithFormat(cur_val, "00");
        }
    }

    // 把 idx / value 是 selArr 的值，标注出来
    // mark = "index" or "value"
    public static void arrWithMark(String info, int[] arr, int[] selArr, String mark){
        int last = arr.length - 1;
        arrWithMarkPart(info, arr, selArr, mark, 0, last);
    }

    // 只打印，index = [first, last] 的部分
    // 把 idx / value 是 selArr 的值，标注出来
    // mark = "index" or "value"
    // 把 idx / value 是 selArr 的值，标注出来
    // mark = "index" or "value"
    public static void arrWithMarkPart(String info, int[] arr, int[] selArr, String mark, int first, int last){
        HashSet<Integer> selSet = new HashSet<Integer>();
        for(int i: selArr){
            selSet.add(i);
        }
        int selLen = last - first + 1;
        String[] strArr = new String[selLen];

        int i = 0;
        int selIdx = first;
        String curStr;
        if(mark.equals("index")){
            while(selIdx <= last){
                curStr = addIdxMark(selIdx, arr[selIdx], selSet);
                strArr[i] = curStr;
                selIdx++;
                i++;
            }
        }else{
            while(selIdx <= last){
                curStr = addValMark(selIdx, arr[selIdx], selSet);
                strArr[i] = curStr;
                selIdx++;
                i++;
            }
        }
        String allStr = strArrToStr(strArr);
        if(info.equals("")){
            System.out.println(allStr);
        }else{
            System.out.println(info + ": "+ allStr);
        }
    }

    public static void arrWithIdx(String info, int[] arr){
        int last = arr.length - 1;
        arrWithIdxPart(info, arr, 0, last);
    }

    // 只打印，index = [first, last] 的部分
    public static void arrWithIdxPart(String info, int[] arr, int first, int last){
        int selLen = last - first + 1;
        String[] strArr = new String[selLen];
        String curStr;

        int i = 0;
        int selIdx = first;
        while(selIdx <= last){
            curStr = "(" + strWithFormat(selIdx, "00") + ")" + strWithFormat(arr[selIdx], "00");
            strArr[i] = curStr;
            selIdx++;
            i++;
        }
        String allStr = strArrToStr(strArr);
        if(info.equals("")){
            System.out.println(allStr);
        }else{
            System.out.println(info + ": "+ allStr);
        }
    }

    public static void ver1arrPart(String info, int[] arr, int startIdx, int endIdx){
        String allStr = intArrPartToStr(arr, startIdx, endIdx);
        if(info.equals("")){
            System.out.println(allStr);
        }else{
            System.out.println(info + ": "+ allStr);
        }
    }

    public static void ver1arr(String info, int[] arr){
        String allStr = intArrPartToStr(arr, 0, arr.length - 1);
        if(info.equals("")){
            System.out.println(allStr);
        }else{
            System.out.println(info + ": "+ allStr);
        }
    }

    public static void ver1arr(String info, Integer[] arr){
        String allStr = intArrPartToStr(arr, 0, arr.length - 1);
        if(info.equals("")){
            System.out.println(allStr);
        }else{
            System.out.println(info + ": "+ allStr);
        }
    }

    public static void ver2arr(String info, int[][] arr){
        int ver1Len = arr.length;
        System.out.println(info + ":\n-------------------------");
        for(int i = 0; i < ver1Len; i++){
            ver1arr("idx " + Integer.toString(i), arr[i]);
        }
        System.out.println("-------------------------");
    }

}
