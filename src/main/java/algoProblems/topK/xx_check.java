package algoProblems.topK;

import Util.printIntData;
import Util.randNum;

public class xx_check {

    public static int[] run(SolveTopK solveTopK, int[] arr, int topK) {
        int arrLen = arr.length;
        int[] tempArr = new int[arrLen];
        System.arraycopy(arr, 0, tempArr, 0, arrLen);
        return solveTopK.getTopK(arr, topK);
    }

    public static void main(String[] args){
        int[] oriArr = new int[20];
        randNum.getUniqueIntArr(oriArr, 10, 60);
        int topK = 5;

        SolveTopK xxBubble = new useBubble();
        SolveTopK xxMaxHeap = new useMaxHeap();
        SolveTopK xxMinHeap = new useMinHeap();
        SolveTopK xxTempArr = new useTempArr();

        printIntData.ver1arr("input", oriArr);

        printIntData.ver1arr("bubble", run(xxBubble, oriArr, topK));
        printIntData.ver1arr("maxHeap", run(xxMaxHeap, oriArr, topK));
        printIntData.ver1arr("minHeap", run(xxMinHeap, oriArr, topK));
        printIntData.ver1arr("tempArr", run(xxTempArr, oriArr, topK));
    }

}

