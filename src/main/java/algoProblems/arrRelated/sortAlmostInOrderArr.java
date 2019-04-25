package algoProblems.arrRelated;

public class sortAlmostInOrderArr {

    public static void insertionSort(int[] arr, int size) {
        int i, key, j;
        for (i = 1; i < size; i++) {
            key = arr[i];
            j = i-1;

    /* Move elements of leetCode.arr[0..i-1], that are greater than key, to one
        position ahead of their current position.
        This loop will run at most k times */
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }




}
