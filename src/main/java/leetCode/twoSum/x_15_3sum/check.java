package leetCode.twoSum.x_15_3sum;

import java.util.List;

public class check {

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

    public static void main(String[] args){
        int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> ans = x_15_3sum_v2.threeSum(arr);

        printAns(ans);
    }
}
