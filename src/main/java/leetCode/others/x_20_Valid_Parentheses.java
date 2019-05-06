package leetCode.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class x_20_Valid_Parentheses {
    /*
    有效的 括号

    给一个 string, 只包含:
    '(', ')', '{', '}', '[' and ']',

    判断这个 string 是不是有效的

    称string是有效的，如果:
    1 Open brackets must be closed by the same type of brackets.
    2 Open brackets must be closed in the correct order.
    Open brackets: 左方括号

    例:
    "()": true
    "()[]{}": true
    "(]": false
    "([)]": false
    "{[]}": true

    三种 pair
    isLeft, isRight, isPair, leftToRight

     */

    public static boolean isValid(String s) {
        int eleNum = s.length();
        if(eleNum % 2 != 0)
            return false;

        // 检查 是不是都是 括号
        int cur;
        for(int i = 0; i < eleNum; i++){
            cur = s.charAt(i);
            if(isNotParentheses(cur))
                return false;
        }

        // 那就: 1 都是括号 ; 2 长度是偶数
        Stack<Integer> leftStack = new Stack<>();
        int curLeft;
        for(int i = 0; i < eleNum; i++){
            cur = s.charAt(i);
            if(isLeft(cur))
                leftStack.push(cur);
            else {
                // 是 右括号
                // 如果不是一对儿: 1 curLeft是空的; 2 的确不是一对儿
                if(leftStack.empty())
                    return false;

                curLeft = leftStack.pop();
                if(isNotPair(curLeft, cur))
                    return false;
            }
        }
        return leftStack.empty();
    }

    public static boolean isNotParentheses(int c){
        return c != 40 && c != 41 && c != 123 && c != 125 && c != 91 && c != 93;
    }

    public static boolean isLeft(int c){

        return c==40 || c==123 || c==91;
    }

    public static boolean isNotPair(int left, int right){
        if((left == 40 && right == 41) || (left == 123 && right == 125) || (left == 91 && right == 93))
            return false;
        else
            return true;
    }


    /*
    ( 40
    ) 41
    { 123
    } 125
    [ 91
    ] 93
     */


}
