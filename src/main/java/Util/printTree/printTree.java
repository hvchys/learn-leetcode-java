package Util.printTree;

public class printTree {

    public static void xxPrint(String info, int[] x){
        Node<Integer> root = BTree_struct.arrToTree(x, new int[]{0});
        if(info.equals("")){
            BTree_diffLen.print(root);
        }else{
            System.out.println(info + ":");
            BTree_diffLen.print(root);
        }
    }

    public static void main(String[] args) {

        int arr_1[] = {188, 120, 154, 197, 119, 140, 151};
        xxPrint("", arr_1);

        int arr_2[] = {8, 2, 5, 9, 1, 4, 7, 6};
        xxPrint("", arr_2);
    }
}

