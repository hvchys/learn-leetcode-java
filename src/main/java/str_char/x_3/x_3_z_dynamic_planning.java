package str_char.x_3;

import Util.printIntData;

public class x_3_z_dynamic_planning {
    // x_3_z_dynamic_planning
    // dynamic planning

    /*
    给定一个 string, 找它的最长子串，满足: 子串里面没有相同的 characters

    例1:
    Input: "abcabcbb"
    Output: 3
    答案是: "abc", 长度: 3

    例2:
    Input: "bbbbb"
    Output: 1
    答案是: "b", 长度: 1

    例3:
    Input: "pwwkew"
    Output: 3
    答案是: "wke", 长度: 3

    答案，必须是，相连的，子串
     */

    public static int lengthOfLongestSubstring(String s) {
        // 方法2: (动态规划)
        // 记 第 i 个字符 为 char[i]
        // L(i): 开始于 i 的答案
        // 保持一个 set: 当前已经在结果里面的字符串集合: 结果是谁啊???
        // L, 从后往前 求解

        // char[i] != char[i+1]: char[i]   在 L(i+1): L(i)=char[i]~和它一样那个东西之前
        //                       char[i] 不在 L(i+1): L(i)=char[i]+L(i+1)
        // char[i] == char[i+1]: L(i) = 1
        // HashSet strSet: 当前 L[i+1] 里面的str 的集合
        int eleNum = s.length();
        if(eleNum == 0)
            return 0;
        String[] oriStrArr = s.split("");
        int[] L = new int[eleNum];
        L[eleNum - 1] = 1;
        String curStr;
        int firstOccur;
        int curIdxEnd;
        for(int i = eleNum - 2; i >= 0; i--){
            curStr = oriStrArr[i];
            if(curStr.equals(oriStrArr[i+1])){
                L[i] = 1;
            }else{
                // curIdxEnd = i+1+L[i+1]-1;
                curIdxEnd = i+L[i+1];
                firstOccur = findFirstCurStr(oriStrArr, i+1, curIdxEnd, curStr);
                if(firstOccur != -1){
                    L[i] = firstOccur - i;
                }else{
                    L[i] = L[i+1] + 1;
                }
            }
        }

        printIntData.arrWithIdx("", L);

        // 找到 最大值
        int ans = -1;
        for(int x: L){
            if(x > ans)
                ans = x;
        }
        return ans;
    }

    public static int findFirstCurStr(String[] oriStrArr, int idxStart, int idxEnd, String str){
        // 找 从 oriStrArr[idxStart] 开始，第一个等于 str 的字符串的 idx
        // (包括 oriStrArr[idxStart])
        int ansIdx = -1;
        for(int idx = idxStart; idx <= idxEnd; idx++){
            if(oriStrArr[idx].equals(str)){
                ansIdx = idx;
                break;
            }
        }
        return ansIdx;
    }

    public static void main(String[] args){
        String str = "abba";
        System.out.println(lengthOfLongestSubstring(str));
    }

}
