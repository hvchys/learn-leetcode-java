package leetCode.dataStructure;

public class x_19_RemoveNthNodeFromEndOfList {
    /*
    给一个 链表: remove the n-th node from the end of list and return its head.

    例:
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.

    注: 认为 n 总是 valid 的

    Follow up:
    Could you do this in one pass? 遍历一次 就 做到 ??
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // System.out.println("n: " + n);
        ListNode[] tempArr = new ListNode[n];

        if(n == 1 && isLastNode(head))
            return null;

        int xxLen = 1;
        int idx = 0;
        ListNode curNode = head;
        while(!isLastNode(curNode)){
            // System.out.println("idx: " + idx + ", val: " + curNode.val);

            tempArr[idx] = curNode;
            curNode = curNode.next;
            idx++;
            idx = idx % n;
            xxLen++;
        }
        // System.out.println("idx: " + idx);
        // System.out.println("isLastNode: " + curNode.val);
        /*
           0 1 234
           0(1)
        */
        // 0(1)234
        //               (idx - (n-1)) % n
        // int delIdx = (idx + 1) % n; 2
        int preIdx = idx;
        // int nextIdx = (idx + 2) % n;

        // System.out.println("preIdx: " + preIdx);
        // System.out.println("nextIdx: " + nextIdx);
        if(tempArr[preIdx] == null){
            // 这种情况 说明 要删掉的是原来的 head
            return head.next;
        }else{
            tempArr[preIdx].next = tempArr[preIdx].next.next;
            return head;
        }
    }



    public boolean isLastNode(ListNode node){
        return node.next == null;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
