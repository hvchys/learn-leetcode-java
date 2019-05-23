package leetCode.numeric;

import java.util.*;

public class x_179_largest_number {
    /*
    Given a list of non negative integers, arrange them such that they form the largest number.

    例1:
    输入: [10,2]
    输出: "210"

    例2:
    输入: [3,30,34,5,9]
    输出: "9534330"

    注: 结果可能很大，返回一个 string

    12(?), 121
    【思路】
    从高位往低位走，找可能的最大的填进去

    1**
    2**
    3**
    4**
    ...
    9**

    12(?), 121
    类似于，维护9颗树: 每个树里面，数之间有大小关系

    如果有 12, 121这种(A是B的前缀)，那认为它俩相等
    碰到了这种情况: A = ab, B = abc..., 找 第c颗树 里面 有没有比 B 大的

    1 所有树，找最大的树，把它的 根 填到结果里面
    2 如果有 12, 121这种(A是B的前缀)，那认为它俩相等
    碰到了这种情况: A = ab, B = abc..., 找 第c颗树 里面 有没有比 B 大的
      a. 有更大的，那就取 A
      b. 没有更大的，那就取 B
     */

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();

        String[] strArr = getStrArr(nums);
        Map<Integer, List<String>> map = new TreeMap<>();
        int groupId;
        List<String> curGroup;
        for(String x: strArr){
            groupId = x.charAt(0);
            curGroup = map.get(groupId);
            if(curGroup == null){
                curGroup = new ArrayList<String>();
                curGroup.add(x);
            }else{
                curGroup.add(x);
            }
            map.put(groupId, curGroup);
        }

        Set<Map.Entry<Integer, List<String>>> entrySet = map.entrySet();
        Iterator iter = entrySet.iterator();


        return sb.toString();
    }

    public static int compare(String x, String y){
        // 从最高位置往低走 看它俩谁大
        // x > y: 1
        // x < y: -1
        // x == y: 0
        // x 真的等于 y: -2 ???
        int idx = 0;
        int xLen = x.length();
        int yLen = y.length();
        int minLen = Math.min(xLen, yLen);
        while(idx < minLen){
            if(x.charAt(idx) > y.charAt(idx)){
                return 1;
            }else if(x.charAt(idx) < y.charAt(idx)){
                return -1;
            }
            idx++;
        }
        return 0;
    }

    public static String[] getStrArr(int[] arr){
        String[] ans = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            ans[i] = Integer.toString(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        Map<Integer, List<Integer>> map = new TreeMap<>();

    }

}
