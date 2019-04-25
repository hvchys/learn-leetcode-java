package dataStructure.A_linear_data_structure.xx_1_arr;

import Util.printData;
import dataStructure.A_linear_data_structure.Student;

public class x_4_obj_type {
    public static void main(String[] args){
        /*
        ------------------------------------------------------------------------------------------------------------
        object类型的数组
        ------------------------------------------------------------------------------------------------------------
        */
        Student[] stuArr = new Student[5];

        System.out.println(stuArr[0]); // null
        System.out.println(stuArr.length); // 5
        // System.out.println(stuArr[0].getClass());
        // 这句话会报异常: NullPointerException
        // 这样子new出来的有问题???

        stuArr[0] = new Student("a", 1);
        stuArr[1] = new Student("b", 2);
        stuArr[2] = new Student("c", 3);
        stuArr[3] = new Student("d", 5);
        stuArr[4] = new Student("e", 2);

        printData.ver1arr("", stuArr);

    }
}
