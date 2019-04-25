package str_char.x_3;

import java.util.HashSet;
import java.util.Set;

public class x_3_LongestSubstringWithoutRepeatingCharacters {
    // 找 没有重复字符的 最长子串
    // x_3_LongestSubstringWithoutRepeatingCharacters

    /*
    给定一个 string, 找它的最长子串，满足: 子串里面没有相同的 characters

    例1:
    Input: "abcabcbb"
    Output: 3
    答案是: "abc", 长度: 3

    例2:
    Input: "bbbbb"
    Output: 1
    答案是: "b", 长度: 1

    例3:
    Input: "pwwkew"
    Output: 3
    答案是: "wke", 长度: 3

    答案，必须是，相连的，子串
     */

    public static int lengthOfLongestSubstring(String s) {
        // The idea is use a hash set to track the longest substring without repeating characters so far, use a fast
        // pointer j to see if character j is in the hash set or not, if not, great, add it to the hash set, move j
        // forward and update the max length, otherwise, delete from the head by using a slow pointer i until we can
        // put character j to the hash set.

        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        // i: 标记 当前结果的 起点
        // j: 标记 当前尝试加入的 新的元素
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                // set.add(s.charAt(j++));
                // j++ 的返回值 是 原始的j
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                // set.remove(s.charAt(i++));
                set.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args){
        String str = "abba";
        System.out.println(lengthOfLongestSubstring(str));
    }

}
