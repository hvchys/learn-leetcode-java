package algoProblems.sort;

public class xxSheet {

//    private static void QuickSort(int ver1arr[], int low, int high) {
//        /*
//          【快速排序】
//          x_5_clone[low..high)
//          每一轮对序列的调整，使得所有大于第一个元素key的元素位于key的右边，
//          以及所有小于key的元素位于key左边
//          最后分别对key左右两边的子序列作快速排序
//        * */
//        System.out.println("\nQuickSort: low: " + low + ", high: " + high);
//
//        if (high - low < 2) {
//            // 单元素区间
//            System.out.println("单元素区间");
//            return;
//        }
//
//        int key = ver1arr[low];	/* 保存第一个元素 */
//        int i = low, j = high - 1;
//
//        while (i < j) {
//            while (i < j && key <= ver1arr[j]) {
//                // 从后往前，找小于key的元素
//                j--;
//            }
//            if (i < j) {
//                // 将小于key的元素调整至key左边
//                printIntData.ver1arr("if_1, step1: i: " + i + ", j: " + j, ver1arr);
//                // ver1arr[i++] = ver1arr[j];
//                ver1arr[i] = ver1arr[j];
//                i++;
//                printIntData.ver1arr("if_1, step2: i: " + i + ", j: " + j, ver1arr);
//            }
//            while (i < j && ver1arr[i] <= key) {
//                // 从前往后，找大于key的元素
//                i++;
//            }
//            if (i < j) {
//                // 将大于key的元素调整至key右边
//                printIntData.ver1arr("if_2, step1: i: " + i + ", j: " + j, ver1arr);
//                // ver1arr[j--] = ver1arr[i];
//                ver1arr[j] = ver1arr[i];
//                j--;
//                printIntData.ver1arr("if_2, step2: i: " + i + ", j: " + j, ver1arr);
//            }
//        }
//        ver1arr[i] = key;	/* 将key置于正确位置 */
//        printIntData.ver1arr("after while: i: " + i + ", j: " + j, ver1arr);
//
//        QuickSort(ver1arr, low, i);
//        QuickSort(ver1arr, i + 1, high);
//    }

}
