package dataStructure.A_linear_data_structure.xx_1_arr;

import Util.printIntData;

public class x_2_change {
    private static void changeArr(int[] arr){
        int temp = arr[0];
        arr[0] = arr[3];
        arr[3] = temp;
    }

    public static void main(String[] args){
        // 数组，是指针类型的，这样子传到方法里面，会被方法改变
        int arr_2[] = {11,22,33,44};
        printIntData.ver1arr("", arr_2); // 11, 22, 33, 44
        changeArr(arr_2);
        printIntData.ver1arr("", arr_2); // 44, 22, 33, 11

    }
}
