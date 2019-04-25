package Util;

public class printData {

    public static void test(String info, Object[] arr){
        System.out.println(info + ": "+ arr[0]);
    }

    public static void queryAndAns(String info, Object input){
        System.out.println(info + ": " + input);
    }

    public static void ver1arr(String info, Object[] arr){
        StringBuilder sb = new StringBuilder();
        for(Object i: arr){
            sb.append(i.toString()).append(" | ");
        }
        String allStr = sb.toString();
        if(info.equals("")){
            System.out.println(allStr);
        }else{
            System.out.println(info + ": \n" + allStr);
        }
    }

    public static void ver2arr(String info, Object[][] arr){
        int ver1Len = arr.length;
        System.out.println(info + ": \n************************");
        for(int i = 0; i < ver1Len; i++){
            ver1arr("idx " + Integer.toString(i), arr[i]);
        }
        System.out.println("************************");
    }

}
