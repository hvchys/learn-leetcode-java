package leetCode.others.x_32_LongestValidParentheses.runSlow;

public class ans_v4 {

    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len < 2){
            return 0;
        }
        if(len == 2){
            return s.equals("()") ? 2 : 0;
        }

        int x1_num, x2_num, parenNumMax, curMax = 0, curLenMax;
        boolean notFinished;
        for(int i = 0; i < len; i++){
            // 起点为 i 的 最大解
            curLenMax = len - i;
            if(curLenMax < curMax){
                break;
            }
            if(s.charAt(i) == '('){
                parenNumMax = curLenMax/2;
                x1_num = 1;
                x2_num = 0;
                notFinished = true;
                for(int j = i+1; j < len && notFinished; j++){
                    if(s.charAt(j) == '('){
                        x1_num++;
                    }else{
                        x2_num++;
                    }
                    if(isValidPre(x1_num, x2_num, parenNumMax)){
                        if(x1_num+x2_num > curMax && isValidParentheses(x1_num, x2_num)){
                            curMax = x1_num+x2_num;
                        }
                    }else{
                        notFinished = false;
                    }
                }
            }
        }
        return curMax;
    }

    public boolean isValidParentheses(int x1_num, int x2_num){
        return x1_num == x2_num;
    }

    public boolean isValidPre(int x1_num, int x2_num, int parenNum){
        return x1_num >= x2_num && x1_num <= parenNum;
    }

}
