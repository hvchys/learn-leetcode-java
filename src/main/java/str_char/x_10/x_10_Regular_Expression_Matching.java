package str_char.x_10;

public class x_10_Regular_Expression_Matching {
    /*
    给定: string(s), pattern(p), 判断 string 是否满足该 pattern
    pattern(p), 包含 '.' '*'

    '.' 任意 单个的 character.
    '*' 0个或多个，之前的元素

    注:
    s: 空，或者 只包含 小写 a-z
    p: 空，或者 只包含 小写 a-z & '.' & '*'

    例1:
    s = "aa", p = "a" -> false
    整个string "aa" 不符合 格式"a"

    例2:
    s = "aa"; p = "a*" -> true

    例3:
    s = "ab"; p = ".*" -> true
    Explanation: ".*" means "zero or more (*) of any character (.)".

    例4:
    s = "aab"; p = "c*a*b" -> true
    注: c可以被重复 0 遍，a可以被重复 2 遍

    例5:
    Input:
    s = "mississippi"; p = "mis*is*p*." -> false
     */

    public static boolean isEmptyPattern(String p){
        // 这里:
        // p 的 长度 > 0
        // p 肯定是 合理的【开头不是 *
        // 判断: pattern p 是否可以有实例是 空字符串
        int xxLen = p.length();
        if(xxLen % 2 != 0)
            return false;
        for(int i = 1; i < xxLen; i+=2){
            if(p.charAt(i) != '*')
                return false;
        }
        return true;
    }

    public static boolean isMatch(String str, String p){
        if(str == null || p == null)
            return false;

        /*
        str: 空,   p: 空: true
        str: 非空, p: 空: false
        str: 空,   p: 非空: 得确定 p 可以有实例是 空
        str: 非空, p: 非空: 往下走
         */
        if(p.isEmpty())
            return str.isEmpty();
        // 接下来，p肯定 非空
        // 保证 p 是 合理的
        if(isErrorP(p))
            return false;
        if(str.isEmpty())
            return isEmptyPattern(p);


        /*
        S: 长度为 M
        P: 长度为 N
        【由 大 求 小，从前往后，感觉 复杂度很高】
        isMatch(S(M), P(N)):
        1. P[0] = a-z
           0) P[1] 不存在
           1) P[1] = *
              看 S 里面等于 P[0] 的东西有多少，各种可能 满足一个 就可以
           2) P[1] != *
              看 S[0] 是否等于 P[0]
        2. P[0] = .
           0) P[1] 不存在
           1) P[1] = *
           2) P[1] = a-z
           3) P[1] = .

         */

        // 它俩 长度都 大于0
        char s0 = str.charAt(0);
        char p0 = p.charAt(0);
        char p1;
        int pLen = p.length();
        int sLen = str.length();
        if(isAZ(p0)){
            if(pLen == 1){
                // P[1] 不存在
                return (sLen == 1) && (str.charAt(0) == p0);
            }else{
                p1 = p.charAt(1);
                if(p1 == '*'){
                    // P[1] = *: 看 S 里面等于 P[0] 的东西有多少，各种可能 满足一个 就可以
                    // p0=a, str: aaab, ab, b
                    // str: aaab: isMatchPart(aaab/aab/ab/b)
                    int firstErrorIdx = getFirstErrorIdx(str, p0);
                    String[] subStrArr = getPossibleSubStr(str, firstErrorIdx);
                    String p2 = p.substring(2);
                    return getAnsNextLevel(subStrArr, p2);
//                    for(String subStr: subStrArr){
//                        if(isMatch(subStr, p2))
//                            return true;
//                    }
//                    return false;
                }else{
                   // P[1] != *: 看 S[0] 是否等于 P[0]
                    return (s0 == p0) && isMatch(str.substring(1), p.substring(1));
//                   if(s0 == p0)
//                       return isMatch(str.substring(1), p.substring(1));
//                   else
//                       return false;
                }
            }
        }else if(p0 == '.'){
            /*
            0) P[1] 不存在
            1) P[1] = *
            2) P[1] = a-z
            3) P[1] = .
             */
            if(pLen == 1){
                // P[1] 不存在
                return sLen == 1;
            }else{
                p1 = p.charAt(1);
                if(p1 == '*'){
                    // str, ".*XXX": ".*": 爱啥啥
                    String[] allSubStrArr = getAllSubStrArr(str, sLen);
                    return getAnsNextLevel(allSubStrArr, p.substring(2));
                }else{
                    // p1='.' / p1: a-z
                    return isMatch(str.substring(1), p.substring(1));
                }
            }
        }else{
            // System.out.println("error!!!");
            return false;
        }
    }

    public static boolean getAnsNextLevel(String[] subStrArr, String p2){
        for(String subStr: subStrArr){
            if(isMatch(subStr, p2))
                return true;
        }
        return false;
    }

    public static String[] getAllSubStrArr(String str, int xxLen){
        String[] ans = new String[xxLen + 1];
        for(int i = 0; i <= xxLen; i++){
            ans[i] = str.substring(i);
        }
        return ans;
    }

    public static int getFirstErrorIdx(String str, char p0){
        // 返回 从前往后 str里面 第一个 不是 p0 的 元素的 idx
        for(int i = 0; i < str.length(); i++){
             if(str.charAt(i) != p0)
                 return i;
        }
        return -1;
    }

    public static String[] getPossibleSubStr(String str, int idx){
        // str: aaab: isMatchPart(aaab/aab/ab/b)
        //      0123
        if(idx == -1)
            return getAllSubStrArr(str, str.length());

        String[] ans = new String[idx+1];
        for(int i = 0; i <= idx; i++){
            ans[i] = str.substring(i);
        }
        return ans;
    }

    public static boolean isAZ(char x){
        // a: 97
        // z: 122
        return (x >= 97) && (x <= 122);
    }

    public static boolean isErrorP(String p){
        // 如果 p 的开头是 '*' 那就不对了
        return p.charAt(0) == '*';
    }

    public static void test(String str, String p){
        System.out.println("str: " + str + ", p: " + p + ": " + isMatch(str, p));
    }

    // isEmptyPattern
    public static void run_isEmptyPattern(String p){
        System.out.println("p: " + p + ": " + isEmptyPattern(p));
    }

    public static void main(String[] args){
        /*
        例1:
        s = "aa", p = "a" -> false
        整个string "aa" 不符合 格式"a"

        例2:
        s = "aa"; p = "a*" -> true

        例3:
        s = "ab"; p = ".*" -> true
        Explanation: ".*" means "zero or more (*) of any character (.)".

        例4:
        s = "aab"; p = "c*a*b" -> true
        注: c可以被重复 0 遍，a可以被重复 2 遍

        例5:
        Input:
        s = "mississippi"; p = "mis*is*p*." -> false
         */

        // "ab"
        // ".*c"

        test("", "c*ab");

        run_isEmptyPattern("c*ab");
    }

}
