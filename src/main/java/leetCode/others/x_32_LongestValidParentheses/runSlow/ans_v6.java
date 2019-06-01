package leetCode.others.x_32_LongestValidParentheses.runSlow;

import java.util.ArrayList;
import java.util.List;

public class ans_v6 {

    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len < 2){
            return 0;
        }
        if(len == 2){
            return s.equals("()") ? 2 : 0;
        }

        // 初始化 x1, x2
        int[] x1 = new int[len];
        int[] x2 = new int[len];
        List<Integer> leftIdxArr = new ArrayList<>();
        /*
        x1[i]: Str[0, i] 里面的 左括号 的数量
        x2[i]: Str[0, i] 里面的 右括号 的数量
         */
        getX1X2(s, len, x1, x2, leftIdxArr);

        int x1_num, x2_num, parenNumMax, curMax = 0, curLenMax;
        boolean notFinished;
        for(int i: leftIdxArr){
            // 起点为 i 的 最大解
            curLenMax = len - i;
            if(curLenMax < curMax){
                break;
            }

            parenNumMax = curLenMax/2;
            notFinished = true;
            for(int j = i+1; j < len && notFinished; j++){
                // str[i, j]:
                x1_num = x1[j] - x1[i] + 1;
                x2_num = x2[j] - x2[i];
                if(isValidPre(x1_num, x2_num, parenNumMax)){
                    if(x1_num+x2_num > curMax && x1_num == x2_num){
                        curMax = x1_num+x2_num;
                    }
                }else{
                    notFinished = false;
                }
            }
        }
        return curMax;
    }

    public void addZero(int[] x1, int[] x2, List<Integer> leftIdxArr, char c){
        if(c == '('){
            x1[0] = 1;
            leftIdxArr.add(0);
        }else{
            x2[0] = 1;
        }
    }

    public void getX1X2(String s, int len, int[] x1, int[] x2, List<Integer> leftIdxArr){
        addZero(x1, x2, leftIdxArr, s.charAt(0));
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == '('){
                addLeft(x1, x2, i);
                leftIdxArr.add(i);
            }else{
                addRight(x1, x2, i);
            }
        }
    }

    public void addLeft(int[] x1, int[] x2, int i){
        x1[i] = x1[i-1] + 1;
        x2[i] = x2[i-1];
    }

    public void addRight(int[] x1, int[] x2, int i){
        x1[i] = x1[i-1];
        x2[i] = x2[i-1] + 1;
    }

    public boolean isValidPre(int x1_num, int x2_num, int parenNum){
        return x1_num >= x2_num && x1_num <= parenNum;
    }

}
