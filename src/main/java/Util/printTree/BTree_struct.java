package Util.printTree;

import java.util.HashMap;

public class BTree_struct {

    public static HashMap<String, int[]> getStruct(int eleNum){
        HashMap<String, int[]> ans = new HashMap<String, int[]>();
        int[] leftChildArr = new int[eleNum];
        int[] rightChildArr = new int[eleNum];
        int[] parentArr = new int[eleNum];

        int k = 0;
        while(k < eleNum){
            parentArr[k] = -1;
            k++;
        }

        int curLeftChildIdx;
        int curRightChildIdx;
        int i = 0;
        while(i < eleNum){
            curLeftChildIdx = 2*i+1;
            curRightChildIdx = 2*i+2;
            if(curRightChildIdx < eleNum){
                parentArr[curRightChildIdx] = i;
                rightChildArr[i] = curRightChildIdx;
            }else{
                rightChildArr[i] = -1;
            }

            if(curLeftChildIdx < eleNum){
                parentArr[curLeftChildIdx] = i;
                leftChildArr[i] = curLeftChildIdx;
            }else{
                leftChildArr[i] = -1;
            }
            i++;
        }

        ans.put("left", leftChildArr);
        ans.put("right", rightChildArr);
        ans.put("parent", parentArr);
        return ans;
    }

    public static Node<Integer> arrToTree(int[] arr, int[] markIdx){
        // 返回的是 root
        int eleNum = arr.length;
        HashMap<String, int[]> arrStructArr = BTree_struct.getStruct(eleNum);
        int[] leftChildArr = arrStructArr.get("left");
        int[] rightChildArr = arrStructArr.get("right");
        int i = 0;
        HashMap<String, Node<Integer>> tree = new HashMap<String, Node<Integer>>();
        while(i < eleNum){
            String curNName = Integer.toString(i);
            Node<Integer> curN = new Node<Integer>(arr[i], i);
            tree.put(curNName, curN);
            i++;
        }
        // 加上 mark
        for(int idx: markIdx){
            Node<Integer> curN = new Node<Integer>(arr[idx], true, idx);
            tree.put(Integer.toString(idx), curN);
        }

        //
        i = 0;
        while(i < eleNum){
            String curNName = Integer.toString(i);
            if(leftChildArr[i] != -1){
                tree.get(curNName).left = tree.get(Integer.toString(leftChildArr[i]));
            }
            if(rightChildArr[i] != -1){
                tree.get(curNName).right = tree.get(Integer.toString(rightChildArr[i]));
            }
            i++;
        }
        return tree.get("0");
    }
}

