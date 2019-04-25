package dataStructure.A_linear_data_structure.xx_1_arr;

public class x_3_type {
    public static void main(String[] args){
        /*
        ------------------------------------------------------------------------------------------------------------
        数组的 类型
        ------------------------------------------------------------------------------------------------------------
        */

        int intArray[] = new int[3];
        byte byteArray[] = new byte[3];
        short shortsArray[] = new short[3];
        String[] strArray = new String[3];

        System.out.println(intArray.getClass()); // class [I
        System.out.println(intArray.getClass().getSuperclass()); // class java.lang.Object
        System.out.println(byteArray.getClass()); // class [B
        System.out.println(shortsArray.getClass()); // class [S
        System.out.println(strArray.getClass()); // class [Ljava.lang.String;

    }
}
