package algoProblems.sort;

public class util {
    // 互换 leetCode.arr[i] 和 leetCode.arr[j]
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 找到数组 leetCode.arr[0~(n-1)] 里面的最大值
    public static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // 找到数组 leetCode.arr[] 里面的最大值
    public static int getMax(int[] arr) {
        int mx = arr[0];
        for(int curVal: arr){
            if(curVal > mx){
                mx = curVal;
            }
        }
        return mx;
    }

}
