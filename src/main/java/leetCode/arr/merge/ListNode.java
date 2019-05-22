package leetCode.arr.merge;

import java.util.List;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode pointer = this;
        while(pointer != null){
            sb.append(pointer.val).append(" ");
            pointer = pointer.next;
        }
        return sb.toString();
    }

    // ----------------------------------------------------------------------------------
    // 【打印】
    public static void printXXX(String info, ListNode[] list){
        StringBuilder sb = new StringBuilder();
        for(ListNode node: list){
            sb.append(node).append("\n");
        }
        System.out.println(info + ": \n" + sb.toString());
    }

    public static void printXXX(String info, Set<ListNode> set){
        StringBuilder sb = new StringBuilder();
        for(ListNode node: set){
            sb.append(node).append("\n");
        }
        System.out.println(info + ": \n" + sb.toString());
    }

    public static void printXXX(String info, List<ListNode> list){
        StringBuilder sb = new StringBuilder();
        for(ListNode node: list){
            sb.append(node).append("\n");
        }
        System.out.println(info + ": \n" + sb.toString());
    }

    // ----------------------------------------------------------------------------------
    // 【例子】
    public static ListNode[] getTextInput(){
        ListNode[] ans = new ListNode[3];
        ans[0] = getArr0();
        ans[1] = getArr1();
        ans[2] = getArr2();
        return ans;
    }

    public static ListNode getArr0(){
        ListNode n = new ListNode(1);
        n.next = new ListNode(4);
        n.next.next = new ListNode(5);
        return n;
    }

    public static ListNode getArr1(){
        ListNode n = new ListNode(1);
        n.next = new ListNode(3);
        n.next.next = new ListNode(4);
        return n;
    }

    public static ListNode getArr2(){
        ListNode n = new ListNode(2);
        n.next = new ListNode(6);
        return n;
    }

}