package leetCode.numeric;

import java.util.Arrays;
import java.util.Comparator;

class Solution implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        String as = String.valueOf(a);
        String bs = String.valueOf(b);
        return (as + bs).compareTo(bs + as);
    }

    private static Integer[] toIntegerArray(int[] arr) {
        int n = arr.length;
        Integer[] iarr = new Integer[n];
        for (int i = 0; i < n; i++) {
            iarr[i] = arr[i];
        }
        return iarr;
    }

    public String largestNumber(int[] nums) {
        Integer[] numIs = toIntegerArray(nums);
        Arrays.sort(numIs, new Solution());
        if (numIs[numIs.length - 1] == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int i = numIs.length - 1; i >= 0; i--) {
            result.append(numIs[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] num = {36, 361, 3634, 35, 3};
        System.out.println(new Solution().largestNumber(num));
    }

    /*
    {32, 321, 3234, 25, 3};
    332343232125

    {32, 321, 3234, 35, 3};
    353323432321

    {36, 361, 3634, 35, 3};
    363634361353

     */

}
