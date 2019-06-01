package leetCode.dataStructure.tree.x_236_LowestCommonAncestorOfABinaryTree;

import leetCode.dataStructure.tree.TreeNode;

import java.util.*;

public class mine_v3 {

    /*
    遍历tree: 宽度优先，用 map 存储当前层
    遍历的时候，存储当前点的: 用 list<Integer> 表示路径上每个点的 idx, 计算idx的时候: 把是null的点空过去了

    空间 和 时间 都不行

    Runtime: 90 ms, faster than 6.16% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    Memory Usage: 36.9 MB, less than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == root || q == root){
            return root;
        }

        // 宽度优先遍历，并且存储当前这一层
        // map: key: 当前点x; val: 从root到x的各个点的idx
        Map<TreeNode, List<Integer>> curLevel = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        curLevel.put(root, list);
        Set<TreeNode> keySet = curLevel.keySet();

        Map<TreeNode, List<Integer>> nextLevel;
        boolean notGetP = true, notGetQ = true;
        int idx = 0;
        List<Integer> listP = new ArrayList<>(), listQ = new ArrayList<>();
        while(notGetP || notGetQ){
            if(keySet.contains(p)){
                listP = curLevel.get(p);
                notGetP = false;
            }
            if(keySet.contains(q)){
                listQ = curLevel.get(q);
                notGetQ = false;
            }
            nextLevel = new HashMap<>();
            for(TreeNode node: keySet){
                list = curLevel.get(node);
                if(node.left != null){
                    idx++;
                    addNextLevel(nextLevel, list, node.left, idx);
                }
                if(node.right != null){
                    idx++;
                    addNextLevel(nextLevel, list, node.right, idx);
                }
            }
            curLevel = nextLevel;
            keySet = curLevel.keySet();
        }

        int fatherIdx = getAnsIdx(listP, listQ);
        return getNode_v2(root, fatherIdx);
    }

    public TreeNode getNode_v2(TreeNode root, int curIdx){
        if(curIdx == 0){
            return root;
        }

        if(curIdx == -1){
            return null;
        }

        Map<TreeNode, Integer> curLevel = new HashMap<>();
        curLevel.put(root, 0);
        Set<TreeNode> keySet = curLevel.keySet();

        Map<TreeNode, Integer> nextLevel;
        int idx = 0;
        while(true){
            nextLevel = new HashMap<>();
            for(TreeNode node: keySet){
                if(node.left != null){
                    idx++;
                    if(idx == curIdx){
                        return node.left;
                    }
                    nextLevel.put(node.left, idx);
                }
                if(node.right != null){
                    idx++;
                    if(idx == curIdx){
                        return node.right;
                    }
                    nextLevel.put(node.right, idx);
                }
            }
            curLevel = nextLevel;
            keySet = curLevel.keySet();
        }
    }

    public void addNextLevel(Map<TreeNode, List<Integer>> nextLevel, List<Integer> list, TreeNode node, int idx){
        List<Integer> nextList = new ArrayList<>(list);
        nextList.add(idx);
        nextLevel.put(node, nextList);
    }

    public int getAnsIdx(List<Integer> listP, List<Integer> listQ){
        int maxLen = Math.min(listP.size(), listQ.size());
        int idx = -1, idxP, idxQ;
        for(int i = 0; i < maxLen; i++){
            idxP = listP.get(i);
            idxQ = listQ.get(i);
            if(idxP != idxQ){
                break;
            }else{
                idx = idxP;
            }
        }
        return idx;
    }



//
//    // 不对
//    public TreeNode getNode(TreeNode root, int idx){
//        if(idx == -1){
//            return null;
//        }
//        List<TreeNode> curLevel = new ArrayList<>();
//        curLevel.add(root);
//
//        List<TreeNode> nextLevel;
//        int curIdx = 0;
//        TreeNode node;
//        while(true){
//            nextLevel = new ArrayList<>();
//            while(!curLevel.isEmpty()){
//                node = curLevel.remove(0);
//                if(node.left != null){
//                    curIdx++;
//                    if(curIdx == idx){
//                        return node.left;
//                    }
//                    nextLevel.add(node.left);
//                }
//                if(node.right != null){
//                    curIdx++;
//                    if(curIdx == idx){
//                        return node.right;
//                    }
//                    nextLevel.add(node.right);
//                }
//            }
//            curLevel = nextLevel;
//        }
//    }
}





