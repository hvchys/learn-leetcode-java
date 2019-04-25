package dataStructure.B_tree_heap_hash.xx_7_heap;
//
//import Util.printTree.printTree;
//
//public class MinHeap_intArr {
//    /*
//    【最小堆】
//    上层: 小数据
//    下层: 大数据
//
//    【插入】(insert)
//    1 把item加到堆的最末尾(最下面一层)
//    2 进行 bubble-up 操作
//
//    【bubble-up】
//    把下层的小数据往上层挪
//    1 如果插入的item A比它的父结点B小: 把点A和父结点B互换
//    2 继续观察B和它的父结点，重复往上走，直到顺序正确，停止
//
//    【Extract-min】
//    1 把root的item拿出来(就是最小的item)
//    2 把最下面一层最后面的item放到root那里
//    3 进行 sink-down(bubble-down) 操作
//
//    【bubble-down】
//    把上层的大数据往下层挪
//    1 如果replaced element A比所有子结点都大，则: 把A和它的较小的子结点互换。
//    2 继续观察B和它的子结点，重复往下走，直到顺序正确，停止
//
//    【删除】(delete)
//    1 找到要删除的元素的index i，把最下面一行最后一个元素，放到index i那里
//    2 进行Sink-Down(bubble-down)
//     */
//
//    public int capacity;
//    public int[] mH;
//    public int currentSize;
//
//    public MinHeap_intArr(int capacity){
//        this.capacity = capacity;
//        this.mH = new int[capacity + 1];
//        this.currentSize = 0;
//    }
//
//    public void createHeap(int[] arrA){
//        String curInfo;
//        for(int i = 0; i < arrA.length; i++){
//            insert(arrA[i]);
//            curInfo = "建堆, step: " + i;
//            printHeap(curInfo);
//            System.out.println("----------------------");
//        }
//    }
//
//    public void insert(int x) {
//        if(this.currentSize == this.capacity){
//            System.out.println("insert error: heap is full");
//            return;
//        }
//        // !!! mH[0] 这里是不放东西的，我不知道为啥
//        this.currentSize++;
//        int idx = this.currentSize;
//        this.mH[idx] = x;
//        bubbleUp(idx);
//    }
//
//    public void bubbleUp(int pos) {
//        int parentIdx = pos/2;
//        int currentIdx = pos;
//        while (currentIdx > 0 && this.mH[parentIdx] > this.mH[currentIdx]) {
//            insert(currentIdx, parentIdx);
//            currentIdx = parentIdx;
//            parentIdx = parentIdx/2;
//        }
//    }
//
//    public int extractRoot() {
//        int min = this.mH[1];
//        this.mH[1] = this.mH[this.currentSize];
//        this.mH[this.currentSize] = 0;
//        this.currentSize--;
//        if(this.currentSize == 0){
//            System.out.println("extractRoot: is empty now.");
//            return min;
//        }else{
//            sinkDown(1);
//            return min;
//        }
//    }
//
//    public boolean idxExist(int i){
//        return i <= this.currentSize;
//    }
//
//    // 把 index 为 k 的数据，放到下面去
//    public void sinkDown(int k) {
//        int smallest = k;
//        int leftChildIdx = 2 * k;
//        int rightChildIdx = 2 * k + 1;
//        /*
//        1 如果replaced element A比所有子结点都大，则: 把A和它的较小的子结点互换。
//        2 继续观察B和它的子结点，重复往下走，直到顺序正确，停止
//         */
//        // 这里写的非常非常 tricky!!! 比较的时候 用 smallest 来比较
//        if (leftChildIdx <= heapSize() && this.mH[smallest] > this.mH[leftChildIdx]) {
//            smallest = leftChildIdx;
//        }
//        if (rightChildIdx <= heapSize() && this.mH[smallest] > this.mH[rightChildIdx]) {
//            smallest = rightChildIdx;
//        }
//        if (smallest != k) {
//            insert(k, smallest);
//            System.out.println("sinkDown: " + smallest);
//            sinkDown(smallest);
//        }
//    }
//
//    public void insert(int a, int b) {
//        int temp = this.mH[a];
//        this.mH[a] = this.mH[b];
//        this.mH[b] = temp;
//    }
//
//    public boolean isEmpty() {
//        return this.currentSize == 0;
//    }
//
//    public int heapSize(){
//        return this.currentSize;
//    }
//
//    public void printHeap(String info){
//        if(this.currentSize == 0){
//            System.out.println("printHeap: is empty now.");
//        }else{
//            String infoAll = info + ":\nheap size: " + this.currentSize;
//            int[] leetCode.arr = new int[this.currentSize];
//            System.arraycopy(this.mH, 1, leetCode.arr, 0, this.currentSize);
//            printTree.xxPrint(infoAll, leetCode.arr);
//        }
//    }
//}
