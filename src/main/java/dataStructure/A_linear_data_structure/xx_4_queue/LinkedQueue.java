package dataStructure.A_linear_data_structure.xx_4_queue;

// 表示 队列 里面的 点
class QNode {
    int key;
    QNode next;

    // 创建一个点
    public QNode(int key) {
        this.key = key;
        this.next = null;
    }
}

// 表示 队列
// 点的链接顺序: 第一个是 front点，然后从前往后 link 过去
public class LinkedQueue {
    public QNode front, rear;

    public LinkedQueue() {
        this.front = this.rear = null;
    }

    // enqueue, 增加一个元素
    public void enqueue(int key) {
        // 创建一个新结点
        QNode temp = new QNode(key);

        // 如果队列是空的，那，这个新结点，既是front，也是rear
        if (this.rear == null) {
            // this.front = this.rear = temp;
            this.front = temp;
            this.rear = temp;
            return;
        }

        // 这里很有技巧 !!!!!
        // 原来: front -> ... -> rear
        // 现在: front -> ... -> 原来的rear -> 新结点
        this.rear.next = temp;
        this.rear = temp;
    }

    // dequeue: 去掉一个结点
    public QNode dequeue() {
        // 如果队列是空的，返回 null
        if (this.front == null)
            return null;

        // 把之前的 front保存一下，作为返回值
        // 原来: front -> NodeXX -> ... -> rear
        // 现在:          NodeXX -> ... -> rear
        QNode temp = this.front;
        this.front = this.front.next;

        // 如果在 dequeue(去掉一个结点) 之后，front 成 null 了，那，把 rear 也改成 null
        if (this.front == null)
            this.rear = null;
        return temp;
    }
}


