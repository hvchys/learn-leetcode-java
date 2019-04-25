package dataStructure.B_tree_heap_hash.xx_7_heap;

public class run_1_heap {
    public static void main(String args[]){
//        int[] arrA = {3,2,1,7,8,4,10,16,12};
//
//        printIntData.arrWithIdx("Original Array", arrA);
//
//        printTree.xxPrint("Original Array", arrA);


//        MinHeap_intArr minHeap = new MinHeap_intArr(arrA.length);
//        minHeap.createHeap(arrA);
//        minHeap.printHeap("最小堆");
//
//
//        MaxHeap_intArr maxHeap = new MaxHeap_intArr(arrA.length);
//        maxHeap.createHeap(arrA);
//        maxHeap.printHeap("最大堆");

//        int[] testArr = {56, 13, 28, 42, 40, 50, 10, 52, 11, 33, 48, 59, 43, 51, 39, 49, 44, 36, 23, 19};
//        MaxHeap_intArr maxHeap = new MaxHeap_intArr(testArr.length);
//        maxHeap.createHeap(testArr);
//        maxHeap.printHeap("");


        int[] arr1 = {3};
        int[] arr2 = {-1, -2};
        MinHeap_intArr minHeap = new MinHeap_intArr(3);
        minHeap.addArrToHeap(arr1);
        minHeap.addArrToHeap(arr2);

        minHeap.printHeap("");

    }
}
