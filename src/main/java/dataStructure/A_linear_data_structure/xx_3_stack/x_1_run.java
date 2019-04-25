package dataStructure.A_linear_data_structure.xx_3_stack;

public class x_1_run {
    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");

        s.print();

        s.push(50);

        s.print();

    }
}
