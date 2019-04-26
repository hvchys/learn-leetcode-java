package leetCode.str_char;

public class x_14_Longest_Common_Prefix {
    /*
    给定 字符串的序列，求出: longest common prefix
    如果没有，返回 ""

    例:
    ["flower","flow","flight"] -> "fl"
    ["dog","racecar","car"] -> ""

    注: 输入的所有 character 都是 小写 a-z

     */

    public static String longestCommonPrefix(String[] strs) {
        int wordNum = strs.length;
        if(wordNum == 0)
            return "";
        String minStr = getMinLenStr(strs, wordNum);
        // System.out.println("minStr: " + minStr);
        int maxLen = minStr.length();
        char[] charArr = minStr.toCharArray();
        char c;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < maxLen; i++){
            c = charArr[i];
            if(isPrefix(strs, c, i))
                sb.append(c);
            else
                break;
        }
        return sb.toString();
    }

    public static boolean isPrefix(String[] strArr, char c, int idx){
        for(String x: strArr){
            // System.out.println("x: " + x);
            if(x.charAt(idx) != c)
                return false;
        }
        return true;
    }

    public static String getMinLenStr(String[] strArr, int wordNum){
        int minLen = Integer.MAX_VALUE;
        int curLen;
        String minStr = strArr[0];
        for(int i = 0; i < wordNum; i++){
            curLen = strArr[i].length();
            if(curLen < minLen){
                minLen = curLen;
                minStr = strArr[i];
            }
        }
        return minStr;
    }

    public static void test(String[] x){

        System.out.println(longestCommonPrefix(x));
    }

    public static void main(String[] args){
        String[] input = new String[]{"aca","cba"};

        test(input);

    }

}
