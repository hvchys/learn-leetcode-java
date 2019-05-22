package leetCode.arr.merge.x_23_merge_k_sorted_list;

import leetCode.arr.merge.ListNode;

import java.util.ArrayList;
import java.util.List;

public class x_23_v1 {
    /*

    Merge k sorted linked lists and return it as one sorted list.
    Analyze and describe its complexity.

    Input:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    Output: 1->1->2->3->4->4->5->6
     */

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        ListNode ansCurNode = null;
        List<ListNode> pointers = getPointers(lists);
        List<Integer> validPointerIdxs;
        int selIdx;
        int curVal;
        while(true){
            validPointerIdxs = getValidPointers(pointers);
            if(validPointerIdxs.isEmpty()){
                break;
            }
            // 还有 Node 没有被加进去
            if(validPointerIdxs.size() == 1){
                // 只有一个 list 还有 Node
                ListNode oneList = pointers.get(validPointerIdxs.get(0));
                // 把 Node 加到 结果里面
                ans = addOneList(ans, ansCurNode, oneList);
                return ans;
            }else{
                // 还有 >=2 个 list
                selIdx = getSmallestIdx(validPointerIdxs, pointers);
                // 1. 找出来当前最小值
                curVal = pointers.get(selIdx).val;
                // 2. 把这个最小值，对应的 arr 改一下
                changePointers(pointers, selIdx);
                // 3. 把值 加到 结果 里面
                if(ans == null){
                    ans = new ListNode(curVal);
                    ansCurNode = ans;
                }else{
                    ansCurNode.next = new ListNode(curVal);
                    ansCurNode = ansCurNode.next;
                }
            }
        }
        return ans;
    }

    public static List<ListNode> getPointers(ListNode[] lists){
        List<ListNode> pointers = new ArrayList<>();
        for(ListNode node: lists){
            pointers.add(node);
        }
        return pointers;
    }

    public static void changePointers(List<ListNode> pointers, int selIdx){
        ListNode pointer = pointers.get(selIdx);
        pointer = pointer.next;
        pointers.remove(selIdx);
        pointers.add(selIdx, pointer);
    }

    public static int getSmallestIdx(List<Integer> validPointerIdxs, List<ListNode> pointers){
        int min = Integer.MAX_VALUE;
        int idx = -1;
        ListNode pointer;
        for(int i: validPointerIdxs){
            pointer = pointers.get(i);
            if(pointer.val < min){
                min = pointer.val;
                idx = i;
            }
        }
        return idx;
    }

    public static ListNode addOneList(ListNode ans, ListNode ansCurNode, ListNode oneList){
        // 把 oneList 里面的东西，加到 ans 里面
        // 返回 ans
        if(ans == null){
            return oneList;
        }else{
            while(oneList != null){
                ansCurNode.next = new ListNode(oneList.val);
                ansCurNode = ansCurNode.next;
                oneList = oneList.next;
            }
            return ans;
        }
    }

    public static List<Integer> getValidPointers(List<ListNode> pointers){
        List<Integer> selPointersIdx = new ArrayList<>();
        ListNode pointer;
        for(int i = 0; i < pointers.size(); i++){
            pointer = pointers.get(i);
            if(pointer != null){
                selPointersIdx.add(i);
            }
        }
        return selPointersIdx;
    }

    public static void main(String[] args){
        ListNode[] list = ListNode.getTextInput();
        ListNode.printXXX("start", list);

        ListNode ans = mergeKLists(list);
        System.out.println("ans: " + ans);
    }


}
