package dataStructure.A_linear_data_structure.xx_4_queue;

public class Queue {
    /*
    front: head 的 index
    rear: 尾部 的 index
    size: 当前元素个数
    capacity: 最多容纳的元素个数
    array: 队列 的 数组
     */

    public int front, rear, size;
    public int capacity;
    public int array[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    // 判断是否 full: 若 size == capacity, 则为 full
    public boolean isFull() {
        return (this.size == this.capacity);
    }

    // 若 size == 0, 则为 empty
    public boolean isEmpty() {
        return (this.size == 0);
    }

    // 增加元素。会改变 rear 和 size
    public void enqueue( int item) {
        if (isFull()){
            System.out.println("enqueue: is already full");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;
        System.out.println(item + " enqueued to queue");
    }

    // 减少元素。会改变 front 和 size
    public int dequeue() {
        if (isEmpty()){
            System.out.println("dequeue: is already empty");
            return Integer.MIN_VALUE;
        }

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    // 查看 队列的 front
    public int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    // 查看 队列的 rear(后面)
    public int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }
}

