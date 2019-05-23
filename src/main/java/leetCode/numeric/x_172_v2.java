package leetCode.numeric;

import java.util.ArrayList;
import java.util.List;

public class x_172_v2 {

    /*
    Runtime: 2 ms, faster than 50.24% of Java online submissions for Factorial Trailing Zeroes.
    Memory Usage: 32.8 MB, less than 58.66% of Java online submissions for Factorial Trailing Zeroes.

     */

    public static int trailingZeroes(int n) {
        return giveMeFive(n);
    }

    public static int giveMeFive(int x){
        // 比它小的 所有数的 5 的 总幂次
        List<Integer> powLargerThanN = new ArrayList<>();
        int n = 1;
        int curNum;
        while(true){
            curNum = getPowN(x, n); // <= x 的，是 5^p 的倍数, p >= n
            if(curNum == 0){
                break;
            }
            powLargerThanN.add(curNum);
            n++;
        }
        int powMax = powLargerThanN.size();
        if(powMax == 0){
            return 0;
        }
        if(powMax == 1){
            return powLargerThanN.get(0);
        }
        int[] powIsN = new int[powMax];
        // powIsN[i]: 恰好是 5^i 的倍数
        powIsN[powMax-1] = powLargerThanN.get(powMax-1);
        for(int i = powMax-2; i >= 0; i--){
            powIsN[i] = powLargerThanN.get(i) - powLargerThanN.get(i+1);
        }
        int ans = 0;
        for(int i = 0; i < powMax; i++){
            ans += powIsN[i]*(i+1);
        }
        return ans;
    }

    // <= x 的，是 5^p 的倍数, p >= n
    public static int getPowN(int x, int n){
        // 5^14 > Integer.MAX
        if(n > 13){
            return 0;
        }
        int p = (int) Math.pow(5, n);
        // int aMax = x / p; // 如果 p 比 x 大，那 aMax == 0: 就返回 0 了
        return x/p;
    }

}
