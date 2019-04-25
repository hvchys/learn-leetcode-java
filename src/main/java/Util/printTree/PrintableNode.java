package Util.printTree;

/** Vertex that can be printed */
public interface PrintableNode {
    /** Get left child */
    PrintableNode getLeft();

    /** Get right child */
    PrintableNode getRight();

    /** Get text to be printed */
    String getText();

    // 需要特殊标记的Node
    boolean getMark();

    int getIdx();

}
