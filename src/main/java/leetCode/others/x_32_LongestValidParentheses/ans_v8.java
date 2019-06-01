package leetCode.others.x_32_LongestValidParentheses;

import java.util.Stack;

public class ans_v8 {

    /*
    栈 存储 左括号 的 idx
    left 是 答案的起点i 左边一位 的idx
     */

    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for(int j = 0; j < s.length();j++){
            if(s.charAt(j)=='(')
                // j 是 左括号
                stack.push(j);
            else {
                // j 是 右括号
                if (stack.isEmpty()){
                    // 栈 里面，没有 左括号 存货了
                    /*
                    栈 + Str(j) 不会是答案。
                    只考虑 j+1 之后 的内容 ???
                     */
                    left = j;
                }else{
                    // 栈 里面，有 左括号
                    stack.pop();
                    if(stack.isEmpty()){
                        // 栈 + Str(j): 是一个解
                        max = Math.max(max, j - left);
                    }else{
                        // 栈 + Str(j) - 栈的第一个内容: 是一个解
                        max = Math.max(max, j - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
