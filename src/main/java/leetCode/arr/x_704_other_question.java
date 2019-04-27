package leetCode.arr;

import Util.printIntData;
import Util.randNum;

public class x_704_other_question {

    /*
    【二分查找、更复杂的版本】
    修改了问题:
    1 arr[i~j]里面, 找 k，使得 arr[k] <= x <= arr[k+1]: 如果 arr 里面有多个元素和 x 相等，返回 最前面 那个
    2 arr里面可以有重复内容

     */

    public static int binarySearch(int[] arr, int i, int j, int x){
        int idxStart = i;
        int idxEnd = j;
        int mid = (idxStart + idxEnd)/2;

        while(idxEnd - idxStart > 1){
            if(arr[mid] > x){
                idxEnd = mid;
                mid = (idxStart + idxEnd)/2;
            }else if(arr[mid] < x){
                idxStart = mid;
                mid = (idxStart + idxEnd)/2;
            }else{
                // arr[mid] == x
                // 如果 arr 里面有多个元素和 x 相等，返回 最前面 那个
                for(int k = mid; k >= i; k--){
                    if(arr[k] < x)
                        return (k+1);
                }
                return i; // 都相等
            }
        }
        // System.out.println("idxStart: " + i + ", idxEnd: " + j + ", mid: " + mid);
        // 还是 有可能 的 idxStart, idxEnd
        if(x < arr[idxStart] || x > arr[idxEnd])
            return -1;
        else{
            // x >= arr[idxStart] && x <= arr[idxEnd]
            for(int k = idxEnd; k >= i; k--){
                if(arr[k] < x)
                    return (k+1);
            }
            return idxStart;
        }
    }



    public static void checkBinarySearch(){
        int[] arr = new int[8];
        randNum.getIntArr(arr, 10, 30);
        x_1_quickSort_clear.sort(arr);

        int x = randNum.randInt(10, 30);
        int ans = binarySearch(arr, 0, 7, x);
        int ans_2 = simpleSearch(arr, 0, 7, x);
        if(ans != ans_2){
            System.out.println();
            printIntData.arrWithIdx("", arr);
            System.out.println("x: " + x);
            System.out.println("my: " + ans + ", simple: " + ans_2);
        }

    }

    public static void main(String[] args) {
        int i = 0;
        int errNum = 0;
        while(i < 500){
            checkBinarySearch();
            i++;
            errNum++;
        }
        System.out.println("errNum: " + errNum);
    }



    public static int simpleSearch(int[] arr, int i, int j, int x){
        // arr[i~j]里面, 找 第一个 <= x 的数 的 idx
        // 暴力查找

        boolean isSmall = false;
        for(int k = i; k <= j; k++){
            if(arr[k] <= x)
                isSmall = true;
            if(arr[k] > x && isSmall)
                return (k-1);
        }
        if(isSmall)
            return j;
        else
            return -1;
    }


}
