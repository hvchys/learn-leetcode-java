package str_char.x_6;

import java.util.ArrayList;
import java.util.List;

public class x_6_ZigZag_Conversion {
    /*

    把字符串 "PAYPALISHIRING" 用 zigzag的格式写下来:
    P   A   H   N
    A P L S I I G
    Y   I   R
    然后把上述结果，逐行写出来: "PAHNAPLSIIGYIR"

    例1:
    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"
    PAHNAPLSIIGYIR
    PAHNPSIALIGYIR

    例2:
    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:

    PINALSIGYAHRPI
    PINALSIGYAHRPI

    P     I    N
    A   L S  I G
    Y A   H R
    P     I
     */

    public static String convert(String s, int numRows){
        // 保存 numRows 个子数组，第 i 个子数组，对应 zigzag 的 第 i 行
        if(numRows==1)
            return s;

        List<ArrayList<String>> arr = initialize(numRows);
        int curRow = 0;
        boolean goDown = true;
        int i = 0;
        ArrayList<String> curLine;
        while(i < s.length()){
            curLine = arr.get(curRow);
            curLine.add(String.valueOf(s.charAt(i)));

            // System.out.println("curRow: " + curRow + ", str: " + String.valueOf(s.charAt(i)));

            i++;
            // 先考虑 curRow = 第一行/最后一行 的情况
            // 然后，就是普通情况了
            if(curRow == (numRows-1)){
                goDown = false;
                curRow--;
                continue;
            }
            if(curRow == 0){
                curRow++;
                goDown = true;
                continue;
            }
            if(goDown)
                curRow++;
            else
                curRow--;
        }

        StringBuilder sb = new StringBuilder();
//        for(ArrayList<String> line: arr){
//            for(String x: line){
//                sb.append(x);
//            }
//        }

        for(int k = 0; k < numRows; k++){
            curLine = arr.get(k);
            for(int j = 0; j < curLine.size(); j++)
                sb.append(curLine.get(j));
        }

        return sb.toString();
    }

    public static List<ArrayList<String>> initialize(int numRows){
        List<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        int i = 0;
        while(i < numRows){
            arr.add(new ArrayList<String>());
            i++;
        }
        return arr;
    }

    public static void main(String[] args){
        String s = "AB";
        int numRows = 1;

        // String ans = convert(s, numRows);
        // System.out.println(ans);

        List<ArrayList<String>> test = initialize(1);
        System.out.println(test.size());

    }

}
