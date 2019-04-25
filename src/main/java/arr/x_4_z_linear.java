package arr;

public class x_4_z_linear {

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

    // 这个解法是 O(m+n) 的 时间复杂度太高了
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int allNum = m + n;
        boolean isEven = (allNum % 2 == 0);
        // 考虑 第 order 大的数的结果
        if(isEven){
            // 是 偶数
            int order1 = allNum/2;
            int order2 = order1 + 1;
            return findMedianEven(nums1, nums2, order1, order2);
        }else{
            int order = allNum/2 + 1;
            return findMedianOdd(nums1, nums2, order);
        }
    }

    public static double findMedianEven(int[] nums1, int[] nums2, int order1, int order2){
        // 返回 第 order1, order2 大的数据的平均值
        int m = nums1.length;
        int n = nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        int curOrder = 0;
        int curVal;
        int curX = 0;
        int curY = 0;
        while(idx1 < m && idx2 < n){
            if(nums1[idx1] < nums2[idx2]){
                // 当前元素 是 nums1[idx1]
                curVal = nums1[idx1];
                curOrder++;
                idx1++;
            }else{
                // 当前元素 是 nums2[idx2]
                curVal = nums2[idx2];
                curOrder++;
                idx2++;
            }
            // 当前元素是 第 curOrder 个
            if(curOrder == order1)
                curX = curVal;
            if(curOrder == order2){
                curY = curVal;
                return (curX + curY + 0.0)/2;
            }
        }
        // 到这里了，说明，没有走完
        while(idx1 < m){
            curVal = nums1[idx1];
            curOrder++;
            idx1++;
            // 当前元素是 第 curOrder 个
            if(curOrder == order1)
                curX = curVal;
            if(curOrder == order2){
                curY = curVal;
                return (curX + curY + 0.0)/2;
            }
        }
        while(idx2 < n){
            curVal = nums2[idx2];
            curOrder++;
            idx2++;
            // 当前元素是 第 curOrder 个
            if(curOrder == order1)
                curX = curVal;
            if(curOrder == order2){
                curY = curVal;
                return (curX + curY + 0.0)/2;
            }
        }
        return -1.0;
    }

    public static double findMedianOdd(int[] nums1, int[] nums2, int order){
        // 返回 第 order 大的数据的值
        int m = nums1.length;
        int n = nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        int curOrder = 0;
        int curVal;
        double ans = 0;
        while(idx1 < m && idx2 < n){
            if(nums1[idx1] < nums2[idx2]){
                // 当前元素 是 nums1[idx1]
                curVal = nums1[idx1];
                curOrder++;
                idx1++;
            }else{
                // 当前元素 是 nums2[idx2]
                curVal = nums2[idx2];
                curOrder++;
                idx2++;
            }
            // 当前元素是 第 curOrder 个
            if(curOrder == order){
                ans = curVal + 0.0;
                return ans;
            }
        }
        while(idx1 < m){
            curVal = nums1[idx1];
            curOrder++;
            idx1++;
            // 当前元素是 第 curOrder 个
            if(curOrder == order){
                ans = curVal + 0.0;
                return ans;
            }
        }
        while(idx2 < n){
            curVal = nums2[idx2];
            curOrder++;
            idx2++;
            // 当前元素是 第 curOrder 个
            if(curOrder == order){
                ans = curVal + 0.0;
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr1 = {1,2};
        int[] arr2 = {3,4,5};

        double ans = findMedianSortedArrays(arr1, arr2);

        System.out.println(ans);
    }

}
