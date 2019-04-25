package dataStructure.A_linear_data_structure.xx_4_queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class x_3_priority_queue {

    private static void printPQ(String info, PriorityQueue<String> pQueue){
        System.out.println(info);
        Iterator itr = pQueue.iterator();
        while(itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();
    }

    private static void addStrArrToPQ(String[] arr, PriorityQueue<String> pQueue){
        System.out.println("添加元素的顺序");
        for(String i: arr){
            System.out.print(i + " ");
            pQueue.add(i);
        }
        System.out.println("\n添加完毕");
    }

    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.offer(3);
        pq.offer(4);
        pq.offer(2);

        System.out.println(pq); // [2, 4, 3]  本身是无序的 !!!

        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><>");
        /*
        ------------------------------------------------------------------------------------------------------------
         */

        /*
        直接去 print 的话，PQ是无序的
        如果用 iterator去遍历，也是无序的 !!!
         */

        PriorityQueue<String> pQueue = new PriorityQueue<String>();

        String[] allStrArr = {"a", "c", "a", "f", "a", "d", "z", "q", "p", "a", "e"};
        addStrArrToPQ(allStrArr, pQueue);
//        pQueue.add("C");
//        pQueue.add("C++");
//        pQueue.add("Java");
//        pQueue.add("Python");

        System.out.println("\npeek 优先级最高的元素: " + pQueue.peek());

        printPQ("\n打印所有元素:", pQueue);

        // 去掉head的元素
        pQueue.poll();

        printPQ("\n移除一个元素之后:", pQueue);

        // 去掉 元素Java 之后
        String removeStr = "Java";
        if(pQueue.remove(removeStr)){  // 判断 这个元素 在不在 PQ 里面
            printPQ("\n去掉元素" + removeStr + "之后:", pQueue);
        }else{
            System.out.println("\n去掉元素" + removeStr + ": 这个元素不存在");
        }

        removeStr = "a"; //
        /*
            a 出现了多次，会都去掉吗 ???
            不会，只会去掉一个 a
         */
        if(pQueue.remove(removeStr)){  // 判断 这个元素 在不在 PQ 里面
            printPQ("\n去掉元素 " + removeStr + " 之后:", pQueue);
        }else{
            System.out.println("\n去掉元素 " + removeStr + " : 这个元素不存在");
        }

        // 判断元素是否存在
        String existStr = "C";
        boolean b = pQueue.contains(existStr);
        System.out.println("\nPQ是否包含" + existStr + ": " + b);

        // pQueue --> Obj[] leetCode.arr
        /*
            这样转换之后的 leetCode.arr 是有序的吗:
            不是
         */
        Object[] arr = pQueue.toArray();
        System.out.println("\n遍历 leetCode.arr: ");
        for(Object i: arr)
            System.out.print(i.toString() + " ");
        System.out.println();
    }
}
