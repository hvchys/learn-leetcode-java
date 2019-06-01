package leetCode.others.x_32_LongestValidParentheses.runSlow;

import java.util.ArrayList;
import java.util.List;

public class ans_v5 {

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

        Util.printIntData.arrWithIdx("x1", x1);
        Util.printIntData.arrWithIdx("x2", x2);

        // 从大往小 找答案
        int delta = len % 2 == 0 ? len : len - 1;
        int parenNum;
        List<Integer> curIArr;
        while (delta >= 2){
            System.out.println("delta: " + delta);
            // iMax = len - delta;
            parenNum = delta/2;
            curIArr = getI(leftIdxArr, len - delta);
            for(int i: curIArr){
                // j = i + delta - 1;
                int j = i + delta - 1;
                System.out.println("i: " + i + ", j: " + j);

                if(checkIsValid(x1, x2, i, i + delta - 1, parenNum)){
                    return delta;
                }
            }
            delta -= 2;
        }
        return 0;
    }

    public List<Integer> getI(List<Integer> leftIdxArr, int iMax){
        List<Integer> ans = new ArrayList<>();
        for(int i: leftIdxArr){
            if(i > iMax){
                break;
            }
            ans.add(i);
        }
        return ans;
    }

    public boolean checkIsValid(int[] x1, int[] x2, int i, int j, int parenNum){
        // 检查子串 [i,j] 是不是 有效的
        // 对于 str[i, j]:
        int x1_num = x1[j] - x1[i] + 1;
        int x2_num = x2[j] - x2[i];
        if(x1_num == x2_num){
            for(int k = i+2; k < j; k++){
                x1_num = x1[k] - x1[i] + 1;
                x2_num = x2[k] - x2[i];
                if(isNotValidPre(x1_num, x2_num, parenNum)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
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

    public boolean isNotValidPre(int x1_num, int x2_num, int parenNum){
        return x1_num < x2_num || x1_num > parenNum;
    }
}
