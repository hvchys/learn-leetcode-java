package leetCode.dataStructure;

public class x_24_swap_nodes_in_pairs {
    /*
    Given a linked list, swap every two adjacent nodes and return its head.
    You may not modify the values in the list's nodes, only nodes itself may be changed.

    例:
    Given 1->2->3->4, you should return the list as 2->1->4->3.
     */


    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }else{
            // 至少前俩是有东西的
            ListNode ans = new ListNode(head.next.val);
            ans.next = new ListNode(head.val);
            ans.next.next = swapPairs(head.next.next);
            return ans;
        }
    }


}
