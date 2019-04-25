package algoProblems.topK;

public class useBubble implements SolveTopK {
    // 冒泡排序

    /**
     1 要排序的数据是整数
     2 数据存储在数组中
     3 数据以升序(从小到大)排列
     */

    public int[] getTopK(int[] arr, int topK){
        boolean needNextPass = true;

        for(int k = 1; k <= topK && needNextPass; k++){
            // System.out.println("k: "+k);

            // 这里先默认，不需要 next pass
            needNextPass = false;
            // 进行第 k 次的 pass:
            // 总共 N 个 元素
            // 第 k 次，处理: leetCode.arr[0] ~ leetCode.arr[N - k - 1]
            for(int i = 0; i < arr.length - k; i++){
                // System.out.println("i: " + i);

                // 如果逆序存在的话:
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    needNextPass = true;
                    // 为什么这里就需要 next pass了?
                    // 答: 不能确定 temp 比后面的内容小
                    //     可以确定 temp 比前面的内容大
                    // 目标: 升序(从小到大)

                    // printIntData.arrWithMark("", leetCode.arr, new int[]{leetCode.arr[i], leetCode.arr[i+1]}, "value");
                }
            }

        }

        int[] ansArr = new int[topK];
        System.arraycopy(arr, arr.length - topK, ansArr, 0, topK);
        return ansArr;
    }

}
