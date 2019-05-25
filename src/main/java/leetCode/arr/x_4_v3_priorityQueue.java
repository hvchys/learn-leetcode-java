package leetCode.arr;

import java.util.PriorityQueue;

public class x_4_v3_priorityQueue {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int allNum = m + n;
        PriorityQueue<Integer> pq = getQueue(nums1, nums2);

        boolean isEven = (allNum % 2 == 0);
        // 考虑 第 order 大的数的结果
        if(isEven){
            // 是 偶数
            int order1 = allNum/2;
            int order2 = order1 + 1;
            return findMedianEven(pq, order1, order2);
        }else{
            int order = allNum/2 + 1;
            System.out.println("order: " + order);
            return findMedianOdd(pq, order);
        }
    }

    public static PriorityQueue<Integer> getQueue(int[] arr1, int[] arr2){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: arr1){
            pq.add(x);
        }
        for(int x: arr2){
            pq.add(x);
        }
        return pq;
    }

    public static double findMedianEven(PriorityQueue<Integer> q, int order1, int order2){
        // 返回 第 order1, order2 大的数据的平均值
        int x = 0;
        int y = 0;
        int curOrder = 0;
        int curVal;
        while(curOrder < order2){
            curVal = q.poll();
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

    public static double findMedianOdd(PriorityQueue<Integer> q, int order){
        // 返回 第 order 大的数据的值
        int ans = 0;
        int curOrder = 0;
        int curVal;
        while(curOrder < order){
            curVal = q.poll();
            // System.out.println("curVal: " + curVal);
            curOrder++;
            if(curOrder == order){
                ans = curVal;
                break;
            }
        }
        return ans + 0.0;
    }

    public static void main(String[] args){
        int[] arr1 = {4, 5, 6};
        int[] arr2 = {1, 2, 3};

        // 0,1 ; 0,1,2 -> 2.5: 2,3
        // 0; 0,1 ->

        double ans = findMedianSortedArrays(arr1, arr2);

        System.out.println(ans);
    }

}

