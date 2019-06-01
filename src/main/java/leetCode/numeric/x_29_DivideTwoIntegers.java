package leetCode.numeric;

public class x_29_DivideTwoIntegers {

    /*
    不可以用 乘法、除法、取模
    Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
    Return the quotient after dividing dividend by divisor.

    The integer division should truncate toward zero.

    Example 1:
    Input: dividend = 10, divisor = 3
    Output: 3

    Example 2:
    Input: dividend = 7, divisor = -3
    Output: -2

    Note:
    1 Both dividend and divisor will be 32-bit signed integers.
    2 The divisor will never be 0.
    3 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
      [−2^31,  2^31−1].
      For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.

     */

    /*
    输入是 -2147483648, -1 的时候，会报错
     */
    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        if(dividend > 0){
            if(divisor > 0){
                return calPosi(dividend, divisor);
            }else{
                return -calPosi(dividend, -divisor);
            }
        }else{
            if(divisor > 0){
                return -calPosi(-dividend, divisor);
            }else{
                return calPosi(-dividend, -divisor);
            }
        }
    }

    public int calPosi(int x, int y){
        // 计算 x/y 的整数部分，x,y > 0
        int count = 0;
        int xLeft = x;
        while (xLeft >= y){
            xLeft = xLeft - y;
            count++;
        }
        return count;
    }

}
