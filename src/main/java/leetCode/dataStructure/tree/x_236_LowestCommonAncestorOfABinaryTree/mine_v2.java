package leetCode.dataStructure.tree.x_236_LowestCommonAncestorOfABinaryTree;

import leetCode.dataStructure.tree.TreeNode;

import java.util.*;

public class mine_v2 {

    /*
    遍历tree: 宽度优先，用 map 存储当前层
    遍历的时候，存储当前点的: 用str表示路径

    空间 和 时间 都不行

    Runtime: 50 ms, faster than 6.78% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    Memory Usage: 35.8 MB, less than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == root || q == root){
            return root;
        }

        // 宽度优先遍历，并且存储当前这一层，每个点的路径
        Map<TreeNode, String> curLevel = new HashMap<>();
        curLevel.put(root, "");
        Set<TreeNode> keySet = curLevel.keySet();

        Map<TreeNode, String> nextLevel;
        String path, pathP="", pathQ="";
        boolean notGetP = true, notGetQ = true;

        while(notGetP || notGetQ){
            if(keySet.contains(p)){
                pathP = curLevel.get(p);
                notGetP = false;
            }
            if(keySet.contains(q)){
                pathQ = curLevel.get(q);
                notGetQ = false;
            }
            nextLevel = new HashMap<>();
            for(TreeNode node: keySet){
                path = curLevel.get(node);
                if(node.left != null){
                    nextLevel.put(node.left, path+"l");
                }
                if(node.right != null){
                    nextLevel.put(node.right, path+"r");
                }
            }
            curLevel = nextLevel;
            keySet = curLevel.keySet();
        }

        return fromPQToAns(root, pathP, pathQ);
    }

    public TreeNode fromPQToAns(TreeNode root, String pathP, String pathQ){
        TreeNode node = root;
        int maxLen = Math.min(pathP.length(), pathQ.length());
        for(int i = 0; i < maxLen; i++){
            if(pathP.charAt(i) != pathQ.charAt(i)){
                break;
            }
            if(pathP.charAt(i) == 'l'){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return node;
    }

}
