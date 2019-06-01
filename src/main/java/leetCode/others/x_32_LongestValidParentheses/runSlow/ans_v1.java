package leetCode.others.x_32_LongestValidParentheses.runSlow;

public class ans_v1 {

    /*
    Runtime: 121 ms, faster than 5.41% of Java online submissions for Longest Valid Parentheses.
    Memory Usage: 36.1 MB, less than 97.13% of Java online submissions for Longest Valid Parentheses.

     */

    public int longestValidParentheses(String s) {
        int max = 0;
        int n = s.length();

        if(n < 2){
            return 0;
        }

        if(n == 2){
            if(s.equals("()")){
                return 2;
            }else{
                return 0;
            }
        }

        char c;
        // delta = x1_num - x2_num; 必须保持: delta >= 0
        int delta, curLen, curIMax, j, idx = 0, x1_num, cur_x1_num_max;
        // 起点为 idx 的 最长的合理的串，长度是: curIMax
        while(idx < n && n-idx > max){
            // 如果 当前第一个字符是 右括号，就可以跳过
            if(s.charAt(idx) == '('){
                delta = 1;
                curLen = 1;
                curIMax = 0;
                x1_num = 1;
                cur_x1_num_max = (n-idx) / 2;
                j = idx + 1; // 下一个被考虑的 char
                while(j < n && delta >= 0 && x1_num <= cur_x1_num_max){
                    c = s.charAt(j);
                    if(c == '('){
                        delta++;
                        x1_num++;
                    }else{
                        delta--;
                    }
                    curLen++;
                    if(delta == 0){ // 现在 算是一个解
                        curIMax = curLen; // 把这个解，记下来
                    }
                    j++;
                }
                if(curIMax > max){
                    max = curIMax;
                }
            }
            idx++;
        }
        return max;
    }

}
