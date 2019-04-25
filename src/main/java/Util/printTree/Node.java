package Util.printTree;

public class Node<A extends Comparable> implements PrintableNode {
    Node<A> left, right;
    public A data;
    public Boolean mark = false;
    public int idx;

    public Node(A data){
        this.data = data;
    }

    public Node(A data, int idx){
        this.data = data;
        this.idx = idx;
    }

    public Node(A data, boolean mark, int idx){
        this.data = data;
        this.mark = mark;
        this.idx = idx;
    }

    @Override
    public int getIdx() {
        return this.idx;
    }

    @Override
    public String getText() {
        return "(" + Integer.toString(this.idx) + ")" + this.data;
    }

    @Override
    public PrintableNode getLeft() {
        return this.left;
    }

    @Override
    public PrintableNode getRight() {
        return this.right;
    }

    @Override
    public boolean getMark() {
        return this.mark;
    }

}
