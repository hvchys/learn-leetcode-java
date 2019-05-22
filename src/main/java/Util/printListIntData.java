package Util;

import java.util.List;

public class printListIntData {

    public static void print(String info, List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for(int x: list){
            sb.append(x).append(", ");
        }
        System.out.println(info + ": " + sb.toString());
    }


}
