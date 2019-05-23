package leetCode.twoSum.x_15_3sum;


import Util.printIntData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class x_15_3sum {

    // 【这个思路，放弃吧！！！】【太混乱了！！！】

    /*
    给定 n个int 的 数组，判断其中是否有三个数满足 a+b+c=0 ??
    找出所有可能的 triplets

    注: 不能有重复的解

    例:
    Given array nums = [-1, 0, 1, 2, -1, -4],
    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]

    --------------------------------------------------------------------------------------------------------------------
    【排序先】【解法1】【动态规划】【感觉太复杂了】
    1 如果全都 >0, 全都 <0, 那就没有解了
      如果 eleNum < 3, 也没有解了
    2 二分查找 0 在 其中的 位置, 记为 a, (可能有多个0)

      F(a-1, a+1): arr[(a-1)~(a+1)]: 里面的解的个数
      F(i,j+1): F(i,j) + "arr[j+1]可能参与的解"

      计算 "arr[j+1]可能参与的解": SUM(i,j,-arr[j+1])

      SUM(i,j,t): arr[i~j]里面，二元组(x,y): x+y=t

    --------------------------------------------------------------------------------------------------------------------
    【排序先】【解法2】【在遍历的时候，避免一些不必要的遍历】
    输入: [-1, 0, 1, 2, -1, -4]
    排序: [-4, -1, -1, 0, 1, 2]
    输出: [-1, 0, 1],
         [-1, -1, 2]

    1 如果全都 >0, 全都 <0, 那就没有解了
      如果 eleNum < 3, 也没有解了
    2 二分查找 0 在 其中的 位置, 记为 a, (可能有多个0)

    包含 arr[0] 的答案: b+c = -arr[0]
    当前答案的里面的最小idx是: i, 则:
       arr[(i+1)~(N-1)]: 找 和为 -arr[i] 的:
       子问题: arr[i~j]里面，找俩元素，和等于 x
    --------------------------------------------------------------------------------------------------------------------
    【不排序】【解法3】【分治法???】
    算了，还是排序吧

     */

    /*
    --------------------------------------------------------------------------------------------------------------------
    【排序先】【解法2】【在遍历的时候，避免一些不必要的遍历】
    输入: [-1, 0, 1, 2, -1, -4]
    排序: [-4, -1, -1, 0, 1, 2]
    输出: [-1, 0, 1],
         [-1, -1, 2]

    1 如果全都 >0, 全都 <0, 那就没有解了
      如果 eleNum < 3, 也没有解了
    2 二分查找 0 在 其中的 位置, 记为 a, (可能有多个0)

    包含 arr[0] 的答案: b+c = -arr[0]
    当前答案的里面的最小idx是: i, 则:
       arr[(i+1)~(N-1)]: 找 和为 -arr[i] 的:
       子问题: arr[i~j]里面，找俩元素，和等于 x

     */
//
//    public static Integer firstIdx;
//
//    // 排序，从小到大
//    public static List<List<Integer>> threeSum(int[] nums) {
//        // 排好序先
//        Arrays.sort(nums);
//        printIntData.arrWithIdx("arr sort", nums);
//
//        List<List<Integer>> ans = new ArrayList<>();
//        int eleNum = nums.length;
//        int curSum;
//        for(int i = 0; i < eleNum-2; i++){
//            curSum = -nums[i];
//            firstIdx = i;
//            twoSumInOrder(nums, i+1, eleNum-1, curSum, ans);
//
//        }
//        return ans;
//    }
//
//
//    public static void twoSumInOrder(int[] arr, int i, int j, int sum, List<List<Integer>> ans){
//        // arr[i~j]里面，找俩元素，和等于 sum
//        // List<List<Integer>> ans = new ArrayList<>();
//
//        int midIdx = binarySearch_2(arr, i, j, sum/2);
//        // int midIdx = 3;
//        // arr[midIdx]: 最后一个 <= sum/2 的数
//
//        System.out.println("\n[" + i + ", " + j + "]" + ", sum: " + sum + ", midIdx: " + midIdx);
//        /*
//        以 midIdx 为中心，向 两边 发散: 可是，这样子做，不能保证得到的结果是字典序
//           0 1 2 (3) 3 4 5 6, sum=7
//         */
//        if(midIdx != -1){
//            int x1 = -sum;
//            int idxRightStart = midIdx + 1;
//            int idxRight;
//            // int preValLeft = Integer.MIN_VALUE;
//            int curValLeft, curValRight;
//            int curSum;
//            boolean isValid;
//
//            for(int idxLeft = i; idxLeft <= midIdx; idxLeft++){
//                curValLeft = arr[idxLeft];
//                isValid = true;
//                idxRight = idxRightStart;
//                while(idxRight <= j && isValid){
//                    curValRight = arr[idxRight];
//                    curSum = curValLeft + curValRight;
//                    if(curSum == sum){
//                        // System.out.println(firstIdx + ", " + idxLeft + ", " + idxRight);
//                        // 没有出现过
//                        if(checkNeverOccurred(x1, curValLeft, curValRight, ans)){
//                            List<Integer> pair = new ArrayList<Integer>();
//                            pair.add(-sum);
//                            pair.add(curValLeft);
//                            pair.add(curValRight);
//                            ans.add(pair);
//                            isValid = false;
//                        }
//                    }else if(curSum > sum){
//                        isValid = false;
//                    }
//                    idxRight++;
//                }
//            }
//        }
//    }
//
//    public static boolean checkNeverOccurred(int x1, int x2, int x3, List<List<Integer>> ans){
//        // ans: 升序 排列
//        for(List<Integer> curAns: ans){
//            if(curAns.get(0) > x1)
//                return true;
//            else if(curAns.get(0) == x1){
//                if(curAns.get(1) > x2)
//                    return true;
//                else if(curAns.get(1) == x2){
//                    // simple
//                    if(curAns.get(2) > x3)
//                        return true;
//                    else if(curAns.get(2) == x3)
//                        return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static int binarySearch_2(int[] arr, int i, int j, double x){
//        // arr[i~j]里面, 找 k，使得 arr[k] < x < arr[k+1]: 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
//        // 如果 x 比所有元素大 or x 比所有元素小 返回 -1
//        // 如果 x < arr[i]: 返回 -1
//        // 如果 x > arr[j]: 返回 -1
//        int idxStart = i;
//        int idxEnd = j;
//        int mid = (idxStart + idxEnd)/2;
//
//        while(idxEnd - idxStart > 1){
//            if(arr[mid] > x){
//                idxEnd = mid;
//                mid = (idxStart + idxEnd)/2;
//            }else if(arr[mid] < x){
//                idxStart = mid;
//                mid = (idxStart + idxEnd)/2;
//            }else{
//                // arr[mid] == x
//                // 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
//                for(int k = mid; k >= i; k--){
//                    if(arr[k] < x){
//                        return (k+1);
//                    }
//                }
//                return i;
//            }
//        }
//        if(x < arr[idxStart] || x > arr[idxEnd]){
//            return -1;
//        }
//        // 到这里了，那就只能是: arr[idxStart] <= x <= arr[idxEnd]
//        if(arr[idxStart] < x && x < arr[idxEnd]){
//            return idxStart;
//        }
//        if(x == arr[idxStart])
//            return idxStart;
//        if(x == arr[idxEnd])
//            return idxEnd;
//        return -100;
//    }
//
//    // -----------------------------------------------------------------------------------------------

    public static void printCurAns(List<Integer> curAns){
        for(int x: curAns){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void printAns(List<List<Integer>> ans){
        for(List<Integer> curAns: ans){
            printCurAns(curAns);
        }
    }

//    public static void checkThreeSum(){
//        int[] arr = {0,2,1,4,-3,-2,0};
//        // (00)-03 (01)-02 (02)00 (03)00 (04)01 (05)02 (06)04
//
//        List<List<Integer>> ans = threeSum(arr);
//        printAns(ans);
//    }
//
//    public static void main(String[] args) {
//
//        checkThreeSum();
//
//        /*
//        arr sort: (00)-04 (01)-01 (02)-01 (03)00 (04)01 (05)02
//        i: 1, j: 5, sum: 4, midIdx: 5
//        i: 2, j: 5, sum: 1, midIdx: 3
//        i: 3, j: 5, sum: 1, midIdx: 3
//        i: 4, j: 5, sum: 0, midIdx: -1
//        i: 5, j: 5, sum: -1, midIdx: -1
//        -1 0 1
//        -1 0 1
//        -1 0 1
//
//
//         */
//
//
//    }
//
//    public static void printInfo(int[] arr, int midIdx, int midIdxCheck){
//        String info;
//        if(midIdx != -1 && midIdxCheck != -1){
//            info = "midIdx: " + midIdx + ", " + arr[midIdx] + " | simple: " + midIdxCheck + ", " + arr[midIdxCheck];
//        }else if(midIdx == -1){
//            info = "midIdx: " + midIdx + " | simple: " + midIdxCheck + ", " + arr[midIdxCheck];
//        }else{
//            info = "midIdx: " + midIdx + ", " + arr[midIdx] + " | simple: " + midIdxCheck;
//        }
//        System.out.println(info);
//    }
//
}

