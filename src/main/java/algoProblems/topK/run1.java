package algoProblems.topK;

public class run1 {

    public static void printArr_2(int[] array){
        StringBuilder sb = new StringBuilder();
        String curStr = "";
        for(int i = 0; i < array.length; i++){
            curStr = "(" + i + ")" + array[i] + " ";
            sb.append(curStr);
        }
        System.out.println(sb.toString());
    }

    // !!!!!! 是错的
    public static void printArr(String curLine, int[] array, int x, int left, int right){
        StringBuilder sb = new StringBuilder();
        String curStr = "";
        for(int i = 0; i < array.length; i++){
            if(i == left){
                curStr = "(*l*" + i + ")" + array[i] + " ";
            }else if(i == right){
                curStr = "(*r*" + i + ")" + array[i] + " ";
            }else{
                curStr = "(" + i + ")" + array[i] + " ";
            }
            sb.append(curStr);
        }
        System.out.println(curLine + ", x: " + x + ": " + sb.toString());
    }

    public static int partition(int[] array, int left, int right) {
        System.out.println("partition: left: " + left + ", right: " + right);
        /*
        * 按基准点划分数组，左边的元素大于基准点，右边的元素小于基准点
        * */
        int x = array[left];//基准点，随机选择
        do {
            while (array[right] < x && left < right){
                printArr("while_1, right前面", array, x, left, right);
                //从后向前扫描，找到第一个比基准点大的元素
                right--;
                printArr("while_1, right后面", array, x, left, right);
            }

            if (left < right) {
                printArr("if_1, 赋值前面", array, x, left, right);
                array[left] = array[right]; //大元素前移
                printArr("if_1, 改变left前面", array, x, left, right);
                left++;

            }
            while (array[left] >= x && left < right){
                //从前向后扫描，找到第一个比基准点小的元素
                printArr("while_2, left前面", array, x, left, right);
                left++;
                printArr("while_2, left后面", array, x, left, right);
            }

            if (left < right) {
                printArr("if_2, 赋值前面", array, x, left, right);
                array[right] = array[left]; //小元素后移
                printArr("if_2, 改变right前面", array, x, left, right);
                right--;

            }
        } while (left < right);
        array[left] = x;
        System.out.println("");
        return left;
    }

    public static int findTopK(int[] array, int left, int right, int k) {
        int index = -1;
        if (left < right) {
            int pos = partition(array, left, right);
            int len = pos - left + 1;
            if (len == k) {
                index = pos;
            } else if (len < k) {
                // Sa 中元素个数小于K，到Sb中查找k-len个数字
                index = findTopK(array, pos + 1, right, k - len);
            } else {
                // Sa 中元素的个数大于或等于k
                index = findTopK(array, left, pos - 1, k);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        /*
        【解法一】
        最简单且最容易想到的算法是对数组进行排序（快速排序），然后取最大或最小的K个元素。总的时间复杂度为O(N*logN)+O(K)=O(N*logN)。该算法存在以下问题：

        1. 快速排序的平均复杂度为O(N*logN)，但最坏时间复杂度为O(n2)，不能始终保证较好的复杂度
        2. 只需要前k大或k小的数,，实际对其余不需要的数也进行了排序，浪费了大量排序时间

        总结：通常不会采取该方案。
        * */

        /*
        【解法二】
        不用快速排序，但是，利用快速排序的思想，在数组中随机找一个元素key，将数组分成两部分Sa和Sb，其中Sa的元素>=key，Sb的元素<key，
        然后分析两种情况：
        1 若Sa中元素的个数大于或等于k，则在Sa中查找最大的k个数
        2 若Sa中元素的个数小于k，其个数为len，则在Sb中查找k-len个数字

        如此递归下去，不断把问题分解为更小的问题，直到求出结果。
        该算法的平均时间复杂度为O(N * logk)。
        * */
        int k = 2;
        int array[] = {15, 13, 16, 12, 17};
        // [index, value]
        // [[9, 100], [8, 87], [7, 46], [6, 26], [5, 20], [4, 9], [3, 8], [2, 5], [1, 4], [0, 2]]
        // findTopK: 找从小到大，第k个元素
        int ansIndex = findTopK(array, 0, array.length - 1, k);
        System.out.println(ansIndex);

        // Arrays.stream(array).mapToObj(value -> String.valueOf(value));
        printArr_2(array);

    }
}

