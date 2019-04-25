package arr;

import dataStructure.B_tree_heap_hash.xx_7_heap.MinHeap_intArr;

public class x_4_MedianOfTwoSortedArrays {

    /*
    There are two sorted arrays nums1 and nums2 of size m and n respectively.
    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    You may assume nums1 and nums2 cannot be both empty.

    Example 1:
    nums1 = [1, 3]
    nums2 = [2]
    答案: 2.0

    Example 2:
    nums1 = [1, 2]
    nums2 = [3, 4]
    答案: (2 + 3)/2 = 2.5
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int allNum = m + n;
        MinHeap_intArr minHeap = new MinHeap_intArr(allNum);
        minHeap.addArrToHeap(nums1);
        minHeap.addArrToHeap(nums2);
        boolean isEven = (allNum % 2 == 0);
        // 考虑 第 order 大的数的结果
        if(isEven){
            // 是 偶数
            int order1 = allNum/2;
            int order2 = order1 + 1;
            return findMedianEven(minHeap, order1, order2);
        }else{
            int order = allNum/2 + 1;
            System.out.println("order: " + order);
            return findMedianOdd(minHeap, order);
        }
    }

    public static double findMedianEven(MinHeap_intArr minHeap, int order1, int order2){
        // 返回 第 order1, order2 大的数据的平均值
        int x = 0;
        int y = 0;
        int curOrder = 0;
        int curVal;
        while(curOrder < order2){
            curVal = minHeap.extractRoot();
            curOrder++;
            if(curOrder == order1)
                x = curVal;
            if(curOrder == order2){
                y = curVal;
                break;
            }
        }
        return (x + y + 0.0)/2;
    }

    public static double findMedianOdd(MinHeap_intArr minHeap, int order){
        // 返回 第 order 大的数据的值
        int ans = 0;
        int curOrder = 0;
        int curVal;
        while(curOrder < order){
            curVal = minHeap.extractRoot();
            System.out.println("curVal: " + curVal);
            curOrder++;
            if(curOrder == order){
                ans = curVal;
                break;
            }
        }
        return ans + 0.0;
    }

    public static void main(String[] args){
        int[] arr1 = {3};
        int[] arr2 = {-1, -2};

        // 0,1 ; 0,1,2 -> 2.5: 2,3
        // 0; 0,1 ->

        double ans = findMedianSortedArrays(arr1, arr2);

        System.out.println(ans);
    }

}

