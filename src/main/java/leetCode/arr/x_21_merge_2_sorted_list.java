package leetCode.arr;

public class x_21_merge_2_sorted_list {
    /*
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4

     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode ansNext = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null && cur2 != null){
            if(compareNode(cur1, cur2) >= 0){
                addEleToAns(ans, ansNext, cur1.val);
                cur1 = cur1.next;
            }else{
                addEleToAns(ans, ansNext, cur2.val);
                cur2 = cur2.next;
            }
        }

        if(cur1 != null){
            while(cur1 != null){
                ansNext = new ListNode(cur1.val);
                ansNext = ansNext.next;
                cur1 = cur1.next;
            }
        }else{
            while(cur2 != null){
                ansNext = new ListNode(cur2.val);
                ansNext = ansNext.next;
                cur2 = cur2.next;
            }
        }
        return ans;
    }

    public static void addEleToAns(ListNode ans, ListNode ansNext, int x){
        if(ans == null){
            ans = new ListNode(x);
            ansNext = ans.next;
        }else{
            ansNext = new ListNode(x);
            ansNext = ansNext.next;
        }
    }

    public static int compareNode(ListNode x, ListNode y){
        return x.val - y.val;
    }

    public static void main(String[] args){
        ListNode x = new ListNode(1);
        ListNode y = x.next;

        test(x, y);

        System.out.println(x.val);
        System.out.println(y);
    }

    public static void test(ListNode x, ListNode y){
        x.val = 2;
        y = new ListNode(4);
    }

    public static void xxx(int[] a) {
        a = new int[2];

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

