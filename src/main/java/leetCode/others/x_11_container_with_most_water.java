package leetCode.others;

import Util.printIntData;


public class x_11_container_with_most_water {
    /*
    给定 n 个 非负整数: a_1, a_2, ..., a_n: a_i表示点X_i: (i, a_i)
    对每个点 X_i, 画一条竖线: X_i -> (i, 0): 记这条线段为 T_i
    找 T_i, T_j, 在上面加一条横线，和X轴一起，得到一个 container，希望 container 包含 尽可能多的水

    注: n >= 2

    S(i, j) = (j - i)* min(X_i, X_j)

    A(i, j): 起点边为 i, 终点边 <= j 的 最大 container

    --------------------------------------------------------------------------------------------------------------------
    【思路1】
    这样子，基本上就是暴力全部比较:
    A(i, j+1): 1. S(i, j+1) >  A(i, j): A(i, j+1) = S(i, j+1)
               2. S(i, j+1) <= A(i, j): A(i, j+1) = A(i, j)
    A(1, k+1)

    --------------------------------------------------------------------------------------------------------------------
    【思路2】
    j-i = delta
    F(x): delta为x的时候，最大的面积
    所以，希望对于每个 (i,j) 很快的判断谁小 --> 这是 冒泡排序 的中间结果吧？

    所以，通过冒泡排序，得到一个 HashMap: key: (i,j) val: min(X_i, X_j)
     */

    // 返回值: ans[i]: delta为i的时候，可能的最大的高度
    public static int[] getDeltaToSFromBubble(int[] arr, int eleNum){

        // 三个关键值: oriIdx, curIdx, val:
        // oriArr: oriIdx -> val
        // markArr: markArr[i]: 第i小的值，在原始arr里面的位置 ??? why ???
        // arr: curIdx -> val
        int[] markArr = initializeMarkArr(eleNum);

        // bubble !!
        modifyMarkArr(markArr, arr, eleNum);

        // input: (0)12, (1)13, (2)11, (3)14, (4)10, (5)15, (6)09
        //        (0)09, (1)10, (2)11, (3)12, (4)13, (5)14, (6)15
        // 第i小的值，在原始arr里面的位置: 6, 4, 2, 0, 1, 3, 5: val -> oriIdx
        //              curIdxToOriIdx: 6, 4, 2, 0, 1, 3, 5
        //              oriIdxToCurIdx: 3, 4, 2, 5, 1, 6, 0

        // markArr == curIdxToOriIdx

        /*
        oriArr:         (00)01 (01)08 (02)06 (03)02 (04)05 (05)04 (06)08 (07)03 (08)07
        sort:           (00)01 (01)02 (02)03 (03)04 (04)05 (05)06 (06)07 (07)08 (08)08
        curIdxToOriIdx: (00)00 (01)03 (02)07 (03)05 (04)04 (05)02 (06)08 (07)01 (08)06
        oriIdxToCurIdx: (00)00 (01)07 (02)05 (03)01 (04)04 (05)03 (06)08 (07)02 (08)06
         */
        return getDeltaToS(arr, markArr, eleNum);
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

    public static void modifyMarkArr(int[] curIdxToOriIdx, int[] arr, int eleNum){
        // 修改 bubbleSort
        boolean needNextPass = true;

        for(int k = 1; k < eleNum && needNextPass; k++){
            // 这里先默认，不需要 next pass
            needNextPass = false;
            // 进行第 k 次的 pass:
            // 第 k 次，处理: arr[0] ~ arr[eleNum - k - 1]
            for(int i = 0; i < eleNum - k; i++){
                // 如果逆序存在的话:
                if(arr[i] > arr[i+1]){
                    swapVal(curIdxToOriIdx, i);
                    swapVal(arr, i);
                    needNextPass = true;
                }
            }
        }
    }

    public static void swapVal(int[] arr, int i){
        // 需要修改 i, i+1 这俩的 val
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }

    public static int[] initializeMarkArr(int eleNum){
        int[] curIdxToOriIdx = new int[eleNum];
        for(int i = 0; i < eleNum; i++)
            curIdxToOriIdx[i] = i;
        return curIdxToOriIdx;
    }

    public static int maxArea(int[] height) {
        int eleNum = height.length;
        int[] deltaToS = getDeltaToSFromBubble(height, eleNum);
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



    public static int[] getOriIdxToCurIdx(int[] curIdxToOriIdx, int eleNum){
        int[] oriIdxToCurIdx = new int[eleNum];
        int oriIdx;
        for(int curIdx = 0; curIdx < eleNum; curIdx++){
            oriIdx = curIdxToOriIdx[curIdx];
            oriIdxToCurIdx[oriIdx] = curIdx;
        }
        return oriIdxToCurIdx;
    }

    public static void main(String[] args){
//        int[] arr = {12,13,11,14,10,15,9};
//        int eleNum = arr.length;
//        int[] curIdxToOriIdx = initializeMarkArr(eleNum);
//
//        printIntData.ver1arr("before", curIdxToOriIdx);
//
//        // bubble !!
//        modifyMarkArr(curIdxToOriIdx, arr, eleNum);
//
//        printIntData.ver1arr("after", curIdxToOriIdx);
//        printIntData.ver1arr("arr", arr);

        // input: 2,3,1,4,0
        // 第i小的值，在原始arr里面的位置: 4, 2, 0, 1, 3

        // input: (0)12, (1)13, (2)11, (3)14, (4)10, (5)15, (6)09
        //        (0)09, (1)10, (2)11, (3)12, (4)13, (5)14, (6)15
        // 第i小的值，在原始arr里面的位置: 6, 4, 2, 0, 1, 3, 5
        // oriIdxToCurIdx: (0), (1), (2), (3), (4), (5), (6)

        int[] arr = {1,8,6,2,5,4,8,3,7};
        int eleNum = arr.length;
        int maxS = maxArea(arr);

        System.out.println(maxS);

    }

}
