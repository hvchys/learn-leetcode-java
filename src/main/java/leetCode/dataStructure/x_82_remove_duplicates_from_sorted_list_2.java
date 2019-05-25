package leetCode.dataStructure;

public class x_82_remove_duplicates_from_sorted_list_2 {
    /*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    Example 1:
    Input: 1->2->3->3->4->4->5
    Output: 1->2->5

    Example 2:
    Input: 1->1->1->2->3
    Output: 2->3

    Runtime: 1 ms, faster than 61.62% of Java online submissions for Remove Duplicates from Sorted List II.
    Memory Usage: 35.6 MB, less than 99.86% of Java online submissions for Remove Duplicates from Sorted List II.

     */

    public ListNode deleteDuplicates(ListNode head) {
        int ansNum = 0;
        ListNode ans = new ListNode(-1), curNode = ans, preNode = new ListNode(-1);
        // 检查 head 最前面的值 X 是不是重复的，如果是，就返回 X 之后的内容
        // 如果不是，更新 curNode
        while (head != null){
            if(topIsDuplicate(head)){
                head = getNext(head);
            }else{
                curNode.val = head.val;
                curNode.next = new ListNode(-1);
                preNode = curNode;
                curNode = curNode.next;
                head = head.next;
                ansNum++;
            }
        }
        if(ansNum == 0){
            return null;
        }else{
            preNode.next = null;
            return ans;
        }
    }

    public boolean topIsDuplicate(ListNode n){
        // 检查 n 最前面的值 X 是不是重复的
        if(n.next == null){
            return false;
        }else if(n.val == n.next.val){
            return true;
        }else{
            return false;
        }
    }

    public ListNode getNext(ListNode n){
        // 返回第一个 取值 和 n的top 不一样 的点
        int topVal = n.val;
        n = n.next;
        int curVal;
        while (true){
            if(n == null){
                break;
            }
            curVal = n.val;
            if(topVal != curVal){
                return n;
            }else{
                n = n.next;
            }
        }
        return null;
    }

}
