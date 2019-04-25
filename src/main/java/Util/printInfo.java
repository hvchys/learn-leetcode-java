package Util;

public class printInfo {

    public static void infoArr(String[] nameArr, int[] valArr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nameArr.length - 1; i++){
            sb.append(nameArr[i]).append(": ").append(valArr[i]).append(", ");
        }
        int lastIdx = nameArr.length - 1;
        sb.append(nameArr[lastIdx]).append(": ").append(valArr[lastIdx]);
        System.out.println(sb.toString());
    }

    public static void infoArr(String[] nameArr, double[] valArr){

    }

}
