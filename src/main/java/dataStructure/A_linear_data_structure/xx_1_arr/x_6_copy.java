package dataStructure.A_linear_data_structure.xx_1_arr;

import Util.printData;
import Util.printIntData;
import dataStructure.A_linear_data_structure.Student;

import java.util.Arrays;

public class x_6_copy {

    public static void copyMethodIntCheck(int[] oriArr, int[] newArr, int oriX, int newX){
        printData.queryAndAns("oriArr == newArr", oriArr == newArr);
        printData.queryAndAns("oriArr[0] == newArr[0]", oriArr[0] == newArr[0]);
        printData.queryAndAns("oriArr[1] == newArr[1]", oriArr[1] == newArr[1]);

        printIntData.ver1arr("oriArr", oriArr);
        printIntData.ver1arr("newArr", newArr);

        newArr[0] = newX;
        oriArr[2] = oriX;

        printIntData.ver1arr("oriArr", oriArr);
        printIntData.ver1arr("newArr", newArr);
    }

    public static void copyMethodCheck(Student[] oriArr, Student[] newArr, String oriX, String newX){
        printData.queryAndAns("oriArr == newArr", oriArr == newArr);
        printData.queryAndAns("oriArr[0] == newArr[0]", oriArr[0] == newArr[0]);
        printData.queryAndAns("oriArr[1] == newArr[1]", oriArr[1] == newArr[1]);

        printData.ver1arr("oriArr", oriArr);
        printData.ver1arr("newArr", newArr);

        newArr[0].name = newX;
        oriArr[2].name = oriX;

        printData.ver1arr("oriArr", oriArr);
        printData.ver1arr("newArr", newArr);
    }

    public static void objTest_1(){
        Student[] stuArr_1 = new Student[4];
        stuArr_1[0] = new Student("x1", 1);
        stuArr_1[1] = new Student("x2", 2);
        stuArr_1[2] = new Student("x3", 3);
        stuArr_1[3] = new Student("x4", 4);

        Student[] StuCopyArr_1 = Arrays.copyOfRange(stuArr_1, 0, 3);
        copyMethodCheck(stuArr_1, StuCopyArr_1, "oriX", "newX");
    }

    public static void objTest_2(){
        Student[] stuArr_2 = new Student[4];
        stuArr_2[0] = new Student("y1", 11);
        stuArr_2[1] = new Student("y2", 12);
        stuArr_2[2] = new Student("y3", 13);
        stuArr_2[3] = new Student("y4", 14);
        Student[] copyArr_2 = new Student[4];
        System.arraycopy(stuArr_2, 0, copyArr_2, 0, 4);
        copyMethodCheck(stuArr_2, copyArr_2, "oriX", "newX");
    }

    public static void main(String[] args) {
        /*
         copyArr = Arrays.copyOfRange(intArr, 2, 4);
         int[] rc = Arrays.copyOf(r, n);
         System.arraycopy(leetCode.arr, leetCode.arr.length/2, secondHalf, 0, secondHalfLength);
         */

        /*
        ------------------------------------------------------------------------------------------------------------
        一维int数组
        ------------------------------------------------------------------------------------------------------------
        */
        int[] intArr_1 = {0,1,2,3,4,5,6,7};
        int[] copyArr_1 = Arrays.copyOfRange(intArr_1, 0, 4);
        copyMethodIntCheck(intArr_1, copyArr_1, 50, 100);
        /*
        oriArr == newArr: false
        oriArr[0] == newArr[0]: true
        oriArr[1] == newArr[1]: true
        oriArr: 0, 1, 2, 3, 4, 5, 6, 7
        newArr: 0, 1, 2, 3
        oriArr: 0, 1, 50, 3, 4, 5, 6, 7
        newArr: 100, 1, 2, 3
         */

        int[] intArr_2 = {10,11,12,13,14,15,16,17};
        int[] copyArr_2 = Arrays.copyOf(intArr_2, 3);
        copyMethodIntCheck(intArr_2, copyArr_2, 52, 102);
        /*
        oriArr == newArr: false
        oriArr[0] == newArr[0]: true
        oriArr[1] == newArr[1]: true
        oriArr: 10, 11, 12, 13, 14, 15, 16, 17
        newArr: 10, 11, 12
        oriArr: 10, 11, 52, 13, 14, 15, 16, 17
        newArr: 102, 11, 12
         */

        int[] intArr_3 = {100,101,102,103,104,105,106,107};
        int[] copyArr_3 = new int[8];
        System.arraycopy(intArr_3, 0, copyArr_3, 0, 8);
        copyMethodIntCheck(intArr_3, copyArr_3, 53, 103);
        /*
        oriArr == newArr: false
        oriArr[0] == newArr[0]: true
        oriArr[1] == newArr[1]: true
        oriArr: 100, 101, 102, 103, 104, 105, 106, 107
        newArr: 100, 101, 102, 103, 104, 105, 106, 107
        oriArr: 100, 101, 53, 103, 104, 105, 106, 107
        newArr: 103, 101, 102, 103, 104, 105, 106, 107
         */

        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><>");
        /*
        ------------------------------------------------------------------------------------------------------------
        object数组
        ------------------------------------------------------------------------------------------------------------
        */
        System.out.println("object数组");

        objTest_1();
        /*
            oriArr == newArr: false
            oriArr[0] == newArr[0]: true
            oriArr[1] == newArr[1]: true
            oriArr:
            x1, 1 | x2, 2 | x3, 3 | x4, 4 |
            newArr:
            x1, 1 | x2, 2 | x3, 3 |
            oriArr:
            newX, 1 | x2, 2 | oriX, 3 | x4, 4 |
            newArr:
            newX, 1 | x2, 2 | oriX, 3 |
         */

        objTest_2();
        /*
            oriArr == newArr: false
            oriArr[0] == newArr[0]: true
            oriArr[1] == newArr[1]: true
            oriArr:
            y1, 11 | y2, 12 | y3, 13 | y4, 14 |
            newArr:
            y1, 11 | y2, 12 | y3, 13 | y4, 14 |
            oriArr:
            newX, 11 | y2, 12 | oriX, 13 | y4, 14 |
            newArr:
            newX, 11 | y2, 12 | oriX, 13 | y4, 14 |
         */




        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><>");
        /*
        ------------------------------------------------------------------------------------------------------------
        多维数组
        ------------------------------------------------------------------------------------------------------------
        */
        System.out.println("多维数组");
    }

}
