package dataStructure.A_linear_data_structure.xx_3_stack;

import Util.printIntData;

public class Stack {
    public static final int MAX = 1000;
    public int top;
    public int a[] = new int[MAX]; // Maximum size of Stack

    public boolean isEmpty() {
        return (this.top < 0);
    }
    public Stack() {
        this.top = -1;
    }

    public boolean push(int x) {
        if (this.top >= (MAX-1))
        {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            // this.a[++top] = x;
            this.top++;
            this.a[this.top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    public int pop() {
        if (this.top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            // int x = this.a[top--];
            int x = this.a[this.top];
            this.top--;
            return x;
        }
    }

    public void print(){
        printIntData.ver1arrPart("", this.a, 0, this.top);
    }

}

