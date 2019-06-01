package leetCode.dataStructure.tree.x_236_LowestCommonAncestorOfABinaryTree;

import leetCode.dataStructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class mine_v4 {

    /*
    遍历tree: 宽度优先，用 queue存储当前的点
    遍历的时候，存储当前点的: 用str表示路径

     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == root || q == root){
            return root;
        }

        // 宽度优先遍历，并且存储当前这一层，每个点的路径
        Map<TreeNode, String> map = new HashMap<>();
        map.put(root, "");

        String path, pathP="", pathQ="", pathLeft, pathRight;
        boolean notGetP = true, notGetQ = true;
        TreeNode node, nodeLeft, nodeRight;

        while(notGetP || notGetQ){
            node = map.keySet().iterator().next();
            path = map.get(node);
            map.remove(node);
            nodeLeft = node.left;
            nodeRight = node.right;
            if(nodeLeft != null){
                pathLeft = path + "l";
                if(nodeLeft == p){
                    pathP = pathLeft;
                    notGetP = false;
                }else if(nodeLeft == q){
                    pathQ = pathLeft;
                    notGetQ = false;
                }
                map.put(nodeLeft, pathLeft);
            }
            if(nodeRight != null){
                pathRight = path + "r";
                if(nodeRight == p){
                    pathP = pathRight;
                    notGetP = false;
                }else if(nodeRight == q){
                    pathQ = pathRight;
                    notGetQ = false;
                }
                map.put(nodeRight, pathRight);
            }
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
