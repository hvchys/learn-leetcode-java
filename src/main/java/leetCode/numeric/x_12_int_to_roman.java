package leetCode.numeric;

import Util.printIntData;

public class x_12_int_to_roman {
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

    例:
    3 -> III
    4 -> IV
    9 -> IX
    58 ->  LVIII
    1994 -> MCMXCIV: M = 1000, CM = 900, XC = 90 and IV = 4
    1884             M = 1000, DCCC = 800
    3000 ->          MMM = 3000
     */

    /*
    1994:
    1000, 500, 100, 50, 10, 5, 1
       1,   1,   4,  1,  4, 0, 4
     */

    public static int[] getDetailArr(int num, int[] eachValArr){
        int[] detailArr = new int[7];
        int curValLeft = num;
        for(int i = 0; i < 7; i++){
            detailArr[i] = curValLeft / eachValArr[i];
            curValLeft = curValLeft % eachValArr[i];
        }
        return detailArr;
    }


    public static String intToRoman(int num) {
        int[] eachValArr = {1000, 500, 100, 50, 10, 5, 1};
        // String[] eachStrArr = {"M", "D", "C", "L", "X", "V", "I"};
        int[] detailArr = getDetailArr(num, eachValArr);

        /*
        1994:
        col4  col3      col2    col1
        1000, 500, 100, 50, 10, 5, 1
           1,   1,   4,  1,  4, 0, 4
              (一对儿)  (一对儿) (一对儿)
        1994 -> MCMXCIV: M = 1000, CM = 900, XC = 90 and IV = 4
         */

        String ans = getCol4(detailArr[0]) + getCol123(3, detailArr[1], detailArr[2]) +
                getCol123(2, detailArr[3], detailArr[4]) + getCol123(1, detailArr[5], detailArr[6]);

        return ans;
    }

    public static String getCol4(int x){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < x; i++)
            sb.append("M");
        return sb.toString();
    }

    public static String getCol123(int col, int x, int y){
        String[] strArr;
        String upperStr;
        if(col == 1){
            strArr = new String[]{"V", "I"};
            upperStr = "X";
        }else if(col == 2){
            strArr = new String[]{"L", "X"};
            upperStr = "C";
        }else{
            // col = 3:
            strArr = new String[]{"D", "C"};
            upperStr = "M";
        }
        // x,y: 01, 02, 03, ...
        // x = 0,1
        // y = 0,1,2,3,4
        // 1000, 500, 100, 50,  10,  5,   1
        // "M",  "D", "C", "L", "X", "V", "I"
        // 1994 -> MCMXCIV: M = 1000, CM = 900, XC = 90 and IV = 4
        // if(x == 1 && y == 4)

        /*
        x=0,y=4: 4: 15
        x=1,y=4: 9: 1(10)
         */
        if(y == 4)
            return (x == 0) ? strArr[1] + strArr[0]: strArr[1] + upperStr;

        StringBuilder sb = new StringBuilder();
        if(x == 1)
            sb.append(strArr[0]);

        for(int i = 0; i < y; i++)
            sb.append(strArr[1]);

        return sb.toString();
    }

    public static void test(int x){
        System.out.println(x + ": " + intToRoman(x));
    }


    public static void main(String[] args){
        int num = 1994;
        int[] eachValArr = {1000, 500, 100, 50, 10, 5, 1};
        int[] xxDetailArr = getDetailArr(num, eachValArr);
        printIntData.ver1arr("", xxDetailArr);

        /*
        3 -> III
        4 -> IV
        9 -> IX
        58 ->  LVIII
        1994 -> MCMXCIV: M = 1000, CM = 900, XC = 90 and IV = 4
        1884             M = 1000, DCCC = 800
        3000 ->          MMM = 3000
         */

        test(3);
        test(4);
        test(9);
        test(58);
        test(1994);


    }
}
