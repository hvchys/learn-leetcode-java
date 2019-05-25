package leetCode.others;

import java.util.ArrayList;
import java.util.List;

public class x_22_generate_parentheses {
    /*
    输入: n
    输出: n对 括号的 各种可能的排列: all combinations of well-formed parentheses.

    例:
    输入: n = 3
    输出:
    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]

    n=2:
    "()()"
    "(())"

    n=1: "()"
     */

    public List<String> generateParenthesis(int n) {
        /*
        x1: 左括号; x2: 右括号
        合理的序列 str: 它的前 i 个元素，这里面的 x1_num >= x2_num
                       它的后 j 个元素，这里面的 x1_num <= x2_num


         */
        List<String> ans = new ArrayList<>();
        return ans;
    }

}
