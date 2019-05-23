package leetCode.numeric;

public class x_172_factorial_tail_zeros {
    /*
    Given an integer n, return the number of trailing zeroes in n!.

    1~10: 2*5, 10

    10: 2*5, 10
    20: 4*5
    30: 6*5
    40: 8*5

    --------------------------------------------------------------------------------
    【方法1】
    【这个方法不太对】
    【1】找到 <=n 的 10 的个数

    【2】找到 <=n 的 5 的个数，基本上，一个10 = 一个5 * 一个偶数
    A = 5的个数
    B = 不是10的偶数的个数
    第二部分的10的个数: min(A,B)

    25 * 4 == 100
    125 * 8 == 1000
    --------------------------------------------------------------------------------
    【方法2】
    A: 5 的倍数 --> 这个数包含的 5 的幂次 --> 所有数的 5 的 总幂次
    B: 2 的倍数 --> 这个数包含的 2 的幂次 --> 所有数的 2 的 总幂次

    基本上就是 A 了 ???

    30:
    25:2 --> 50:2 --> 75:2 --> 100:2 --> 25*5:3
    5^n:
    5 25 125 625 3125 15625 78125 390625 1953125 9765625 48828125 244140625 1220703125

    // 5^n: n = 1
    5, 5*1 5*2 5*3 5*4 5*6, ....

    // 5^n: n = 2

    // 5^n: n = 3

    // .....

    --------------------------------------------------------------------------------
    // 5^n: n >= 1
    // 5^n: n >= 2
    // 5^n: n >= 3
     */

//    public static int trailingZeroes(int n) {
//        int evenNum = n/2;
//        int fiveNum = n/5; // 5 10 15 20 25 30 【 25*4 == 100
//        return Math.min(evenNum, fiveNum);
//    }

    // n=1, x很大: 会挂
//    public static int getPowN(int x, int n){
//        // <= x 的，是 5^n 的倍数 的数目， 不是 5^(n+1) 的倍数
//        int ans = 0;
//        int p = (int) Math.pow(5, n);
//        int aMax = x / p; // 如果 p 比 x 大，那 aMax == 0: 就返回 0 了
//        int a = 1;
//        while (a <= aMax){
//            if(a % 5 != 0){
//                // p*a <= x, a不是5的倍数
//                ans++;
//                a++;
//            }
//        }
//        return ans;
//    }

    // -----------------------------------------------------------------------------------

    public static void xxFive(){
        int i = 1;
        int count = 1;
        while(i < 1000000000){
            i *= 5;
            System.out.print(i + " ");
            if(count % 20 == 0){
                System.out.println();
            }
            count++;
        }
    }


    // -----------------------------------------------------------------------------------
    // 【方法2】
    // 不好，会溢出的
//    public static int giveMeFive(int x){
//        // 比它小的 所有数的 5 的 总幂次
//        int count = 0;
//        int i = 5;
//        while(i <= x){
//            count += getFiveFromOneNum(i);
//            i += 5;
//        }
//        return count;
//    }
//
//    public static int getFiveFromOneNum(int x){
//        // x 是 5 的倍数
//        int ans = 1;
//        int divide = x / 5;
//        while (divide % 5 == 0){
//            ans++;
//            divide = divide / 5;
//        }
//        return ans;
//    }


    // -----------------------------------------------------------------------------------
    // 【类似于 暴力求解】
    // 不行，会 int越界 的
//    public static int simple(int n){
//        int ans = 1;
//        int count = 0;
//        for(int i = 2; i <= n; i++){
//            if(!isOtherOddNum(i)){
//                // 2,4,(5),6,8,10
//                ans = ans * i;
//                if(ans % 10 == 0){
//                    System.out.println("i: " + i + ", ans: " + ans);
//                    ans = ans / 10;
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    // 1,3,7,9; 11,13,17,19
//    public static boolean isOtherOddNum(int x){
//        return x % 5 != 0 && x % 2 != 0;
//    }


}
