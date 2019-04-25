package leetCode.others;


public class x_11_v2 {
    /*
    冒泡排序，太慢了
    改成 快速排序
    也不行，如果原来的数组很大，还彻底是个逆序的话，就完了
     */

    public static void swap(int[] arr, int i, int j){
        // 需要修改 i, j 这俩的 val
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int maxArea(int[] height) {
        int eleNum = height.length;
        int[] curIdxToOriIdx = initializeCurIdxToOriIdx(eleNum);

        // height 会被排序
        sort(height, curIdxToOriIdx, eleNum);

        int[] deltaToS = getDeltaToS(height, curIdxToOriIdx, eleNum);
        int ans = 0;
        int curS;
        // 01234, deltaMax: 4
        for(int delta = 1; delta < eleNum; delta++){
            curS = deltaToS[delta] * delta;
            if(curS > ans)
                ans = curS;
        }

        return ans;
    }

    public static int[] getDeltaToS(int[] sortedArr, int[] curIdxToOriIdx, int eleNum){
        int[] ans = new int[eleNum];
        // ans[i]: 默认是 0
        int curHeight;
        int curDelta;

        for(int i = 0; i < eleNum; i++){
            for(int j = i + 1; j < eleNum; j++){
                curDelta = Math.abs(curIdxToOriIdx[i] - curIdxToOriIdx[j]);
                curHeight = sortedArr[i];
                if(curHeight > ans[curDelta])
                    ans[curDelta] = curHeight;
            }
        }

        return ans;
    }

    // ------------------------------------------------------------------------------------------
    // 【快速排序】的修改

    public static int[] initializeCurIdxToOriIdx(int eleNum){
        int[] curIdxToOriIdx = new int[eleNum];
        for(int i = 0; i < eleNum; i++)
            curIdxToOriIdx[i] = i;
        return curIdxToOriIdx;
    }

    // 把 最后一个元素 当做 pivot, 小于pivot的放在前面，大于pivot的放在后面
    // 处理 arr[idxStart]~arr[idxEnd]
    public static int partition(int[] arr, int idxStart, int idxEnd, int[] curIdxToOriIdx) {
        int pivot = arr[idxEnd], i = idxStart;
        for (int j = idxStart; j <= idxEnd - 1; j++) {
            if (arr[j] <= pivot) {
                // 互换 arr[i] 和 arr[j]
                swap(arr, i, j);
                swap(curIdxToOriIdx, i, j);
                i++;
            }
        }

        // 互换 arr[i] 和 arr[idxEnd]
        swap(arr, i, idxEnd);
        swap(curIdxToOriIdx, i, idxEnd);

        return i;
    }

    public static void sort(int[] arr, int idxStart, int idxEnd, int[] curIdxToOriIdx){
        // System.out.println("start: " + idxStart + ", end: " + idxEnd);
        if(idxStart >= idxEnd){
            return;
        }else if(idxEnd - idxStart == 1){
            if(arr[idxStart] > arr[idxEnd]){
                swap(arr, idxStart, idxEnd);
                swap(curIdxToOriIdx, idxStart, idxEnd);
            }
        }else{
            int curPartition = partition(arr, idxStart, idxEnd, curIdxToOriIdx);
            sort(arr, idxStart, curPartition - 1, curIdxToOriIdx);
            sort(arr, curPartition + 1, idxEnd, curIdxToOriIdx);
        }
    }

    public static void sort(int[] arr, int[] curIdxToOriIdx, int eleNum){
        sort(arr, 0, eleNum - 1, curIdxToOriIdx);
    }

    // ------------------------------------------------------------------------------------------


    public static void main(String[] args){

        int[] arr = {1,8,6,2,5,4,8,3,7};
        int eleNum = arr.length;
        int maxS = maxArea(arr);

        System.out.println(maxS);

    }

}
