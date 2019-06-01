package leetCode.dataStructure.tree.x_236_LowestCommonAncestorOfABinaryTree;

import leetCode.dataStructure.tree.TreeNode;

import java.util.*;

public class mine_v1_wrong {

    /*
    遍历tree: 宽度优先，用 map 存储当前层
    遍历的时候，存储当前点的: idx

    会挂:
    如果树很大，idx就超过了 int.max
     */

    public int getLeftChildIdx(int idx){
        return 2*idx+1;
    }

    public int getRightChildIdx(int idx){
        return 2*idx+2;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        // 宽度优先遍历，并且存储每个点
        Map<TreeNode, Integer> curLevel = new HashMap<>();
        curLevel.put(root, 0);
        Set<TreeNode> keySet = curLevel.keySet();

        Map<TreeNode, Integer> nextLevel;
        int idx, idxLeft, idxRight, idxP=0, idxQ=0;
        boolean notGetP = true, notGetQ = true;

        while(notGetP || notGetQ){
            if(keySet.contains(p)){
                idxP = curLevel.get(p);
                notGetP = false;
            }
            if(keySet.contains(q)){
                idxQ = curLevel.get(q);
                notGetQ = false;
            }
            nextLevel = new HashMap<>();
            for(TreeNode node: keySet){
                idx = curLevel.get(node);
                if(node.left != null){
                    idxLeft = getLeftChildIdx(idx);
                    nextLevel.put(node.left, idxLeft);
                }
                if(node.right != null){
                    idxRight = getRightChildIdx(idx);
                    // System.out.println("right: " + idxRight);
                    nextLevel.put(node.right, idxRight);
                }
            }
            curLevel = nextLevel;
            keySet = curLevel.keySet();
        }

        return fromIdxToAns(root, idxP, idxQ);
    }

    public String getPath(int idx){
        /*
        如果是 奇数，就是某个点的左孩子
        如果是 偶数，就是某个点的右孩子

        返回: lrlrlr... 从起点到这个点，的路径
         */
        List<String> path = new ArrayList<>();
        int curIdx = idx;
        while (curIdx > 0){
            if(curIdx % 2 == 1){
                // 是 左孩子
                path.add("l");
            }else{
                // 是 右孩子
                path.add("r");
            }
            curIdx = (curIdx-1)/2;
        }
        StringBuilder sb = new StringBuilder();
        int len = path.size();
        for(int i = len-1; i >= 0; i--){
            sb.append(path.get(i));
        }
        return sb.toString();
    }

    public TreeNode fromIdxToAns(TreeNode root, int idxP, int idxQ){
        String pathP = getPath(idxP);
        String pathQ = getPath(idxQ);
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
