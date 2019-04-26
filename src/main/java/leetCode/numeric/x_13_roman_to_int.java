package leetCode.numeric;

import java.util.HashMap;

public class x_13_roman_to_int {

    // 占用 空间太大，感觉是因为 String[] ???




    /*
        输入范围: [1, 3999]
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

        I 放在 V(5) 和 X(10) 的前面: 4, 9
        X 放在 L(50) 和 C(100) 的前面: 40, 90
        C 放在 D(500) 和 M(1000) 的前面: 400, 900

        3 -> III
        4 -> IV
        9 -> IX
        58 ->  LVIII
        1994 -> MCMXCIV: M = 1000, CM = 900, XC = 90 and IV = 4
        1884             M = 1000, DCCC = 800
        3000 ->          MMM = 3000

        1994:
        col4  col3      col2    col1
        1000, 500, 100, 50, 10, 5, 1
           1,   1,   4,  1,  4, 0, 4
           M,   D,   C,  L,  X, V, I
              (一对儿)  (一对儿) (一对儿)
        1994 -> MCMXCIV: M = 1000, CM = 900, XC = 90 and IV = 4

        把 逆序的 找到，对应的值，减了，就可以了
        逆序: CM,CD, XC, IX: 对 C/X/I, 看它们后面有没有，使得它逆序的东西
             CCCM: 查附近 就可以 了
         */

    public static int romanToInt(String s) {
        HashMap<String, Integer> strToValMap = initializeVal();
        String[] arr = s.split("");
        int eleNum = arr.length;
        int ans = 0;
        String curStr;
        int curVal;
        for(int i = 0; i < eleNum; i++){
            curStr = arr[i];
            curVal = strToValMap.get(curStr);
            if(curStr.equals("C") && isReverse(arr, i, "M", "D", eleNum)){
                ans -= curVal;
                continue;
            }
            if(curStr.equals("X") && isReverse(arr, i, "C", "L", eleNum)){
                ans -= curVal;
                continue;
            }
            if(curStr.equals("I") && isReverse(arr, i, "X", "V", eleNum)){
                ans -= curVal;
                continue;
            }
            ans += curVal;
        }
        return ans;
    }

    public static boolean isReverse(String[] arr, int curIdx, String checkStr_1, String checkStr_2, int eleNum){
        // arr[curIdx] = curStr
        // 逆序: CM, XC, IX: 对 C/X/I, 看它们后面有没有，使得它逆序的东西: checkStr
        //      CCCM: 查附近 就可以 了
        int upperBound = Math.min(curIdx+3, eleNum-1);
        for(int i = curIdx + 1; i <= upperBound; i++){
            if(arr[i].equals(checkStr_1) || arr[i].equals(checkStr_2))
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
