package leetCode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class x_17_letter_combinations_from_phone {
    /*
    在一个老式的那种，手机键盘上
    给一个string, 包含数字: 2~9,
    返回这个 string 对应的可能的 字母序列

    2: abc, 3: def, 4: ghi, 5: jkl, 6: mno, 7: pqrs, 8: tuv, 9: wxyz

    例:
    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    int: 对应的 char 的编码: (0: 48, 1: 49, 2: 50) ~ (9: 57)
     */

    public List<String> letterCombinations(String digits) {

        List<List<String>> ans = new ArrayList<>();

        int eleNum = digits.length();
        List<List<String>> digitToLetter = getDigitToLetter();
        List<String> strInI;
        for(int i = 0; i < eleNum; i++){
            // 第 i 位 可能出现的单词
            strInI = charToLetter(digits.charAt(i), digitToLetter);
            ans = ansAddI(ans, strInI);
        }

        return getAns(ans);
    }

    public static List<String> getAns(List<List<String>> ans){
        List<String> ansStrs = new ArrayList<>();
        for(List<String> curList: ans){
            ansStrs.add(listToStr(curList));
        }
        return ansStrs;
    }

    public static String listToStr(List<String> list){
        StringBuilder sb = new StringBuilder();
        for(String str: list){
            sb.append(str);
        }
        return sb.toString();
    }

    public static List<List<String>> ansAddI(List<List<String>> ansBeforeI, List<String> strInI){
        // 把 第 i 位 可能的值，加到 前面的已有的解里面
        List<List<String>> ans = new ArrayList<>();
        List<String> curBeforeI;
        List<String> curAfterI;
        if(ansBeforeI.isEmpty()){
            for(String str: strInI){
                curBeforeI = new ArrayList<>();
                curBeforeI.add(str);
                ans.add(curBeforeI);
            }
            return ans;
        }else{
            for(int i = 0; i < ansBeforeI.size(); i++){
                curBeforeI = ansBeforeI.get(i);
                for(String strI: strInI){
                    curAfterI = new ArrayList<>();
                    curAfterI.addAll(curBeforeI);
                    curAfterI.add(strI);
                    ans.add(curAfterI);
                }
            }
            return ans;
        }
    }

    public List<String> charToLetter(char c, List<List<String>> digitToLetter){
        return digitToLetter.get((int) c - 50);
    }

    public List<List<String>> getDigitToLetter(){
        List<List<String>> digitToLetter = new ArrayList<>();
        digitToLetter.add(Arrays.asList("a", "b", "c"));
        digitToLetter.add(Arrays.asList("d", "e", "f"));
        digitToLetter.add(Arrays.asList("g", "h", "i"));
        digitToLetter.add(Arrays.asList("j", "k", "l"));
        digitToLetter.add(Arrays.asList("m", "n", "o"));
        digitToLetter.add(Arrays.asList("p", "q", "r", "s"));
        digitToLetter.add(Arrays.asList("t", "u", "v"));
        digitToLetter.add(Arrays.asList("w", "x", "y", "z"));
        return digitToLetter;
    }

    public static void main(String[] args){

    }

}
