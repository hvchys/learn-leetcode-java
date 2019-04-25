package numeric;

import Util.printIntData;

class util {

    public static int getLen(int x){
        // x > 0, 位数 > 1
        // exp: 10,    100,    1000
        //      个位数, 十位数, 百位数
        int eleNum = 0;
        while(x/10 > 0){
            eleNum++;
            x = x/10;
        }
        return eleNum + 1;
    }

    // 123: 返回 {3,2,1}
    public static int[] getIth(int x, int eleNum){
        // x > 0, 位数 > 1
        // exp: 10,    100,    1000
        //      个位数, 十位数, 百位数
        int[] ans = new int[eleNum];
        // ans[0]: 个位数

        int idx = 0;
        int curX = x;
        while(idx < eleNum){
            ans[idx] = curX % 10;
            curX = curX / 10;
            idx++;
        }
        return ans;
    }

    public static void test(int x){
        int xxLen = getLen(x);
        printIntData.ver1arr(x + ": ", getIth(x, xxLen));
    }

    public static void main(String[] args){
        test(123);
    }

}
