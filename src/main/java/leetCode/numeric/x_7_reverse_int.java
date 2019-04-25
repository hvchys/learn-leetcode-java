package leetCode.numeric;

// 这个方法，计算复杂度，太高
public class x_7_reverse_int {

    /*
    32-bit signed integer range: [−2^31,  2^31 − 1]

    例:
    123 -> 321
    -123 -> -321
    120 -> 21
     */

    public static int reverse(int x) {
        if(x == 0)
            return 0;
        if(x < 0)
            return 0 - reverse(-x);
        if(x < 10)
            return x;

        int ans = 0;
        int exp = 1;

        return ans;
    }

    public static void test(int x){
        System.out.println(x + ": " + util.getLen(x));
    }

    public static void main(String[] args) {

        test(10);
        test(123);
        test(2147483412);

    }
}

