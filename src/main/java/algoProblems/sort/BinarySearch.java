package algoProblems.sort;

public class BinarySearch {

    // leetCode.arr[idxStart] ~ leetCode.arr[idxEnd] 已经排好序了 (从小到大)
    // 在 leetCode.arr[idxStart] ~ leetCode.arr[idxEnd] 找 leetCode.arr[idx] 适合的位置
    public static int getXPlace(int arr[], int idxStart, int idxEnd, int idx){
        // System.out.println("idxStart: " + idxStart + ", idxEnd: " + idxEnd + ", idx: " + idx);
        int x = arr[idx];

        if(idxStart > idxEnd){
            System.out.println("error !!!!");
            System.out.println("idxStart: " + idxStart + ", idxEnd: " + idxEnd + ", idx: " + idx);
            return -1;
        }

        if(idxStart == idxEnd){
            int ans;
            if(x < arr[idxStart])
                ans = idxStart;
            else
                ans = idx;
            // System.out.println("=, ans: " + ans);
            return ans;
        }else if(idxEnd - idxStart == 1){
            if(x < arr[idxStart])
                return idxStart;
            else if(x < arr[idxEnd])
                return idxEnd;
            else
                return idx;
        }else{
            int mid = (idxStart + idxEnd) / 2;
            // System.out.println("mid: " + mid);
            if(x > arr[mid]){
                return getXPlace(arr, mid, idxEnd, idx);
            }else{
                return getXPlace(arr, idxStart, mid, idx);
            }
        }
    }


}

