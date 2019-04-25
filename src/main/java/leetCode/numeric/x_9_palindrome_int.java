package leetCode.numeric;

public class x_9_palindrome_int {
    /*
    判断一个整数是否是 回文

    例1:
    121 -> true

    例2:
    -121 -> false
    有负号的不行

    例3:
    10 -> false
    10 -> 01: 不是

    希望: 不要把 该int 转换成 string
     */
    public static boolean isPalindrome(int x) {
        // 负数，不是
        if(x < 0)
            return false;

        // 长度为 1
        if(x < 10)
            return true;

        // 长度 >=2, 正数
        int xxLen = util.getLen(x);
        int[] reversedArr = util.getIth(x, xxLen);
        return checkArr(reversedArr, xxLen);
    }

    public static boolean checkArr(int[] arr, int eleNum){
        // 检查是否是 回文
        /*
         len=5: 01(2)34: i=0~2, j=4-i
         len=6: 01(2)(3)45: i=0~2, j=5-i
         */
        int midIdx = eleNum/2;
        for(int i = 0; i <= midIdx; i++){
            if(arr[i] != arr[eleNum - 1 - i])
                return false;
        }
        return true;
    }



}
