package leetCode.others.x_32_LongestValidParentheses;

import leetCode.others.x_32_LongestValidParentheses.runSlow.ans_v7;

public class check {
    public static void main(String[] args){
        ans_v7 xxAns = new ans_v7();

        // aa.longestValidParentheses(")()())()()(");

        int ans = xxAns.longestValidParentheses("(())()(()((");

        System.out.println(ans);

    }

}
