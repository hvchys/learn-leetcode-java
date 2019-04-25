public class helloWorld {

    public static int getIth(int x){
        // x > 0, 位数 > 1
        // exp: 10,    100,    1000
        //      个位数, 十位数, 百位数
        int exp = 1;
        int i = 0;
        while(x >= exp){
            exp = exp*10;
            i++;
        }

        return i;
    }

    public static void test(int x){
        System.out.println(x + ": " + getIth(x));
    }


    public static void main(String[] args) {

        test(10);
        test(20);
        test(34);
        test(124);
        test(100);
        test(9999);



//        System.out.println("aaa!");
//
//        int[][] testArr = new int[5][5];
//        for(int i = 0; i < 5; i++){
//            for(int j = i; j < 5; j++){
//                System.out.println("i: " + i + ", j: " + j);
//            }
//        }
//
//        System.out.println("\n\n-----------------------------------");
//
//        int j;
//        for(int delta = 0; delta < 5; delta++){
//            for(int i = 0; i < 5; i++){
//                j = i + delta;
//                if(j < 5){
//                    System.out.println("i: " + i + ", j: " + j);
//                }
//            }
//            System.out.println("-----------------------------------");
//        }
//
//        List<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
//        System.out.println(arr.size());
//        arr.add(new ArrayList<String>());
//        System.out.println(arr.size());
    }
}

