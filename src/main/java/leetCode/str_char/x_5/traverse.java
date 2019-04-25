package leetCode.str_char.x_5;

public class traverse {
    // 遍历 !!!

    private static int lo, maxLen;

    public static String longestPalindrome(String s) {
        lo = 0;
        maxLen = 0;
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  // 假设 奇数长度 的回文，尽量往外扩展
            extendPalindrome(s, i, i+1); // 假设 偶数长度 的回文
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }



}
