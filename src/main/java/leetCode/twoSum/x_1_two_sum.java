package leetCode.twoSum;

import java.util.HashMap;

public class x_1_two_sum {
    /*
    是 第一道题
    这道题本身不难，但是感觉 变体会很难:

    在做 3sum 这道题的时候遇到问题:
    一种变体: 数组里面有重复元素，并且有多个解，要求答案不能有重复的

     */

    /*

    给定 int 的 array, 某个 target
    返回俩 idx: i,j , 使得 arr[i]+arr[j] = target

    假设:
    1 每个输入，只有一个解
    2 不能把同一个元素 用 两遍

    例:
    Given nums = [2, 7, 11, 15], target = 9,
    return [0, 1].
     */


    /*
    Runtime: 2 ms, faster than 99.50% of Java online submissions for Two Sum.
    Memory Usage: 38.3 MB, less than 63.08% of Java online submissions for Two Sum.

     */
    public static int[] twoSum_v1(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                return new int[]{left, i};
            }else{
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

    /*
    Runtime: 2 ms, faster than 99.50% of Java online submissions for Two Sum.
    Memory Usage: 38.2 MB, less than 67.03% of Java online submissions for Two Sum.
     */
    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer,Integer> hash = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            Integer diff = (Integer)(target - numbers[i]);
            if(hash.containsKey(diff)){
                return new int[]{hash.get(diff), i};
            }
            hash.put(numbers[i], i);
        }
        return null;
    }

}
