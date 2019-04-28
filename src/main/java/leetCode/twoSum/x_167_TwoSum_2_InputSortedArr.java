package leetCode.twoSum;

import Util.printIntData;

public class x_167_TwoSum_2_InputSortedArr {
    /*
    int 的 arr，已经升序排序
    target
    找两个idx: idx1,idx2, 使得: arr[idx1] + arr[idx2] = target
    (idx1 < idx2)

    注:
    Your returned answers (both index1 and index2) are not zero-based.
    假设:
    1 只有一个解
    2 不能把某个元素，用两次

    例:
    输入: numbers = [2,7,11,15], target = 9
    输出: [1,2]
    (arr[0] + arr[1] = 9)

     */

    /*
    halfVal = target/2 (double类型)
    arr[idx1] <= halfVal
    arr[idx2] >= halfVal
     */

    public static int[] twoSum(int[] numbers, int target) {
        int eleNum = numbers.length;
        int midIdx = binarySearch_2(numbers, target/2.0);

        // System.out.println("midIdx: " + midIdx);
        if(midIdx != -1){
            int idxRightStart = midIdx + 1;
            int idxRight;
            int preValLeft = Integer.MIN_VALUE;
            int curValLeft, curValRight;
            int curSum;
            boolean isValid;

            for(int idxLeft = midIdx; idxLeft >= 0; idxLeft--){
                curValLeft = numbers[idxLeft];
                if(curValLeft == preValLeft){
                    preValLeft = curValLeft;
                    idxRightStart++;
                }
                // System.out.println("firstIdx: " + firstIdx + ", idxLeft: " + idxLeft + ", idxRightStart: " + idxRightStart);
                isValid = true;
                idxRight = idxRightStart;
                while(idxRight <= eleNum-1 && isValid){
                    curValRight = numbers[idxRight];
                    curSum = curValLeft + curValRight;
                    if(curSum == target){
                        // System.out.println(firstIdx + ", " + idxLeft + ", " + idxRight);
                        // 没有出现过
                        return new int[]{idxLeft+1, idxRight+1};
                    }else if(curSum > target){
                        isValid = false;
                    }
                    idxRight++;
                }
            }
        }
        return new int[]{};
    }


    public static int binarySearch_2(int[] arr, double x){
        // arr[i~j]里面, 找 k，使得 arr[k] < x < arr[k+1]: 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
        // 如果 x 比所有元素大 or x 比所有元素小 返回 -1
        // 如果 x < arr[i]: 返回 -1
        // 如果 x > arr[j]: 返回 -1
        int idxStart = 0;
        int idxEnd = arr.length - 1;
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
                // 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
                for(int k = mid; k >= 0; k--){
                    if(arr[k] < x){
                        return (k+1);
                    }
                }
                return 0;
            }
        }
        if(x < arr[idxStart] || x > arr[idxEnd]){
            return -1;
        }
        // 到这里了，那就只能是: arr[idxStart] <= x <= arr[idxEnd]
        if(arr[idxStart] < x && x < arr[idxEnd]){
            return idxStart;
        }
        if(x == arr[idxStart])
            return idxStart;
        if(x == arr[idxEnd])
            return idxEnd;
        return -100;
    }

    public static void main(String[] args){

        int[] arr = {2,7,11,15};
        int target = 9;
        printIntData.ver1arr("", twoSum(arr, target));
    }

}
