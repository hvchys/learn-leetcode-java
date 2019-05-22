package leetCode.arr.merge.x_23_merge_k_sorted_list;

import leetCode.arr.merge.ListNode;

import java.util.*;

public class x_23_v5_priority_queue {
    /*

    Runtime: 6 ms, faster than 68.32% of Java online submissions for Merge k Sorted Lists.
    Memory Usage: 41.7 MB, less than 21.76% of Java online submissions for Merge k Sorted Lists.

     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null||lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return Integer.compare(o1.val, o2.val);
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node: lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }


    public static void main(String[] args){
        ListNode[] list = ListNode.getTextInput();
        ListNode.printXXX("before", list);

        ListNode ans = mergeKLists(list);
        System.out.println("ans: " + ans);

        ListNode.printXXX("after", list);
    }


}
