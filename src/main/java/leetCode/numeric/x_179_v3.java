package leetCode.numeric;

import java.lang.reflect.Array;
import java.util.*;

public class x_179_v3 {

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();

        String[] strArr = getStrArr(nums);
        TreeMap<Integer, PriorityQueue<String>> treeMap = getTreeMap(strArr);
        int curKey;
        PriorityQueue<String> curQueue;
        while(!treeMap.isEmpty()){
            curKey = treeMap.lastEntry().getKey();
            curQueue = treeMap.lastEntry().getValue();

        }
        return sb.toString();
    }

    public static boolean hasMultiMax(Queue<String> q){
        return true;
    }

    public static TreeMap<Integer, PriorityQueue<String>> getTreeMap(String[] strArr){
        TreeMap<Integer, PriorityQueue<String>> map = new TreeMap<>();
        int groupId;
        PriorityQueue<String> p;
        for(String x: strArr){
            groupId = x.charAt(0);
            if(map.containsKey(groupId)){
                p = map.get(groupId);
            }else{
                p = getOneEmptyQueue();
            }
            p.add(x);
            map.put(groupId, p);
        }
        return map;
    }

    public static PriorityQueue<String> getOneEmptyQueue(){
        return new PriorityQueue<String>(
                new Comparator<String>() {
                    @Override
                    public int compare(String x, String y) {
                        int idx = 0;
                        int minLen = Math.min(x.length(), y.length());
                        while(idx < minLen){
                            if(x.charAt(idx) > y.charAt(idx)){
                                return 1;
                            }else if(x.charAt(idx) < y.charAt(idx)){
                                return -1;
                            }
                            idx++;
                        }
                        return 0;
                    }
                });
    }

    public static String[] getStrArr(int[] arr){
        String[] ans = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            ans[i] = Integer.toString(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args){

    }

}
