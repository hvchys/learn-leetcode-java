package dataStructure.B_tree_heap_hash.xx_7_heap;

public class MaxHeap_intArr extends Heap_intArr {
    /*
    【最大堆】
    上层: 大数据
    下层: 小数据

    【插入】(insert)
    1 把item加到堆的最末尾(最下面一层)
    2 进行 bubble-up 操作

    【bubble-up】
    把下层的大数据往上层挪
    1 如果插入的item A比它的父结点B大: 把点A和父结点B互换
    2 继续观察B和它的父结点，重复往上走，直到顺序正确，停止

    【Extract-min】
    1 把root的item拿出来(就是最大的item)
    2 把最下面一层最后面的item放到root那里
    3 进行 sink-down(bubble-down) 操作

    【bubble-down】
    把上层的小数据往下层挪
    1 如果replaced element A比所有子结点都小，则: 把A和它的较大的子结点互换。
    2 继续观察B和它的子结点，重复往下走，直到顺序正确，停止

    【删除】(delete)
    1 找到要删除的元素的index i，把最下面一行最后一个元素，放到index i那里
    2 进行Sink-Down(bubble-down)
     */

    public MaxHeap_intArr(int capacity){
        super(capacity);
        this.mH[0] = Integer.MAX_VALUE;
    }

    public void bubbleUp(int pos) {
        int parentIdx = pos/2;
        int currentIdx = pos;
        while (currentIdx > 1 && this.mH[parentIdx] < this.mH[currentIdx]) {
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx/2;
        }
    }

    // 把 index 为 k 的数据，放到下面去
    public void sinkDown(int k) {
        int biggest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k + 1;
        /*
        1 如果 replaced element A 比所有子结点都小，则: 把A和它的较大的子结点互换。
        2 继续观察B和它的子结点，重复往下走，直到顺序正确，停止
         */
        // 这里写的非常非常 tricky!!! 比较的时候 用 biggest 来比较
        if (leftChildIdx <= heapSize() && this.mH[biggest] < this.mH[leftChildIdx]) {
            biggest = leftChildIdx;
        }
        if (rightChildIdx <= heapSize() && this.mH[biggest] < this.mH[rightChildIdx]) {
            biggest = rightChildIdx;
        }
        if (biggest != k) {
            swap(k, biggest);
            // System.out.println("sinkDown: " + biggest);
            sinkDown(biggest);
        }
    }

}
