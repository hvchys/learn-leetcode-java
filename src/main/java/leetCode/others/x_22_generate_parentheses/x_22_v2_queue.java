package leetCode.others.x_22_generate_parentheses;

import java.util.*;

public class x_22_v2_queue {

    /*
    用队列: 更慢了
    Runtime: 3 ms, faster than 14.56% of Java online submissions for Generate Parentheses.
    Memory Usage: 35.7 MB, less than 99.96% of Java online submissions for Generate Parentheses.
     */

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }

        // n >= 1:
        Prefix pre_0 = new Prefix("(", 1, 0, 1);
        Queue<Prefix> queue = new LinkedList<Prefix>();
        queue.add(pre_0);

        int xxLen = 2*n;
        Prefix prefix;
        while(true){
            prefix = queue.peek();
            if(prefix.len == xxLen){ // 都是最终答案了，再没可以操作的前缀了
                break;
            }else{
                queue.poll();
                if(prefix.canAddLeft(n)){
                    queue.add(prefix.getNewAddLeft());
                }
                if(prefix.canAddRight()){
                    queue.add(prefix.getNewAddRight());
                }
            }
        }
        for(Prefix pre: queue){
            ans.add(pre.curPre);
        }
        return ans;
    }

}

class Prefix{
    String curPre;
    int x1_num; // "("
    int x2_num; // ")"
    int len;

    /*
    一个 左括号: (1,0)
     */

    Prefix(String curPre, int x1_num, int x2_num, int len){
        this.curPre = curPre;
        this.x1_num = x1_num;
        this.x2_num = x2_num;
        this.len = len;
    }

    Prefix getNewAddLeft(){
        return new Prefix(this.curPre + "(", this.x1_num + 1, this.x2_num, len+1);
    }

    Prefix getNewAddRight(){
        return new Prefix(this.curPre + ")", this.x1_num, this.x2_num + 1, len+1);
    }

    boolean canAddLeft(int n){
        return this.x1_num < n;
    }

    boolean canAddRight(){
        return this.x1_num > this.x2_num;
    }

}

