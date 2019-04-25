package leetCode.str_char.x_5;

public class x_5_Longest_Palindromic_Substring {
    /*
    最长 回文 子串

    例1:
    输入: "babad"
    输出: "bab"
    注: "aba" 也是一个合理的解

    例2:
    输入: "cbbd"
    输出: "bb"
     */

    // 动态规划
    public static String test(String s) {

        /*
        a -> bab
        123(4)567
        12(3)4567
         */
        String[] oriStrArr = s.split("");
        int eleNum = oriStrArr.length;
        String[][] ansAll = new String[eleNum][eleNum];
        Boolean[][] isValidArr = new Boolean[eleNum][eleNum];
        // ansAll[i][j]: oriStrArr[i~j]是一个回文

        String ansStr = oriStrArr[0];
        int ansLen = 1;

        // delta = 0, 1
        // delta = 0
        int i = 0;
        while(i < eleNum){
            ansAll[i][i] = oriStrArr[i];
            isValidArr[i][i] = true;
            i++;
        }

        // delta = 1
        i = 0;
        int j = i + 1;
        while(i < eleNum && j < eleNum){
            if(oriStrArr[i].equals(oriStrArr[j])){
                ansAll[i][j] = oriStrArr[i] + oriStrArr[i];
                isValidArr[i][j] = true;
                if(ansAll[i][j].length() > ansLen){
                    ansLen = ansAll[i][j].length();
                    ansStr = ansAll[i][j];
                }
            }else{
                isValidArr[i][j] = false;
            }
            i++;
            j = i + 1;
        }

        // 按照 delta 遍历
        // delta >= 2
        for(int delta = 2; delta < eleNum; delta++){
            for(i = 0; i < eleNum; i++){
                j = i + delta;
                if(j < eleNum){
                    // System.out.println("i: " + i + ", j: " + j);
                    if(isValidArr[i+1][j-1] && oriStrArr[i].equals(oriStrArr[j])){
                        isValidArr[i][j] = true;
                        ansAll[i][j] = oriStrArr[i] + ansAll[i+1][j-1] + oriStrArr[i];
                        // System.out.println("i: " + i + ", j: " + j);
                        // System.out.println(ansAll[i][j]);
                        if(ansAll[i][j].length() > ansLen){
                            ansLen = ansAll[i][j].length();
                            ansStr = ansAll[i][j];
                        }
                    }else{
                        isValidArr[i][j] = false;
                    }
                }
            }
        }

        return ansStr;

    }

    public static String getIthStr(String s, int idx){
        return String.valueOf(s.charAt(idx));
    }

    public static String longestPalindrome(String s) {
        if(s.equals(""))
            return "";

        if(s.length()==1)
            return s;

        int eleNum = s.length();
        String[][] ansAll = new String[eleNum][eleNum];
        Boolean[][] isValidArr = new Boolean[eleNum][eleNum];
        // ansAll[i][j]: oriStrArr[i~j]是一个回文

        String ansStr = getIthStr(s,0);
        int ansLen = 1;

        // delta = 0, 1
        // delta = 0
        int i = 0;
        while(i < eleNum){
            ansAll[i][i] = getIthStr(s,i);
            isValidArr[i][i] = true;
            i++;
        }

        // delta = 1
        String i_str;
        i = 0;
        int j = i + 1;
        while(i < eleNum && j < eleNum){
            i_str = getIthStr(s,i);
            if(i_str.equals(getIthStr(s,j))){
                ansAll[i][j] = i_str + i_str;
                isValidArr[i][j] = true;
                if(ansAll[i][j].length() > ansLen){
                    ansLen = ansAll[i][j].length();
                    ansStr = ansAll[i][j];
                }
            }else{
                isValidArr[i][j] = false;
            }
            i++;
            j = i + 1;
        }

        // 按照 delta 遍历
        // delta >= 2
        for(int delta = 2; delta < eleNum; delta++){
            for(i = 0; i < eleNum; i++){
                j = i + delta;
                if(j < eleNum){
                    // System.out.println("i: " + i + ", j: " + j);
                    i_str = getIthStr(s,i);
                    if(isValidArr[i+1][j-1] && i_str.equals(getIthStr(s,j))){
                        isValidArr[i][j] = true;
                        ansAll[i][j] = i_str + ansAll[i+1][j-1] + i_str;
                        // System.out.println("i: " + i + ", j: " + j);
                        // System.out.println(ansAll[i][j]);
                        if(ansAll[i][j].length() > ansLen){
                            ansLen = ansAll[i][j].length();
                            ansStr = ansAll[i][j];
                        }
                    }else{
                        isValidArr[i][j] = false;
                    }
                }
            }
        }

        return ansStr;

    }

    public static void main(String[] args){
        String str = "cbbd";
        // 如果 str 太长 就会 溢出
        String ans = longestPalindrome(str);
        System.out.println("ans: " + ans);
    }
}
