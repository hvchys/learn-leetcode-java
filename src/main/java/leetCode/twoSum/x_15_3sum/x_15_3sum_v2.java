package leetCode.twoSum.x_15_3sum;


import Util.printIntData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class x_15_3sum_v2 {

    // 有重复，需要继续 考虑 边界
    // 在 firstIdx 变大的时候，需要考虑边界。【啊！我考虑不清楚！放弃了！】

    public static int FIRST_IDX;

    // 排序，从小到大
    public static List<List<Integer>> threeSum(int[] nums) {
        // 排好序先
        Arrays.sort(nums);
        printIntData.arrWithIdx("arr sort", nums);
        List<List<Integer>> ans = new ArrayList<>();
        int eleNum = nums.length;
        int preFirstVal = Integer.MIN_VALUE, curFirstVal;
        int idx2Min = 1, idx3Max = nums.length-1;
        for(int i = 0; i < eleNum-2; i++, idx2Min++){
            FIRST_IDX = i;

//            idx2Min = toTheRight(nums, idx2Min, idx3Max);
//            if(idx2Min == -1)
//                break;

            System.out.println("i: " + i + ", idx2Min: " + idx2Min + ", idx3Max: " + idx3Max);

            curFirstVal = nums[i];
            if(curFirstVal == preFirstVal){
                idx2Min = toTheRight(nums, idx2Min, idx3Max);
                idx3Max = toTheLeft(nums, idx3Max, idx2Min);
            }else{
                preFirstVal = curFirstVal;
            }
            if(idx2Min < idx3Max && i < idx2Min){
                twoSum(nums, idx2Min, idx3Max, nums[i], ans);
            } else
                break;

        }
        return ans;
    }

    public static void twoSum(int[] arr, int idxStart, int idxEnd, int firstVal, List<List<Integer>> ans) {
        int idxLeft = idxStart, idxRight = idxEnd, sum = -firstVal;
        int curSum;
        while (idxLeft < idxRight && idxLeft != -1 && idxRight != -1) {
            System.out.println("line 54, idx: " + FIRST_IDX + ", " + idxLeft + ", " + idxRight);

            curSum = arr[idxLeft] + arr[idxRight];
            if(curSum > sum){
                idxRight = toTheLeft(arr, idxRight, idxLeft);
            }else if(curSum < sum){
                idxLeft = toTheRight(arr, idxLeft, idxRight);
            }else{
                // 是一个解
                ans.add(Arrays.asList(firstVal, arr[idxLeft], arr[idxRight]));

                System.out.println("idx: " + FIRST_IDX + ", " + idxLeft + ", " + idxRight);

                // 更新idx，继续求解
                idxRight = toTheLeft(arr, idxRight, idxLeft);
                idxLeft = toTheRight(arr, idxLeft, idxRight);
            }
        }
    }

    public static int toTheLeft(int[] arr, int i, int smallest){
        // 往左边挪，直到 取值 < arr[i], 要求 答案 > smallest
        int idx = i-1;
        int checkVal = arr[i];
        while(idx > smallest){
            if(arr[idx] == checkVal)
                idx--;
            else{
                return idx;
            }
        }
        return -1;
    }

    public static int toTheRight(int[] arr, int j, int biggest){
        // 往右边挪，直到 取值 > arr[i], 要求 答案 < biggest
        int idx = j+1;
        int checkVal = arr[j];
        while(idx < biggest){
            if(arr[idx] == checkVal)
                idx++;
            else{
                return idx;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        // int[] arr = {-4,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        // int[] arr = {-1,1,-1,1};
        int[] arr = {-1,-2,0,1,2,-1,-4};

        List<List<Integer>> ans = threeSum(arr);

        System.out.println("----------------");
        x_15_3sum.printAns(ans);

    }

}

