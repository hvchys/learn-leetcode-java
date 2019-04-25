package dataStructure.A_linear_data_structure.xx_4_queue;

import java.util.Iterator;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{
    public int age;

    Person(int age){
        this.age=age;
    }

    public int compareTo(Person other){
        return this.age - other.age;
    }

    @Override
    public String toString() {
        return "P(" + this.age + ")";
    }
}

public class x_5_pq_comparable {

    private static void printPQ(String info, PriorityQueue<Person> pQueue){
        System.out.println(info);
        Iterator itr = pQueue.iterator();
        while(itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();
    }

    private static void addArrToPQ(int[] arr, PriorityQueue<Person> pQueue){
        System.out.println("添加元素的顺序");
        for(int i: arr){
            System.out.print(i + " ");
            pQueue.add(new Person(i));
        }
        System.out.println("\n添加完毕");
    }

    // 年龄小的，优先级在前面
    public static void main(String[] args){
        PriorityQueue<Person> pq = new PriorityQueue<Person>();
        int[] ageArr = {5, 9, 8, 7, 4, 1, 6, 0, 2, 3};

        addArrToPQ(ageArr, pq);

        // 用 iterator 去遍历，也不是按照优先级排列的 !!!!
        printPQ("all: ", pq);

        System.out.println("\npeek 优先级最高的元素: " + pq.peek());

    }
}


