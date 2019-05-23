package leetCode.numeric;

import java.util.*;

/*
12, 121, 123, 1234, 1215
【不是合理的 偏序】
12 = 121
12 = 123
121 < 123
【是 合理的 偏序】
12 > 121 > 1215
12 > 123 > 1234
121 < 123
1215 < 121 < 1234 < 123 < 12
【怎么选取这些数】
12, 121, 123, 1234, 1215
除掉 前缀 "12" 之后:
"", 1, 3, 34, 15

92, 923: 还有 4XX, 5XX, 8XX -> 92
92, 923: 剩下的 3XX -> 923
(如果剩下了 3 呢 ?? )


 */

class Num {
    String val;
    Num next; // 如果当前数是某个数的前缀，则 next 是，和它 "最接近" 的数

    Num(String val){
        this.val = val;
    }
}

public class x_179_v3 {


    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int eleNum = nums.length;
        String[] strArr = getStrArr(nums, eleNum);
        PriorityQueue<Num> pq = getQueue(strArr, eleNum);
        Num num;
        while(!pq.isEmpty()){
            num = pq.peek();
            if(num.next == null){
                pq.poll();
                sb.append(num.val);
            }else{
                // num 是 下一个数(记为 y) 的前缀
                // 判断该是用 num 还是 y


            }
        }


        return sb.toString();
    }

    public static PriorityQueue<Num> getQueue(String[] strArr, int eleNum){
        PriorityQueue<Num> p = new PriorityQueue<Num>(
                new Comparator<Num>() {
                    @Override
                    public int compare(Num x, Num y) {
                        String xVal = x.val;
                        String yVal = y.val;
                        if(xVal.equals(yVal)){
                            return 0;
                        }
                        int idx = 0;
                        int xLen = xVal.length();
                        int yLen = yVal.length();
                        int minLen = Math.min(xLen, yLen);
                        while(idx < minLen){
                            if(xVal.charAt(idx) > yVal.charAt(idx)){
                                return -1;
                            }else if(xVal.charAt(idx) < yVal.charAt(idx)){
                                return 1;
                            }
                            idx++;
                        }
                        if(xLen > yLen){
                            return 1;
                        }else { // xLen < yLen
                            return -1;
                        }
                    }
                });
        for(String x: strArr){
            p.add(new Num(x));
        }
        // 添加 next 相关信息
        String[] arrSorted = new String[eleNum];
        int i = 0;
        Num num;
        String x;
        while(!p.isEmpty()){
            arrSorted[i] = p.poll().val;
            i++;
        }
        p.add(new Num(arrSorted[eleNum-1]));
        for(int idx = eleNum - 2; idx >= 0; idx--){
            x = arrSorted[i];
            num = new Num(x);
            if(isPrefix(x, arrSorted[i+1])){
                num.next = p.peek();
            }
            p.add(num);
        }
        return p;
    }

    public static boolean isPrefix(String x, String x2){
        // x 是 x2 的前缀
        // x != x2

        int idx = 0;
        int xLen = x.length();
        int x2Len = x2.length();
        if(xLen >= x2Len){
            return false;
        }
        while(idx < xLen){
            if(x.charAt(idx) != x2.charAt(idx)){
                return false;
            }
            idx++;
        }
        return true;
    }

    public static String[] getStrArr(int[] arr, int eleNum){
        String[] ans = new String[eleNum];
        for(int i = 0; i < eleNum; i++){
            ans[i] = Integer.toString(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args){

    }

}
