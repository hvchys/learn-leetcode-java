package leetCode.dataStructure;

public class x_25_reverse_nodes_in_k_group {
    /*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    k is a positive integer and is less than or equal to the length of the linked list.
    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    例:
    Given this linked list: 1->2->3->4->5
    For k = 2, you should return: 2->1->4->3->5
    For k = 3, you should return: 3->2->1->4->5


    Note:
    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.
     */

    // !!!!
    // 接下来: 725, 876

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLen(head);
        return reversePart(head, k, len);
    }

    public ListNode reversePart(ListNode head, int k, int curLen) {
        if(curLen < k){
            return head;
        }else{
            // 把 前k个数 顺序改了
//            ListNode topKVal = reverseTopK(head, k);
//            ListNode left = getLeft(head, k);
//            combine(topKVal, reversePart(left, k, curLen-k));
//            return topKVal;
            /*
            step1: 把 topKVal 搞成 reversed 的
            step2: 把 第 k+1 个元素 找到
            step3: 把 step1 和 step3 的结果连接起来
             */

            int idx = 0;
            ListNode left = head;
            int[] topKVal = new int[k];
            while (idx < k){
                topKVal[idx] = left.val;
                left = left.next;
                idx++;
            }
            // 到这里，left: 是第 k+1 个元素
            //       topKVal[]: 记录前k个元素的值
            ListNode topKNodes = new ListNode(topKVal[k-1]);
            ListNode temp = topKNodes;
            for(int i = k-1; i > 0; i--){
                // temp.val = topKVal[i];
                temp.next = new ListNode(topKVal[i-1]);
                temp = temp.next;
            }
            // 此时 temp 是 topK的最后一个元素
            // temp.val = topKVal[0];
            temp.next = reversePart(left, k, curLen-k);
            return topKNodes;
        }
    }

    public int getLen(ListNode n){
        ListNode temp = n;
        int num = 0;
        while (temp != null){
            temp = temp.next;
            num++;
        }
        return num;
    }

//    public ListNode reverseTopK(ListNode head, int k){
//        ListNode[] topList = new ListNode[k];
//
//    }
//
//    public ListNode getLeft(ListNode head, int k){
//        // 返回 第 k+1 个点
//        int idx = 0;
//        ListNode ans = head;
//        while (idx < k){
//            ans = ans.next;
//            idx++;
//        }
//        return ans;
//    }

//    public ListNode combine(ListNode topK, ListNode left){
//        // 把 topK 和 Left 连起来
//
//    }



}
