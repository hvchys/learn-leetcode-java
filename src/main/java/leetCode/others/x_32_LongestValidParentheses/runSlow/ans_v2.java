package leetCode.others.x_32_LongestValidParentheses.runSlow;

import Util.printTemp;

public class ans_v2 {

    /*
    Memory Limit Exceeded
     */

    public static int longestValidParentheses(String s) {
        int len = s.length(), iMax, j, parenNum;

        if(len < 2){
            return 0;
        }
        if(len == 2){
            return s.equals("()") ? 2 : 0;
        }

        int[][] x1 = new int[len][len];
        int[][] x2 = new int[len][len];
        getX1X2Num(s, len, x1, x2);

        printTemp.printTwoArr(x1, len, "x1");
        printTemp.printTwoArr(x2, len, "x2");

        // 从大往小 找答案
        int delta = len % 2 == 0 ? len : len - 1;
        while (delta >= 2){
            System.out.println("delta: " + delta);
            iMax = len - delta;
            parenNum = delta/2;
            for(int i = 0; i <= iMax; i++){
                j = i + delta - 1;
                System.out.println("i: " + i + ", j: " + j);
                // 检查子串 [i,j] 是不是 有效的
                if(checkIsValid(s, x1, x2, i, j, parenNum)){
                    return delta;
                }
            }
            delta -= 2;
        }
        return 0;
    }

    public static boolean checkIsValid(String str, int[][] x1, int[][] x2, int i, int j, int parenNum){
        if(str.charAt(i) == '(' && str.charAt(j) == ')' && x1[i][j] == x2[i][j]){
            for(int idx = i+1; idx < j; idx++){
                if(x1[i][idx] < x2[i][idx] || x1[i][idx] > parenNum){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public static void getX1X2Num(String str, int n, int[][] x1, int[][] x2){
        /*
        x1_numArr, x2_numArr
        x1[i][i] = str.chatAt(i) 的信息
        x1[i][j]: 子串 [i,j] 的 x1_num
         */
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == '('){
                x1[i][i] = 1;
            }else{
                x2[i][i] = 1;
            }
        }

        int delta = 1, iMax, j;
        while (delta < n){
            // System.out.println("delta: " + delta);
            iMax = n - delta;
            for(int i = 0; i < iMax; i++){
                j = i + delta;
                // System.out.println("i: " + i + ", j: " + j);
                if(str.charAt(j) == '('){
                    x1[i][j] = x1[i][j-1] + 1;
                    x2[i][j] = x2[i][j-1];
                }else{
                    x1[i][j] = x1[i][j-1];
                    x2[i][j] = x2[i][j-1] + 1;
                }

            }
            delta++;
        }
    }

    public static void main(String[] args){
        String str = "(()";

        int ans = longestValidParentheses(str);

        System.out.println(ans);

    }

}
