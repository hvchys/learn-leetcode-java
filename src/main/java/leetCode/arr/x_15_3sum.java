package leetCode.arr;

import java.util.ArrayList;
import java.util.List;

import Util.printIntData;


public class x_15_3sum {
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

    // 排序，从小到大
    public static List<List<Integer>> threeSum(int[] nums) {
        // 排好序先
        List<List<Integer>> ans = new ArrayList<>();



        return ans;
    }

    // 不行了 我觉得我乱套了.... 相同元素 考虑起来 太麻烦了...
    public static List<List<Integer>> twoSum(int[] arr, int i, int j, int sum){
        // arr[i~j]里面，找俩元素，和等于 sum
        List<List<Integer>> ans = new ArrayList<>();

        int midIdx = binarySearch(arr, i, j, sum/2);
        // arr[midIdx]: 最后一个 <= sum/2 的数

        /*
        以 midIdx 为中心，向 两边 发散
           0 1 2 (3) 3 4 5 6, sum=7
         */
        int preIdxRight = midIdx + 1;
        int curIdxRight;
        for(int idxLeft = midIdx; idxLeft >= i; idxLeft--){
            curIdxRight = preIdxRight;
            while(curIdxRight <= j){

                curIdxRight++;
            }
        }

        return ans;
    }

    public static int binarySearch(int[] arr, int i, int j, int x){
        // arr[i~j]里面, 找 最后一个 <= x 的数 的 idx
        // arr[i~j]里面, 找 k，使得 arr[k] <= x <= arr[k+1]: 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
        // 如果 x 比所有元素大 or x 比所有元素小 返回 -1
        // 如果 x < arr[i]: 返回 -1
        // 如果 x > arr[j]: 返回 -1
        int idxStart = i;
        int idxEnd = j;
        int mid = (idxStart + idxEnd)/2;
        while(idxEnd - idxStart > 1){
            // (00)00 (01)00 (02)01 (03)02 (04)04 (05)06
            if(arr[mid] > x){
                idxEnd = mid;
                mid = (idxStart + idxEnd)/2;
            }else if(arr[mid] < x){
                idxStart = mid;
                mid = (idxStart + idxEnd)/2;
            }else{
                // arr[mid] == x
                // 如果 arr里面有多个元素和 x 相等，返回 最前面 那个
                for(int k = mid; k >= i; k--){
                    if(arr[k] < x)
                        return (k+1);
                }
            }
        }
        // 还是 有可能 的 idxStart, idxEnd
        if(x < arr[idxStart] || x > arr[idxEnd])
            return -1;
        if(x >= arr[idxStart] && x < arr[idxEnd])
            return idxStart;

        return idxEnd;
    }

    public static void checkBinarySearch(){
        int[] arr = {0,0,1,2,2,2,4,6};
        // (00)00 (01)00 (02)01 (03)02 (04)02 (05)02 (06)04 (07)06

        printIntData.arrWithIdx("", arr);
        int ans = binarySearch(arr, 1,4,2);
        System.out.println(ans);
    }

    public static void main(String[] args) {

        checkBinarySearch();

        //


    }

}






