package leetCode.dataStructure.tree.x_236_LowestCommonAncestorOfABinaryTree;

import leetCode.dataStructure.tree.TreeNode;

public class ans {

    /*
    Runtime: 6 ms, faster than 51.90% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    Memory Usage: 34.4 MB, less than 13.96% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     */

    public TreeNode ans_v1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = ans_v1(root.left, p, q);
        TreeNode right = ans_v1(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    /*
    Runtime: 5 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    Memory Usage: 34.1 MB, less than 45.90% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

}
