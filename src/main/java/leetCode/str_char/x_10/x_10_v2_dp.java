package leetCode.str_char.x_10;

public class x_10_v2_dp {
    // dynamic programming: 动态规划
    // 这个做法，其实不是 动态规划。动态规划应该是 从小到大

    /*
    https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation

    dp[i][j]: isMatch(STR[0~i], P[0~j])

    1. P[j]: a-z:
       a) STR[i] == P[j]: dp[i][j] = dp[i-1][j-1]
       b) STR[i] != P[j]: false
    2. P[j]: '.': dp[i][j] = dp[i-1][j-1]
    3. P[j]: '*':
       a) P[j-1] 是 字母:
          a) P[j-1] != STR[i]: dp[i][j] = dp[i][j-2]
          b) P[j-1] == STR[i]:
             dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j]
       b) P[j-1]: '.':
          dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j]
     */


    public static boolean isMatch(String str, String p){
        if(str == null || p == null)
            return false;
        if(p.isEmpty())
            return str.isEmpty();
        if(isErrorP(p))
            return false;
        if(str.isEmpty())
            return isEmptyPattern(p);

        // 都是 非空
        /*
        dp[i][j]: isMatch(STR[0~i], P[0~j])

        1. P[j]: a-z:
            a) STR[i] == P[j]: dp[i][j] = dp[i-1][j-1]
            b) STR[i] != P[j]: false
        2. P[j]: '.': dp[i][j] = dp[i-1][j-1]
        3. P[j]: '*':
            a) P[j-1] 是 字母:
                a) P[j-1] != STR[i]: dp[i][j] = dp[i][j-2]
                b) P[j-1] == STR[i]:
                    dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j]
            b) P[j-1]: '.':
                dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j]
        */
        char Si = getLastChar(str);
        char Pj = getLastChar(p);
        char Pj1;
        if(isAZ(Pj)){
            return (Pj == Si) && isMatch(getSubStr1(str), getSubStr1(p));
        }else if(Pj == '.')
            return isMatch(getSubStr1(str), getSubStr1(p));
        else{
            // Pj: *
            Pj1 = getLastLastChar(p);
            if(isAZ(Pj1)){
                if(Pj1 != Si)
                    return isMatch(str, getSubStr2(p));
                else
                    return isMatch(str, getSubStr2(p)) || isMatch(str, getSubStr1(p)) || isMatch(getSubStr1(str), p);
            }else if(Pj1 == '.'){
                return isMatch(str, getSubStr2(p)) || isMatch(str, getSubStr1(p)) || isMatch(getSubStr1(str), p);
            }else
                return false;
        }
    }

    public static char getLastChar(String x){
        int xxLen = x.length();
        return x.charAt(xxLen - 1);
    }

    public static char getLastLastChar(String x){
        int xxLen = x.length();
        return x.charAt(xxLen - 2);
    }

    // 0123 -> 012
    public static String getSubStr1(String x){
        int xxLen = x.length();
        return x.substring(0, xxLen-1);
    }

    // 0123 -> 01
    public static String getSubStr2(String x){
        int xxLen = x.length();
        return x.substring(0, xxLen-2);
    }

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
