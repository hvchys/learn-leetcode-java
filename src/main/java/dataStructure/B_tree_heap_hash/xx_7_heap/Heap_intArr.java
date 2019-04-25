package dataStructure.B_tree_heap_hash.xx_7_heap;

import Util.printIntData;
import Util.printTree.printTree;

public abstract class Heap_intArr {
    public int capacity;
    public int[] mH;
    public int currentSize;

    public Heap_intArr(){

    }

    public Heap_intArr(int capacity){
        this.capacity = capacity;
        this.mH = new int[capacity + 1];
        // this.mH[0] = Integer.MIN_VALUE;
        this.currentSize = 0;
    }

    public void createHeap(int[] arrA){
        String curInfo;
        for(int i = 0; i < arrA.length; i++){
            insert(arrA[i]);
            // curInfo = "建堆, step: " + i + ": " + arrA[i];
            // printHeap(curInfo);
            // System.out.println("----------------------");
        }
    }

    public boolean idxExist(int i){
        return i <= this.currentSize;
    }

    public void printArr(){
        printIntData.arrWithIdx("ele in heap", this.mH);
    }

    public void insert(int x) {
        if(this.currentSize == this.capacity){
            System.out.println("insert error: heap is full");
            return;
        }
        // !!! mH[0] 这里是不放东西的，我不知道为啥
        // System.out.println("insert: before: " + this.currentSize);
        this.currentSize++;
        // System.out.println("insert: after: " + this.currentSize);
        int idx = this.currentSize;
        this.mH[idx] = x;
        bubbleUp(idx);
    }

    public int peekRoot(){
        return this.mH[1];
    }

    public int extractRoot() {
        int min = this.mH[1];
        this.mH[1] = this.mH[this.currentSize];
        this.mH[this.currentSize] = 0;
        this.currentSize--;
        if(this.currentSize == 0){
            System.out.println("extractRoot: is empty now.");
            return min;
        }else{
            sinkDown(1);
            return min;
        }
    }

    public void printHeap(String info){
        if(this.currentSize == 0){
            System.out.println("printHeap: is empty now.");
        }else{
            String infoAll = info + ":\nheap size: " + this.currentSize;
            int[] arr = new int[this.currentSize];
            // printIntData.arrWithIdx("cur heap", this.mH);
            System.arraycopy(this.mH, 1, arr, 0, this.currentSize);
            printTree.xxPrint(infoAll, arr);
        }
    }

    public abstract void bubbleUp(int pos);

    public abstract void sinkDown(int k);

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public void swap(int a, int b) {
        int temp = this.mH[a];
        this.mH[a] = this.mH[b];
        this.mH[b] = temp;
    }

    public int heapSize(){
        return this.currentSize;
    }


    public void addArrToHeap(int[] arrA){
        String curInfo;
        for(int i = 0; i < arrA.length; i++){
            insert(arrA[i]);
            // curInfo = "建堆, step: " + i + ": " + arrA[i];
            // printHeap(curInfo);
            // System.out.println("----------------------");
        }
    }

}



