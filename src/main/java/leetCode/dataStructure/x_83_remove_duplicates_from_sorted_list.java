package leetCode.dataStructure;

public class x_83_remove_duplicates_from_sorted_list {
    /*
    Input: 1->1->2
    Output: 1->2

    Runtime: 1 ms, faster than 34.67% of Java online submissions for Remove Duplicates from Sorted List.
    Memory Usage: 36.2 MB, less than 99.83% of Java online submissions for Remove Duplicates from Sorted List.

     */

    public ListNode deleteDuplicates(ListNode head) {
        int ansNum = 0;
        ListNode ans = new ListNode(-1), curNode = ans, preNode = new ListNode(-1);
        // 检查 head 最前面的值 X 是不是重复的，如果是，就返回 X 之后的内容
        // 如果不是，更新 curNode
        while (head != null){
            // 更新答案
            curNode.val = head.val;
            curNode.next = new ListNode(-1);
            preNode = curNode;
            curNode = curNode.next;
            ansNum++;

            // 更新 head
            head = getNext(head);
        }
        if(ansNum == 0){
            return null;
        }else{
            preNode.next = null;
            return ans;
        }
    }

    public ListNode getNext(ListNode n){
        // 返回第一个 取值 和 n的top 不一样 的点
        int topVal = n.val;
        n = n.next;
        while (true){
            if(n == null){
                return null;
            }
            // curVal = n.val;
            if(topVal != n.val){
                return n;
            }else{
                n = n.next;
            }
        }
    }


}
