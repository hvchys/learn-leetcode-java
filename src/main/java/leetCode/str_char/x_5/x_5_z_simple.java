package leetCode.str_char.x_5;

public class x_5_z_simple {
    /*
    最长 回文 子串

    例1:
    输入: "babad"
    输出: "bab"
    注: "aba" 也是一个合理的解

    例2:
    输入: "cbbd"
    输出: "bb"
     */

    /*
    如果 输入特别大 的话，会 Memory Limit Exceeded

     */

    public static String longestPalindrome(String s) {

        /*
        a -> bab
        123(4)567
        12(3)4567
         */

        String[] oriStrArr = s.split("");
        String ans1 = getOddPalindrome(oriStrArr);
        String ans2 = getEvenPalindrome(oriStrArr);
        if(ans1.length() > ans2.length())
            return ans1;
        else
            return ans2;

    }

    public static String getOddPalindrome(String[] strArr){
        // 得到 长度为 奇数 的 回文
        // ansArr[]: ansArr[i]: 以 idx为i为中心的回文的最大长度
        // ansArr[0~(n-1)]
        int eleNum = strArr.length;
        int ansLen = Integer.MIN_VALUE;
        int maxLen;
        int count;
        String ansStr = "";
        String ansStr1;
        String ansStr2;
        Boolean isValid;
        for(int i = 0; i < eleNum; i++){
            // 计算 ansArr[i], 01(2)3456, 7
            maxLen = Math.min(i, eleNum - i - 1);
            count = 1;
            ansStr1 = strArr[i];
            isValid = true;
            for(int j = 1; j <= maxLen && isValid; j++){
                if(strArr[i-j].equals(strArr[i+j])){
                    ansStr2 = strArr[i-j] + ansStr1 + strArr[i-j];
                    ansStr1 = ansStr2;
                    count++;
                }else{
                    isValid = false;
                }
            }
            if(count > ansLen){
                ansLen = count;
                ansStr = ansStr1;
            }
        }
        return ansStr;
    }

    public static String getEvenPalindrome(String[] strArr){
        // 得到 长度为 偶数 的 回文
        // ans[]: ans[i]: 以 idx为i,(i+1)为中心的回文的最大长度
        // ans[0~(n-2)]
        int eleNum = strArr.length;
        int ansLen = Integer.MIN_VALUE;
        int maxLen;
        int count;
        String ansStr = "";
        String ansStr1;
        String ansStr2;
        Boolean isValid;
        for(int i = 0; i < eleNum - 1; i++){
            // 计算 ansArr[i] 01(2)3456, 7
            maxLen = Math.min(i, eleNum - i - 2);
            count = 1;
            ansStr1 = "";
            isValid = true;
            for(int j = 0; j <= maxLen && isValid; j++){
                if(strArr[i-j].equals(strArr[i+1+j])){
                    ansStr2 = strArr[i-j] + ansStr1 + strArr[i-j];
                    ansStr1 = ansStr2;
                    count++;
                }else{
                    isValid = false;
                }
            }
            if(count > ansLen){
                ansLen = count;
                ansStr = ansStr1;
            }
        }

        return ansStr;
    }

    public static void main(String[] args){
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String ans = longestPalindrome(str);
        System.out.println("ans: " + ans);

        System.out.println(str);
    }
}
