package numeric;

// 这个方法，计算复杂度，太高
public class x_7_v2 {

    /*
    32-bit signed integer range: [−2^31,  2^31 − 1]

    例:
    123 -> 321
    -123 -> -321
    120 -> 21
     */

    public static int reverse(int x) {
        if(x == -2147483648)
            return 0;
        if(x == 0)
            return 0;
        if(x < 0)
            return 0 - reverse(-x);
        if(x < 10)
            return x;

        int ans = 0;
        int exp = 1;

        // x > 0, 位数 > 1
        int eleNum = util.getLen(x);
        if(eleNum > 10)
            return 0;
        int[] eachEleArr = util.getIth(x, eleNum);
        // printIntData.ver1arr("eachEleArr", eachEleArr);
        // System.out.println(biggerThanMax(eachEleArr));
        if(eleNum == 10 && biggerThanMax(eachEleArr))
            return 0;
        int firstNoneZeroIdx = getFirstNoneZeroIdx(eachEleArr);
        for(int i = eleNum - 1; i >= firstNoneZeroIdx; i--){
            ans += eachEleArr[i]*exp;
            exp *= 10;
            // System.out.println(ans);
        }
        return ans;
    }

    public static boolean biggerThanMax(int[] arr){
        int[] check = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        // arr 从前往后，正好就是输出的 reverse 结果
        // eachEleArr: 2, 1, 4, 3, 8, 4, 7, 4, 1, 4
        // 2147483647
        // arr的位数，是 10 位，检查它的reverse 是不是越界了
        for(int i = 0; i < 10; i++){
            /*
            arr < check: 不大 返回 false
            arr == check: 平手，继续
            arr > check: 大 返回 true
             */
            if(arr[i] < check[i])
                return false;
            else if(arr[i] > check[i])
                return true;
        }
        return false;
    }

    public static int getFirstNoneZeroIdx(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0)
                return i;
        }
        return -1;
    }



//    public static void checkGetIth(int x){
//        printIntData.ver1arr(x + ": ", getIth(x));
//    }

    public static void test(int x){
        System.out.println(x + ": " + reverse(x));
    }

    // 这个方法有问题，如果 位数很高，exp会越界
    public static int getLen_2(int x){
        // x > 0, 位数 > 1
        // exp: 10,    100,    1000
        //      个位数, 十位数, 百位数
        int exp = 1;
        int eleNum = 0;
        while(x >= exp){
            exp = exp*10;
            System.out.println(eleNum);
            eleNum++;
        }
        return eleNum;
    }

    public static void main(String[] args) {

        // −2^31 = 2147483648
        // [−2^31,  2^31 − 1]

        // test(-2147483412);
        // -2147483412: -2143847414

        test(2147483412);
        // 2147483412: 2143847414

//        int x = 2147483412;
//        printIntData.ver1arr(x + ": ", getIth(x, 10));

    }
}

