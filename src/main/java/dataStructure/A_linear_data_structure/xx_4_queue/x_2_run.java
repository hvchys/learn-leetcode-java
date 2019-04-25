package dataStructure.A_linear_data_structure.xx_4_queue;

public class x_2_run {
    public static void main(String[] args) {
        LinkedQueue q=new LinkedQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Dequeued item is "+ q.dequeue().key);
    }
}
