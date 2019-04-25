package dataStructure.A_linear_data_structure.xx_1_arr;

import Util.printData;
import Util.printIntData;
import dataStructure.A_linear_data_structure.Student;

public class x_5_clone {

    public static void main(String[] args) {
        /*
        ------------------------------------------------------------------------------------------------------------
        一维数组的clone
        ------------------------------------------------------------------------------------------------------------
        */

        // 一维数组的clone, 是 deep copy
        int intArr[] = {1,2,3};
        int cloneArr[] = intArr.clone();

        System.out.println(intArr == cloneArr); // false
        System.out.println(intArr[0] == cloneArr[0]); // true
        System.out.println(intArr[1] == cloneArr[1]); // true

        printIntData.ver1arr("intArr", intArr);
        printIntData.ver1arr("cloneArr", cloneArr);
        cloneArr[1] = 100;
        printIntData.ver1arr("intArr", intArr);
        printIntData.ver1arr("cloneArr", cloneArr);

        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><>");
        /*
        ------------------------------------------------------------------------------------------------------------
        二维数组的clone, 是 潜复制
        ------------------------------------------------------------------------------------------------------------
        */
        int intArr_2[][] = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        int cloneArr_2[][] = intArr_2.clone();

        // intArr_2.length: 4
        // intArr_2[1].length: 3

        System.out.println(intArr_2 == cloneArr_2); // false
        System.out.println(intArr_2[0] == cloneArr_2[0]); // true
        System.out.println(intArr_2[1] == cloneArr_2[1]); // true
        System.out.println(intArr_2[2] == cloneArr_2[2]); // true

        printIntData.ver2arr("intArr_2", intArr_2);
        printIntData.ver2arr("cloneArr_2", cloneArr_2);

        cloneArr_2[1][2] = 100;

        printIntData.ver2arr("intArr_2", intArr_2);
        printIntData.ver2arr("cloneArr_2", cloneArr_2);

        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><>");
        /*
        ------------------------------------------------------------------------------------------------------------
        object数组的 clone
        ------------------------------------------------------------------------------------------------------------
        */
        System.out.println("object数组的 clone");
        Student[] stuArr = new Student[3];
        stuArr[0] = new Student("a", 1);
        stuArr[1] = new Student("b", 2);
        stuArr[2] = new Student("c", 3);

        Student[] stuCopyArr = stuArr.clone();

        System.out.println(stuArr == stuCopyArr); // false
        System.out.println(stuArr[0] == stuCopyArr[0]); // true
        System.out.println(stuArr[1] == stuCopyArr[1]); // true
        printData.queryAndAns("stuArr == stuCopyArr", stuArr == stuCopyArr);

        printData.ver1arr("stuArr", stuArr);
        printData.ver1arr("stuCopyArr", stuCopyArr);

        stuArr[2].name = "hahahhahah";

        printData.ver1arr("stuArr", stuArr);
        printData.ver1arr("stuCopyArr", stuCopyArr);

    }

}
