package leetCode.arr.merge;

import java.util.ArrayList;
import java.util.List;

public class x_88_merge_sorted_array {
    /*
    输入: nums1, nums2 已经排好序了
         两者元素个数分别为: m, n
    目标: 把 nums2 merge到 nums1 里面，得到: one sorted array.

    注: 假设 nums1 的空间足够大

    例:
    输入:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    输出:
    [1,2,2,3,5,6]

    Runtime: 1 ms, faster than 53.82% of Java online submissions for Merge Sorted Array.
    Memory Usage: 35.3 MB, less than 99.59% of Java online submissions for Merge Sorted Array.

     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list1 = arrToList(nums1, m);
        List<Integer> list2 = arrToList(nums2, n);

        Util.printListIntData.print("list1", list1);
        Util.printListIntData.print("list2", list2);

        mergePart(list1, m, 0, list2, n, 0);

        System.out.println("--------------------------------------");
        Util.printListIntData.print("list1", list1);
        Util.printListIntData.print("list2", list2);

        addListToArr(nums1, list1, m+n);
    }

    public static void mergePart(List<Integer> list1, int m, int idx1, List<Integer> list2, int n, int idx2){

        System.out.println("\n-------------------------------------");
        Util.printListIntData.print("list1", list1);
        Util.printListIntData.print("list2", list2);
        System.out.println("m: " + m + ", idx1: " + idx1 + ", n: " + n + ", idx2: " + idx2);

        if(idx2 == n)
            return ;
        else if(idx1 == m){
            int curIdx1 = idx1;
            for(int i = idx2; i < n; i++){
                list1.add(curIdx1, list2.get(i));
                curIdx1++;
            }
            return ;
        }
//        if(idx1 == m && idx2 == n)
//            return ;
//        else if(idx1 == m && idx2 < n){
//            // list1 没了，list2 还有 剩余
//            System.arraycopy(list2, idx2, list1, idx1, n-idx2+1);
//        }else if(idx1 < m && idx2 == n){
//            // list1 还有剩余，list2 没了
//            return;
//        }

        if(list1.get(idx1) < list2.get(idx2)){
            mergePart(list1, m, idx1+1, list2, n, idx2);
        }else{
            list1.add(idx1, list2.get(idx2));
            list2.remove(idx2);
            mergePart(list1, m+1, idx1+1, list2, n-1, idx2);
        }
    }

    public static List<Integer> arrToList(int[] arr, int eleNum){
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < eleNum; i++){
            ans.add(arr[i]);
        }
        return ans;
    }

    public static void addListToArr(int[] arr, List<Integer> list, int eleNum){
        for(int i = 0; i < eleNum; i++){
            arr[i] = list.get(i);
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);

        Util.printIntData.ver1arr("ans", nums1);
    }


}
