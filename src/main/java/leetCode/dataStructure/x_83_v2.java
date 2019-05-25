package leetCode.dataStructure;

public class x_83_v2 {
    /*
    Input: 1->1->2
    Output: 1->2

    Runtime: 1 ms, faster than 34.67% of Java online submissions for Remove Duplicates from Sorted List.
    Memory Usage: 36.2 MB, less than 99.83% of Java online submissions for Remove Duplicates from Sorted List.

     */

    public ListNode deleteDuplicates(ListNode head) {
        int curVal, ansNum = 0;
        ListNode ans = new ListNode(-1), curNode = ans, preNode = new ListNode(-1);
        while(head != null){
            curVal = head.val;
            curNode.val = curVal;
            curNode.next = new ListNode(-1);
            preNode = curNode;
            curNode = curNode.next;
            ansNum++;

            head = head.next;

            if(head != null && head.val == curVal){
                // 找到下一个 取值 和 head 不一样 的值
                while (head.val == curVal){
                    head = head.next;
                    if(head == null){
                        break;
                    }
                }
            }
        }
        if(ansNum == 0){
            return null;
        }else{
            preNode.next = null;
            return ans;
        }
    }


}
