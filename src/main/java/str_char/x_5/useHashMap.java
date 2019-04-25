package str_char.x_5;

import javafx.util.Pair;

import java.util.HashMap;

public class useHashMap {

    public static String getIthStr(String s, int idx){
        return String.valueOf(s.charAt(idx));
    }

    public static String longestPalindrome(String s) {
        if(s.equals(""))
            return "";

        if(s.length()==1)
            return s;

        int eleNum = s.length();
        // String[][] ansAll = new String[eleNum][eleNum];
        // Boolean[][] isValidArr = new Boolean[eleNum][eleNum];
        HashMap<Pair<Integer, Integer>, String> ansAll = new HashMap<Pair<Integer, Integer>, String>();
        HashMap<Pair<Integer, Integer>, Boolean> isValidMark = new HashMap<Pair<Integer, Integer>, Boolean>();

        String ansStr = getIthStr(s,0);
        int ansLen = 1;

        // delta = 0, 1
        // delta = 0
        int i = 0;
        while(i < eleNum){
            ansAll.put(new Pair<>(i,i), getIthStr(s,i));
            isValidMark.put(new Pair<>(i,i), true);
            i++;
        }

        // delta = 1
        String i_str;
        String curStr;
        i = 0;
        int j = i + 1;
        while(i < eleNum && j < eleNum){
            i_str = getIthStr(s, i);
            if(i_str.equals(getIthStr(s, j))){
                curStr = i_str + i_str;
                ansAll.put(new Pair<>(i, j), curStr);
                isValidMark.put(new Pair<>(i, j), true);
                if(curStr.length() > ansLen){
                    ansLen = curStr.length();
                    ansStr = curStr;
                }
            }else{
                isValidMark.put(new Pair<>(i, j), false);
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
                    i_str = getIthStr(s, i);
                    curStr = ansAll.get(new Pair<>(i+1, j-1));
                    if(isValidMark.get(new Pair<>(i+1, j-1)) && i_str.equals(getIthStr(s, j))){
                        isValidMark.put(new Pair<>(i, j), true);
                        curStr = i_str + curStr + i_str;
                        ansAll.put(new Pair<>(i, j), curStr);
                        // System.out.println("i: " + i + ", j: " + j);
                        // System.out.println(ansAll[i][j]);
                        if(curStr.length() > ansLen){
                            ansLen = curStr.length();
                            ansStr = curStr;
                        }
                    }else{
                        isValidMark.put(new Pair<>(i, j), false);
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
