package leetCode;

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

//        test(10);
//        test(20);
//        test(34);
//        test(124);
//        test(100);
//        test(9999);


        System.out.println("test");
    }
}

