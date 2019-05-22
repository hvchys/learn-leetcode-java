package leetCode.arr.merge.x_23_merge_k_sorted_list;

import leetCode.arr.merge.ListNode;
import java.util.*;

public class x_23_v2_list {

    /*
    用 List<ListNode> 存储 还没有被读取的 数据

    Runtime: 331 ms, faster than 5.05% of Java online submissions.
    Memory Usage: 58.1 MB, less than 5.01% of Java online submissions.

     */

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        ListNode ansCurNode = null;
        List<ListNode> pointers = getPointers(lists);
        int min;
        int selIdx = -1;
        ListNode pointer;
        while(pointers.size() > 0){
            min = Integer.MAX_VALUE;
            for(int i = 0; i < pointers.size(); i++){
                pointer = pointers.get(i);
                if(pointer.val < min){
                    min = pointer.val;
                    selIdx = i;
                }
            }
            if(min != Integer.MAX_VALUE){
                // 有 最小值
                // 1. 把值 加到 结果 里面
                if(ans == null){
                    ans = new ListNode(min);
                    ansCurNode = ans;
                }else{
                    ansCurNode.next = new ListNode(min);
                    ansCurNode = ansCurNode.next;
                }
                // 2. 把这个最小值，对应的 pointer 改一下
                pointer = pointers.remove(selIdx).next;
                // pointers.remove(selIdx);
                if(pointer != null){
                    pointers.add(selIdx, pointer);
                }
            }
        }
        return ans;
    }

    public static List<ListNode> getPointers(ListNode[] lists){
        List<ListNode> pointers = new ArrayList<>();
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
