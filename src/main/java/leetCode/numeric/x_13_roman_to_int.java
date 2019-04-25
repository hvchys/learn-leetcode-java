package leetCode.numeric;

public class x_13_roman_to_int {

    /*
        输入范围: [1, 3999]
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

        I 放在 V(5) 和 X(10) 的前面: 4, 9
        X 放在 L(50) 和 C(100) 的前面: 40, 90
        C 放在 D(500) 和 M(1000) 的前面: 400, 900

        3 -> III
        4 -> IV
        9 -> IX
        58 ->  LVIII
        1994 -> MCMXCIV: M = 1000, CM = 900, XC = 90 and IV = 4
        1884             M = 1000, DCCC = 800
        3000 ->          MMM = 3000

        1994:
        col4  col3      col2    col1
        1000, 500, 100, 50, 10, 5, 1
           1,   1,   4,  1,  4, 0, 4
           M,   D,   C,  L,  X, V, I
              (一对儿)  (一对儿) (一对儿)
        1994 -> MCMXCIV: M = 1000, CM = 900, XC = 90 and IV = 4

        M
        MDC,
        CLX
        XVI

        LXX,IX
         70,9
         */

    public static int romanToInt(String s) {


        return 0;
    }
}
