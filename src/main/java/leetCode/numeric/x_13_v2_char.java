package leetCode.numeric;

import java.util.HashMap;

public class x_13_v2_char {

    // 改成用 char
    // 还是 占空间

    public static int romanToInt(String s) {
        HashMap<String, Integer> strToValMap = initializeVal();
        char[] arr = s.toCharArray();
        int eleNum = arr.length;
        int lastIdx = eleNum - 1;
        int ans = 0;
        char curChar;
        int curVal;
        for(int i = 0; i < eleNum; i++){
            curChar = arr[i];
            curVal = strToValMap.get(String.valueOf(curChar));
            if(curChar == 'C' && isReverse(arr, i, 'M', 'D', lastIdx)){
                ans -= curVal;
                continue;
            }
            if(curChar == 'X' && isReverse(arr, i, 'C', 'L', lastIdx)){
                ans -= curVal;
                continue;
            }
            if(curChar == 'I' && isReverse(arr, i, 'X', 'V', lastIdx)){
                ans -= curVal;
                continue;
            }
            ans += curVal;
        }
        return ans;
    }

    public static boolean isReverse(char[] arr, int curIdx, char checkStr_1, char checkStr_2, int lastIdx){
        // arr[curIdx] = curStr
        // 逆序: CM, XC, IX: 对 C/X/I, 看它们后面有没有，使得它逆序的东西: checkStr
        //      CCCM: 查附近 就可以 了
        int upperBound = Math.min(curIdx+3, lastIdx);
        for(int i = curIdx + 1; i <= upperBound; i++){
            if(arr[i] == checkStr_1 || arr[i] == checkStr_2)
                return true;
        }
        return false;
    }

    public static HashMap<String, Integer> initializeVal(){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("I", 1); //
        hashMap.put("V", 5);
        hashMap.put("X", 10); //
        hashMap.put("L", 50);
        hashMap.put("C", 100); //
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        return hashMap;
    }


}
