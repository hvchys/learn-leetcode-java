package Util;

import java.util.ArrayList;

public class randNum {
    private static boolean isInArr(int[] arr, int curLast, int x){
        int i = 0;
        while(i <= curLast){
            if(arr[i] == x) return true;
            i++;
        }
        return false;
    }

    // 产生一个数列 ver1arr, 其中每个元素属于 [min, max]
    public static void getIntArr(int[] arr, int min, int max){
        int i = 1;
        int x;
        arr[0] = randInt(min, max);
        while(i < arr.length){
            x = randInt(min, max);
            while(isInArr(arr, i-1, x))
                x = randInt(min, max);
            arr[i] = x;
            i++;
        }
    }

    // 返回一个随机数，属于 [min, max]
    private static int randInt(int min, int max){
        // 返回a~(a+b)之间的一个随机整数：[a, a+b)  (包括a，不包括a+b)
        // (int)(a + Math.random()*b);
        int b = max - min + 1;
        return (int)(min + Math.random()*b);
    }

    // 产生一个数列，里面的元素是 [0, size - 1]。元素是这个区间的数据打乱顺序
    public static int[] shuffleArr(int size){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < size; i++)
            list.add(i);
        int[] ans = new int[size];
        for(int i = 0; i < size - 1; i++){
            int curIdx = randInt(0, size - i - 1);
            ans[i] = list.get(curIdx);
            list.remove(curIdx);
        }
        ans[size - 1] = list.get(0);

        return ans;
    }

    public static void main(String[] args){
        int[] arr = shuffleArr(10);

        printIntData.ver1arr("arr", arr);

    }

}
