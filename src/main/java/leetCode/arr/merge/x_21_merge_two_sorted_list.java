package leetCode.arr.merge;

public class x_21_merge_two_sorted_list {
    /*
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4

     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode ansCurNode = null;
        int curNodeVal;
        while(l1 != null && l2 != null){
            if(compareNode(l1, l2)){
                curNodeVal = l2.val;
                l2 = l2.next;

                // 把当前值 写到结果里面
                if(ans == null){
                    ans = new ListNode(curNodeVal);
                    ansCurNode = ans;
                }else{
                    ansCurNode.next = new ListNode(curNodeVal);
                    ansCurNode = ansCurNode.next;
                }

            }else{
                curNodeVal = l1.val;
                l1 = l1.next;

                // 把当前值 写到结果里面
                if(ans == null){
                    ans = new ListNode(curNodeVal);
                    ansCurNode = ans;
                }else{
                    ansCurNode.next = new ListNode(curNodeVal);
                    ansCurNode = ansCurNode.next;
                }
            }
        }

        if(l1 != null){
            while(l1 != null){
                curNodeVal = l1.val;
                l1 = l1.next;

                // 把当前值 写到结果里面
                if(ans == null){
                    ans = new ListNode(curNodeVal);
                    ansCurNode = ans;
                }else{
                    ansCurNode.next = new ListNode(curNodeVal);
                    ansCurNode = ansCurNode.next;
                }
            }
        }
        if(l2 != null){
            while(l2 != null){
                curNodeVal = l2.val;
                l2 = l2.next;

                // 把当前值 写到结果里面
                if(ans == null){
                    ans = new ListNode(curNodeVal);
                    ansCurNode = ans;
                }else{
                    ansCurNode.next = new ListNode(curNodeVal);
                    ansCurNode = ansCurNode.next;
                }
            }
        }
        return ans;
    }

    public static boolean compareNode(ListNode x, ListNode y){
        return x.val > y.val;
    }

    public static void main(String[] args){
        ListNode l1 = getL1();
        ListNode l2 = getL2();

        ListNode ans = mergeTwoLists(l1, l2);
        printNodeList("\n\n答案", ans);

    }

    public static void printNodeList(String info, ListNode x) {
        StringBuilder sb = new StringBuilder();
        ListNode curL1 = x;
        while(curL1 != null){
            sb.append(curL1.val + " ");
            curL1 = curL1.next;
        }
        System.out.println(info + ": " + sb.toString());
    }

    public static ListNode getL1(){
        ListNode x = new ListNode(1);
        x.next = new ListNode(3);
        x.next.next = new ListNode(4);
        return x;
    }

    public static ListNode getL2(){
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(4);
        return x;
    }

}

