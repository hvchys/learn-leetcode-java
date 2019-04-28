package leetCode.twoSum;

import Util.printIntData;

import java.util.ArrayList;
import java.util.List;





//
//public class x_15_v2 {
//    /*
//    // 数组里面有相同元素的情况，太复杂了，先 不考虑了
//
//    给定 n个int 的 数组，判断其中是否有三个数满足 a+b+c=0 ??
//    找出所有可能的 triplets
//
//    注: 不能有重复的解
//
//    例:
//    Given array nums = [-1, 0, 1, 2, -1, -4],
//    A solution set is:
//    [
//      [-1, 0, 1],
//      [-1, -1, 2]
//    ]
//
//    --------------------------------------------------------------------------------------------------------------------
//    【排序先】【解法2】【在遍历的时候，避免一些不必要的遍历】
//    输入: [-1, 0, 1, 2, -1, -4]
//    排序: [-4, -1, -1, 0, 1, 2]
//    输出: [-1, 0, 1],
//         [-1, -1, 2]
//
//    1 如果全都 >0, 全都 <0, 那就没有解了
//      如果 eleNum < 3, 也没有解了
//    2 二分查找 0 在 其中的 位置, 记为 a, (可能有多个0)
//
//    包含 arr[0] 的答案: b+c = -arr[0]
//    当前答案的里面的最小idx是: i, 则:
//       arr[(i+1)~(N-1)]: 找 和为 -arr[i] 的:
//       子问题: arr[i~j]里面，找俩元素，和等于 x
//
//     */
//
//    public static Integer firstIdx;
//
//    // 排序，从小到大
//    public static List<List<Integer>> threeSum(int[] nums) {
//        // 排好序先
//        x_1_quickSort_clear.sort(nums);
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
//    public static void twoSumInOrder(int[] arr, int i, int j, int sum, List<List<Integer>> ans){
//        // arr[i~j]里面，找俩元素，和等于 sum
//        // List<List<Integer>> ans = new ArrayList<>();
//
//        int midIdx = binarySearch(arr, i, j, sum/2);
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
//                // System.out.println("firstIdx: " + firstIdx + ", idxLeft: " + idxLeft + ", idxRightStart: " + idxRightStart);
//                if(idxLeft <= midIdx){
//                    isValid = true;
//                    idxRight = idxRightStart;
//                    while(idxRight <= j && isValid){
//                        curValRight = arr[idxRight];
//                        curSum = curValLeft + curValRight;
//                        if(curSum == sum){
//                            // System.out.println(firstIdx + ", " + idxLeft + ", " + idxRight);
//                            // 没有出现过
//                            if(checkNeverOccurred(x1, curValLeft, curValRight, ans)){
//                                List<Integer> pair = new ArrayList<Integer>();
//                                pair.add(-sum);
//                                pair.add(curValLeft);
//                                pair.add(curValRight);
//                                ans.add(pair);
//                                isValid = false;
//                            }
//                        }else if(curSum > sum){
//                            isValid = false;
//                        }
//                        idxRight++;
//                    }
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
//                    // check
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
//    public static int binarySearch(int[] arr, int i, int j, int x){
//        // arr[i~j]里面, 找 k，使得 arr[k] <= x <= arr[k+1]: 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
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
//                    if(arr[k] < x)
//                        return (k+1);
//                }
//                return i; // 都相等
//            }
//        }
//        // System.out.println("idxStart: " + i + ", idxEnd: " + j + ", mid: " + mid);
//        // 还是 有可能 的 idxStart, idxEnd
//        if(x < arr[idxStart] || x > arr[idxEnd])
//            return -1;
//        else{
//            // x >= arr[idxStart] && x <= arr[idxEnd]
//            for(int k = idxEnd; k >= i; k--){
//                if(arr[k] < x)
//                    return (k+1);
//            }
//            return idxStart;
//        }
//    }
//
//    public static void checkBinarySearch(){
//        int[] arr = {0,0,1,2,2,2,4,6};
//        // (00)00 (01)00 (02)01 (03)02 (04)02 (05)02 (06)04 (07)06
//
//        printIntData.arrWithIdx("", arr);
//        int ans = binarySearch(arr, 1,4,-2);
//        System.out.println(ans);
//    }
//
//    public static void printCurAns(List<Integer> curAns){
//        for(int x: curAns){
//            System.out.print(x + " ");
//        }
//        System.out.println();
//    }
//
//    public static void printAns(List<List<Integer>> ans){
//        for(List<Integer> curAns: ans){
//            printCurAns(curAns);
//        }
//    }
//
//    public static void checkThreeSum(){
//        int[] arr = {0,-4,-1,-4,-2,-3,2};
//        // (00)00 (01)00 (02)01 (03)02 (04)02 (05)02 (06)04 (07)06
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
//}
//
//
