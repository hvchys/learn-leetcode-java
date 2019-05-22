package leetCode.arr.merge.x_23_merge_k_sorted_list;

import leetCode.arr.merge.ListNode;

import java.util.HashSet;
import java.util.Set;

public class x_23_v3_set {
    /*
    用 Set<ListNode> 存储 还没有被读取的 数据
    输出结果的时候，给结果一个 没有用的 表头，简化写数据过程

    【没啥用】

    Runtime: 595 ms, faster than 5.05% of Java online submissions for Merge k Sorted Lists.
    Memory Usage: 58.6 MB, less than 5.01% of Java online submissions for Merge k Sorted Lists.

     */

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null||lists.length == 0) return null;

        ListNode ans = new ListNode(0);
        ListNode ansCurNode = ans;
        Set<ListNode> pointers = getPointers(lists);
        int min;
        ListNode selP = null;
        ListNode selPNext;
        while(pointers.size() > 0){
            min = Integer.MAX_VALUE;
            for(ListNode p: pointers){
                if(p.val < min){
                    min = p.val;
                    selP = p;
                }
            }
            // 有 最小值
            // 1. 把值 加到 结果 里面
            ansCurNode.next = new ListNode(min);
            ansCurNode = ansCurNode.next;
            // 2. 把这个最小值，对应的 pointer 改一下
            pointers.remove(selP);
            selPNext = selP.next;
            if(selPNext != null){
                pointers.add(selPNext);
            }
        }
        return ans.next;
    }

    public static Set<ListNode> getPointers(ListNode[] lists){
        Set<ListNode> pointers = new HashSet<>();
        for(ListNode node: lists){
            if(node != null){
                pointers.add(node);
            }
        }
        return pointers;
    }

    public static void main(String[] args){
        ListNode[] list = ListNode.getTextInput();
        ListNode.printXXX("before", list);

        ListNode ans = mergeKLists(list);
        System.out.println("ans: " + ans);

        ListNode.printXXX("after", list);
    }


}
