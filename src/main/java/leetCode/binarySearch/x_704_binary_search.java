package leetCode.binarySearch;

public class x_704_binary_search {
    /*
    https://leetcode.com/problems/binary-search/

    给定一个排好序，升序的 整数数组: int[] num: 共 n 个数
    target值
    找 target 在 int[] num 里面的idx, 没有的话，返回 -1

    注:
    1 假设 数组 里面的元素是 互不相同 的
    2 n 取值区间: [1, 10000]
    3 每个元素取值区间: [-9999, 9999]
     */

    public static int search(int[] nums, int target) {
        int eleNum = nums.length;

        int idxStart = 0;
        int idxEnd = eleNum - 1;
        int mid = (idxStart + idxEnd)/2;
        while(idxEnd - idxStart > 1){
            // System.out.println("start: " + idxStart + ", end: " + idxEnd + ", mid: " + mid);
            if(nums[mid] > target){
                idxEnd = mid;
                mid = (idxStart + idxEnd)/2;
            }else if(nums[mid] < target){
                idxStart = mid;
                mid = (idxStart + idxEnd)/2;
            }else
                return mid; // arr[mid] == x
        }
        // 还是有可能 idxStart, idxEnd 和 target 相等
        if(nums[idxStart] == target)
            return idxStart;
        if(nums[idxEnd] == target)
            return idxEnd;

        return -1;
    }


    public static void checkBinarySearch(){
        int[] arr = {0,1,3,5,6,7};
        // (00)00 (01)01 (02)02 (03)04 (04)06 (05)07

        int ans = search(arr, 3);
        System.out.println(ans);
    }

    public static void main(String[] args) {

        checkBinarySearch();

        // printIntData.arrWithIdx("", arr);


    }
}
