package algoProblems.sort.book_liang;

import Util.printIntData;

public class x_24_5_heap_sort {
    // 堆排序
    // 从大到小排序

    private static <E extends Comparable> void heapSort(E[] list){
        // create a heap of integers
        Heap<E> heap = new Heap<E>();

        // 给这个 heap 添加元素
        for(E i: list){
            heap.add(i);
            heap.printArray("add");

            // int[] structure = heap.getStructure();
            // printIntData.arrWithIdx("struct", structure);
        }

        // 从这个 heap 中 删除元素
        for(int i = list.length - 1; i >= 0; i--){
            list[i] = heap.remove();
            heap.printArray("remove");
        }

    }
//
//    public static void getStruct(int eleNum){
//        int[] leftChildArr = new int[eleNum];
//        int[] rightChildArr = new int[eleNum];
//        int[] parentArr = new int[eleNum];
//
//        int k = 0;
//        while(k < eleNum){
//            parentArr[k] = -1;
//            k++;
//        }
//
//        int curLeftChildIdx;
//        int curRightChildIdx;
//        int i = 0;
//        while(i < eleNum){
//            curLeftChildIdx = 2*i+1;
//            curRightChildIdx = 2*i+2;
//            if(curRightChildIdx < eleNum){
//                parentArr[curRightChildIdx] = i;
//                rightChildArr[i] = curRightChildIdx;
//            }else{
//                rightChildArr[i] = -1;
//            }
//
//            if(curLeftChildIdx < eleNum){
//                parentArr[curLeftChildIdx] = i;
//                leftChildArr[i] = curLeftChildIdx;
//            }else{
//                leftChildArr[i] = -1;
//            }
//            i++;
//        }
//        printIntData.arrWithIdx("leftChildArr", leftChildArr);
//        printIntData.arrWithIdx("rightChildArr", rightChildArr);
//        printIntData.arrWithIdx("parentArr_1", parentArr);
//    }

    public static void parentArr(int eleNum){
        int[] parentArr = new int[eleNum];

        int k = 0;
        while(k < eleNum){
            parentArr[k] = -1;
            k++;
        }

        int curIdx = eleNum - 1;
        while(curIdx >= 0){
            int parentIndex = (curIdx - 1)/2;
            parentArr[curIdx] = parentIndex;
            curIdx--;
        }

        printIntData.arrWithIdx("parentArr_2", parentArr);
    }

    private static void test(){
        // create a heap of integers
        Heap<Integer> heap = new Heap<Integer>();

        heap.add(0);
        heap.add(2);
        heap.add(1);
        heap.add(4);

        heap.printArray("before");

        heap.add(3);
        heap.printArray("after");

    }

    private static void addEle(int i, Heap_2<Integer> heap){
        System.out.println("\nadd " + i + ":");
        heap.add(i);
        heap.printArray("add " + i);
    }

    private static void test_2(){
        // create a heap of integers
        Heap_2<Integer> heap = new Heap_2<Integer>();

        addEle(0, heap);
        addEle(2, heap);
        addEle(1, heap);
        addEle(4, heap);
        addEle(3, heap);

    }

    public static void main(String[] args) {
        Integer[] list = {2,3,2,5,6,1,-2,3,14,12};
        // heapSort(list);

        // getStruct(10);
        // parentArr(10);

        // printTree();

        test_2();

    }

}

