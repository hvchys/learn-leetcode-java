package leetCode.others.x_32_LongestValidParentheses.runSlow;

import java.util.ArrayList;
import java.util.List;

public class ans_v3 {

    public int longestValidParentheses(String s) {
        int len = s.length(), iMax, j, parenNum;

        if(len < 2){
            return 0;
        }
        if(len == 2){
            return s.equals("()") ? 2 : 0;
        }
        int ans = 0, max = 0;
        List<Integer> iAns;
        for(int i = 0; i < len; i++){
            if(len - i < max){
                break;
            }
            ans = getIAns(s, len, i);
            if(ans > max){
                max = ans;
            }
        }
        return max;
    }

    int getIAns(String str, int n, int i){
        if(str.charAt(i) == ')'){
            return 0;
        }
        List<PreNum> startI = new ArrayList<>();
        int ans = 0;
        PreNum xx_i_j = new PreNum(1,0), xx_i_jMinus1;
        startI.add(xx_i_j);
        int parenNumMax = (n-i)/2;
        for(int j = i+1; j < n; j++){
            xx_i_jMinus1 = startI.get(j-i-1);
            if(str.charAt(j) == '('){
                xx_i_j = xx_i_jMinus1.addLeft();
            }else{
                xx_i_j = xx_i_jMinus1.addRight();
            }

            // 如果 xx_i_j 不是合理的 前缀，那后面的内容，不用看了
            if(xx_i_j.isValidPre(parenNumMax)){
                startI.add(xx_i_j);
                if(xx_i_j.isValidParentheses()){
                    ans = j-i+1;
                }
            }else{
                break;
            }
        }
        return ans;
    }
}

class PreNum{
    int x1_num;
    int x2_num;

    PreNum(int x1_num, int x2_num){
        this.x1_num = x1_num;
        this.x2_num = x2_num;
    }

    PreNum addLeft(){
        return new PreNum(this.x1_num+1, this.x2_num);
    }

    PreNum addRight(){
        return new PreNum(this.x1_num, this.x2_num+1);
    }

    boolean isValidParentheses(){
        return this.x1_num == this.x2_num;
    }

    boolean isValidPre(int parenNum){
        // if(this.x1_num < this.x2_num || this.x1_num > parenNum)
        return this.x1_num >= this.x2_num && this.x1_num <= parenNum;
    }
}

