package str_char;

import java.util.ArrayList;
import java.util.List;

public class x_8_str_to_int {
    /*
    目标: 把 string 变成 int

    The function first discards as many whitespace characters as necessary until the first
    non-whitespace character is found.

    Then, starting from this character, takes an optional initial plus or minus sign followed
    by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which
    are ignored and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or
    if no such sequence exists because either str is empty or it contains only whitespace characters,
    no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

    注:
    1 只有 空格 ' ' 被当成空格
    2 int只考虑在区间 [-2^31, 2^31-1] 的，如果超过这个区间，就返回距离它最近的边界值

    例:
    "42" -> 42
    "    -42" -> -42

    "4193 with words" -> 4193
    Conversion stops at digit '3' as the next character is not a numerical digit.

    "words and 987" -> 0
    第一个字符是 w, 它不属于 【数字、+、-、空格】，所以认为结果是 0

    "  0000000000012345678" -> 12345678

     */

    /*
    int:
    上界: 2147483647: 2^31-1
    下界: -2147483648: -2^31
    2^31 = 2147483648
     */

    public static int myAtoi(String str) {
        // int: 对应的 char 的编码: (0: 48) ~ (9: 57)
        // 空格: 对应的 char 的编码: 32
        // 负号(-): 对应的 char 的编码: 45
        // 正号(+): 对应的 char 的编码: 43

        int eleNum = str.length();
        // 最开始的元素 必须是 【数字、+、-、空格】
        int firstValidStrIdx = getFirstValidStrIdx(str, eleNum);
        if(firstValidStrIdx == -1)
            return 0;
        char firstValidChar = str.charAt(firstValidStrIdx);
        boolean isPositive = true;
        int idxStart = firstValidStrIdx;
        // 如果是 +/- 得确保下一个元素是数字
        if(firstValidChar == '+' || firstValidChar == '-'){
            idxStart = firstValidStrIdx + 1;
            if(getNumeric(str, idxStart, eleNum) == -1)
                return 0;
        }
        if(firstValidChar == '-'){
            isPositive = false;
        }
        // 如果上面都不是的话: 那就: idxStart=firstValidStrIdx, isPositive=true
        Integer[] ansArr_0 = getIntArr(str, idxStart, eleNum);
        int[] ansArr = filterZero(ansArr_0);
        int checkBoundary = overBoundary(ansArr, isPositive);
        if(checkBoundary == 0){
            // 没越界
            return getAns(ansArr, isPositive);
        }else
            return checkBoundary;
    }

    public static int[] filterZero(Integer[] ansArr){
        // 把 前面的 0 过滤掉
        int eleNum = ansArr.length;
        int idxStart = 0;
        while(idxStart < eleNum && ansArr[idxStart] == 0)
            idxStart++;

        // 0123
        // 4 - 1
        // 1234
        // 4 - 0

        int selArrLen = eleNum - idxStart;
        if(selArrLen == 0)
            return new int[]{0};

        int[] selArr = new int[selArrLen];
        // System.out.println("idxStart: " + idxStart + ", selLen: " + selArrLen);
        // printIntData.ver1arr("ansArr", ansArr);
        // System.arraycopy(ansArr, idxStart, selArr, 0, selArrLen);
        for(int i = 0; i < selArrLen; i++)
            selArr[i] = ansArr[i + idxStart];
        return selArr;
    }

    public static int getAns(int[] ansArr, boolean isPositive){
        int ans = 0;
        int exp = 1;

        for(int i = ansArr.length - 1; i >= 0; i--){
            ans += ansArr[i]*exp;
            exp *= 10;
            // System.out.println(ans);
        }

        if(isPositive)
            return ans;
        else
            return -ans;
    }

    public static int getBoundary(boolean isPositive){
        if(isPositive)
            return Integer.MAX_VALUE;
        else
            return Integer.MIN_VALUE;
    }

    public static int overBoundary(int[] arr, boolean isPositive){
        /*
        返回值:
        越界: 返回 边界值
        没越界: 返回 0
         */
        /*
        int:
        上界: 2147483647: 2^31-1
        下界: -2147483648: -2^31
        2^31 = 2147483648
         */
        if(arr.length > 10){
            return getBoundary(isPositive);
        }else if(arr.length < 10)
            return 0;

        // 下面是，长度 正好 等于 10 的情况
        int[] bound = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        if(!isPositive){
            bound[9] = 8;
        }

        // 123: arr 从前往后，1,2,3
        // arr的位数，是 10 位，检查它的reverse 是不是越界了
        for(int i = 0; i < 10; i++){
            /*
            arr < bound: 不大 返回 false
            arr == bound: 平手，继续
            arr > bound: 大 返回 true
             */
            if(arr[i] < bound[i])
                return 0;
            else if(arr[i] > bound[i]){
                return getBoundary(isPositive);
            }
        }
        return getBoundary(isPositive);
    }

    public static Integer[] getIntArr(String str, int idxStart, int eleNum){
        List<Integer> ansList = new ArrayList<>();
        char curX;
        int curInt;
        // 已经确保 idxStart 肯定是数字了
        int curIdx = idxStart;
        while(curIdx < eleNum){
            curX = str.charAt(curIdx);
            curInt = getNumeric(curX);
            if(curInt == -1)
                break;
            ansList.add(curInt);
            curIdx++;
        }
        int idxEnd = curIdx - 1;

        Integer[] arr = new Integer[idxEnd - idxStart + 1];
        ansList.toArray(arr);
        return arr;
    }

    public static int getFirstValidStrIdx(String str, int eleNum){
        // 如果 碰到不合理的 就返回 -1
        char curX;
        for(int i = 0; i < eleNum; i++){
            curX = str.charAt(i);
            // 是 空格 就 继续了
            if(curX != ' '){
                // 不是 空格，就必须是 +/-/数字
                if(curX == '+' || curX == '-' || getNumeric(curX) >= 0)
                    return i;
                else
                    return -1;
            }
        }
        // 如果到这里，说明，全是空格
        return -1;
    }

    public static int getNumeric(String str, int idx, int eleNum){
        if(idx >= eleNum)
            return -1;
        int code = (int) str.charAt(idx);
        if(code >= 48 && code <= 57)
            return code - 48;
        else
            return -1;
    }

    public static int getNumeric(char x){
        int code = (int) x;
        if(code >= 48 && code <= 57)
            return code - 48;
        else
            return -1;
    }

    public static void test(String str){
        System.out.println(str + ": " + myAtoi(str));
    }

    public static void main(String[] args){

        test("4193 with words");

        test("words and 987");

        test("    -42");

        test("42");

        test("3");

        test("-2");

        test("  00000000001234");

        test("  -00000000001234");

        test("  0000000000 ");
    }
}
