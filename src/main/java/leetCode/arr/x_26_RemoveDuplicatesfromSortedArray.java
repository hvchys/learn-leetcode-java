package leetCode.arr;

public class x_26_RemoveDuplicatesfromSortedArray {
    /*

    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:
    输入: nums = [1,1,2]
    输出: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
         It doesn't matter what you leave beyond the returned length.

    Example 2:
    输入: nums = [0,0,1,1,1,2,2,3,3,4],
    输出: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
         It doesn't matter what values are set beyond the returned length.
     */

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return len;
        }

        int count = 1;
        int idx = 1;
        int preVal = nums[0], curVal;
        // nums[0] 肯定被保留了
        while(idx < len){
            curVal = nums[idx];
            if(curVal > preVal){
                // 是新的值
                nums[count] = curVal;
                count++;
                preVal = curVal;
            }
            // 不是新的值，跳过去
            idx++;
        }
        return count;
    }

}
