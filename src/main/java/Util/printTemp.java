package Util;


public class printTemp {

    public static void printTwoArr(int[][] arr, int len, String info){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append("i: ").append(i).append(": ");
            for(int j = 0; j < len; j++){
                sb.append(arr[i][j]).append(", ");
            }
            sb.append("\n");
        }
        System.out.println(info + ": \n" + sb);
    }

}
