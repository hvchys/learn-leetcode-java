package leetCode.others.x_22_generate_parentheses;

public class x_22_generate_parentheses {

    /*
    输入: n
    输出: n对 括号的 各种可能的排列: all combinations of well-formed parentheses.

    例:
    输入: n = 3
    输出:
    [
      "((()))",
      "(()())",
      "(())()",

      "()(())",
      "()()()"
    ]

    n=2:
    "()()"
    "(())"

    n=1: "()"

    省空间，但是很慢
    Runtime: 2 ms, faster than 21.73% of Java online submissions for Generate Parentheses.
    Memory Usage: 35.3 MB, less than 99.96% of Java online submissions for Generate Parentheses.

     */

//    public List<String> generateParenthesis(int n) {
//        /*
//        x1: 左括号; x2: 右括号
//        合理的序列 str:
//        1 它的前 i 个元素，这里面的 x1_num >= x2_num
//        2 总共: x1_num == x2_num
//         */
//        List<String> ans = new ArrayList<>();
//        if(n == 0){
//            return ans;
//        }
//
//        // n >= 1:
//        Prefix pre_0 = new Prefix("(", 1, 0);
//        int curLen = 1;
//        List<Prefix> list = new ArrayList<>();
//        list.add(pre_0);
//        List<Prefix> list_2;
//        int xxLen = 2*n;
//        while (curLen < xxLen){
//            // 把 所有 长度为 curLen 的 Prefix, 变成 长度为 curLen+1 的
//            list_2 = new ArrayList<>();
//            for(Prefix pre: list){
//                if(pre.canAddLeft(n)){
//                    list_2.add(pre.getNewAddLeft());
//                }
//                if(pre.canAddRight()){
//                    list_2.add(pre.getNewAddRight());
//                }
//            }
//            list = list_2;
//            curLen++;
//        }
//        for(Prefix pre: list){
//            ans.add(pre.curPre);
//        }
//        return ans;
//    }

}
//
//class Prefix{
//    String curPre;
//    int x1_num; // "("
//    int x2_num; // ")"
//
//    /*
//    一个 左括号: (1,0)
//     */
//
//    Prefix(String curPre, int x1_num, int x2_num){
//        this.curPre = curPre;
//        this.x1_num = x1_num;
//        this.x2_num = x2_num;
//    }
//
//    /*
//    当前肯定: x1_num >= x2_num, x1_num <= n, x2_num <= n
//    可以加左括号: x1_num+1 >= x2_num && x1_num+1 <= n --> 只需要判断: x1_num+1 <= n
//    可以加右括号: x1_num >= x2_num+1 && x2_num+1 <= n --> 都要判断
//     */
//
//    Prefix getNewAddLeft(){
//        return new Prefix(this.curPre + "(", this.x1_num + 1, this.x2_num);
//    }
//
//    Prefix getNewAddRight(){
//        return new Prefix(this.curPre + ")", this.x1_num, this.x2_num + 1);
//    }
//
//    boolean canAddLeft(int n){
//        // return this.x1_num + 1 <= n;
//        return this.x1_num < n;
//    }
//
//    boolean canAddRight(){
//        // return (this.x1_num - this.x2_num >= 1) && (this.x2_num + 1 <= n);
//        // return this.x1_num - this.x2_num >= 1;
//        return this.x1_num > this.x2_num;
//    }
//
//}

