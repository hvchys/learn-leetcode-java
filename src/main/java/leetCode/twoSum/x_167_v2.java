package leetCode.twoSum;

import Util.printIntData;

public class x_167_v2 {

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) r--;
            else l++;
        }
        return new int[]{l + 1, r + 1};
    }

    public static void main(String[] args){

        int[] arr = {2,7,11,15};
        int target = 9;
        printIntData.ver1arr("", twoSum(arr, target));
    }

}
