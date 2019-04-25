package algoProblems.topK;

import Util.printIntData;
import javafx.util.Pair;

public class useTempArr implements SolveTopK {

    private static Pair<Integer, Integer> getTempMin(int[] temp){
        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < temp.length; i++){
            if(temp[i] < min){
                min = temp[i];
                minIdx = i;
            }
        }
        return new Pair<>(minIdx, min);
    }

    public int[] getTopK(int[] arr, int topK){
        int[] temp = new int[topK];
        System.arraycopy(arr, 0, temp, 0, topK);

        printIntData.ver1arr("temp初始化", temp);

        Pair<Integer, Integer> curMin;
        int min;
        int minIdx;

        for(int i = topK; i < arr.length; i++){
            curMin = getTempMin(temp);
            min = curMin.getValue();
            minIdx = curMin.getKey();
            if(arr[i] > min)
                temp[minIdx] = arr[i];
        }
        return temp;
    }

}
