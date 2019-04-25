package dataStructure.A_linear_data_structure.xx_4_queue;

import Util.randNum;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

class PQItem {
    String name;
    int age;

    PQItem(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + this.name + ", " + this.age + "]";
    }
}

// 按照年龄排序
class SortByAge implements Comparator<PQItem>{
    @Override
    public int compare(PQItem o1, PQItem o2) {
        return o1.age - o2.age;
    }
}


public class x_4_pq_comparator {

    private static void printPQ(String info, PriorityQueue<PQItem> pQueue){
        System.out.println(info);
        Iterator itr = pQueue.iterator();
        while(itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();
    }

    private static void addArrToPQ(String[] nameArr, int[] ageArr, PriorityQueue<PQItem> pQueue){
        System.out.println("添加元素的顺序");
        String curName;
        int curAge;
        PQItem curItem;
        for(int i = 0; i < nameArr.length; i++){
            curName = nameArr[i];
            curAge = ageArr[i];
            curItem = new PQItem(curName, curAge);
            System.out.print(curItem + " ");
            pQueue.add(curItem);
        }
        System.out.println("\n添加完毕");
    }

    public static void main(String[] args){
        String[] nameArr = {"a", "c", "a", "f", "a", "d", "z", "q", "p", "a", "e"};
        int[] ageArr = randNum.shuffleArr(nameArr.length);

        Comparator compareByAge = new SortByAge();
        PriorityQueue<PQItem> pQueue = new PriorityQueue<PQItem>(20, compareByAge);
        addArrToPQ(nameArr, ageArr, pQueue);

        printPQ("queue:", pQueue);

        System.out.println("\npeek 优先级最高的元素: " + pQueue.peek());

    }
}
