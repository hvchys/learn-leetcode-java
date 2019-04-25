package algoProblems.sort.book_liang;

import Util.printIntData;

public class x_24_4_quick_sort {
    // 快速排序

    /**
     1 要排序的数据是整数
     2 数据存储在数组中
     3 数据以升序(从小到大)排列
     */

    /*
     步骤：
     1 在数组中选择一个称为主元(pivot)的元素，将数组分为两部分，第一部分的元素都小于等于主元，第二部分的元素都大于主元。
     2 在两部分中，都递归地应用快速排序算法
     */

    private static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int first, int last){
        if(last > first){
            int pivotIndex = partition(arr, first, last);
            quickSort(arr, first, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, last);
        }
    }

    // 对于输入的数组 ver1arr, 把它的 ver1arr[first...last] 部分，划分成两部分，返回分开的地方的index
    private static int partition(int[] arr, int first, int last){
        System.out.println("\npartition: first: "+first+", last: "+last);

        // 把第一个元素，选为 pivot
        int pivot = arr[first];
        // 从前往后搜索 (forward search) 的起点 index
        int low = first + 1;
        // backward search 的起点 index
        int high = last;

        String info;
        while(high > low){
            // 从左开始，从前往后搜索 (forward search)
            while(low <= high && arr[low] <= pivot)
                low++;

            // 从右开始，从后往前搜索 (backward search)
            while(low <= high && arr[high] > pivot)
                high--;

            // 找到第一组在pivot左侧却比pivot大，在pivot右侧却比pivot小的元素，进行对换
            if(high > low){
                info = "place1(互换之前): low: "+low+", high: "+high;
                printIntData.arrWithMarkPart(info, arr, new int[]{low, high}, "index", first, last);

                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;

                info = "place1(互换之后): low: "+low+", high: "+high;
                printIntData.arrWithMarkPart(info, arr, new int[]{low, high}, "index", first, last);
            }
        }
        // 上面这个while循环结束之后，可能high和low是一样的了

        while(high > first && arr[high] >= pivot)
            high--;

        // 把 pivor 和 ver1arr[high] 互换
        if(pivot > arr[high]){
            info = "place2(互换之前): low: "+low+", high: "+high;
            printIntData.arrWithMarkPart(info, arr, new int[]{first, high}, "index", first, last);

            arr[first] = arr[high];
            arr[high] = pivot;

            info = "place2(互换之后): low: "+low+", high: "+high;
            printIntData.arrWithMarkPart(info, arr, new int[]{first, high}, "index", first, last);

            System.out.println("return: " + high);

            return high;
        }
        else{

            info = "place3: low: "+low+", high: "+high;
            printIntData.arrWithIdxPart(info, arr, first, last);
            System.out.println("return: " + first);

            return first;
        }
    }


    public static void main(String[] args){
        int arr_1[] = {88, 20, 54, 97, 19, 40, 51};
        printIntData.arrWithIdx("input", arr_1);
        quickSort(arr_1);
        printIntData.arrWithIdx("ans", arr_1);
    }

}
