package leetCode.dataStructure;

public class x_83_v3 {
    /*
    新思路: 不要再搞新的数列了，直接从原来的数据里面 删除 重复的内容

     */

    public ListNode deleteDuplicates(ListNode head) {
        int curVal;
        ListNode curNode = head, nextNode;
        while(curNode != null){
            curVal = curNode.val;
            nextNode = curNode.next;

            while(nextNode != null && nextNode.val == curVal){
                nextNode = nextNode.next;
            }
            // 这里，两种可能: 1. nextNode==null; 2. nextNode是新的值
            curNode.next = nextNode;
            curNode = curNode.next;
        }
        return head;
    }


}
