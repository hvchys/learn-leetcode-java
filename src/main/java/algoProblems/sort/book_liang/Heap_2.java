package algoProblems.sort.book_liang;

/**

 Integer i = 2;
 Integer j = 3;
 i.compareTo(j) // -1
 compareTo: 为负的话，说明前面那个元素小
 */

// 是偶数的话，那就是 右孩子 了

public class Heap_2<E extends Comparable>{
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

    // 建一个默认的Heap
    public Heap_2(){

    }

    // 从一个 ver1arr 创建 Heap
    public Heap_2(E[] objects){
        for(E i:objects)
            add(i);
    }

    public void swap(int idx1, int idx2){
        E temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    // 从大到小排序
    // 给 Heap 加入一个新的元素
    public void add(E newObject){
        System.out.println("add: " + newObject);

        list.add(newObject); // append to the heap
        // 最后一个点的 index
        int curIdx = list.size() - 1;

        while(curIdx > 0){
            System.out.println(curIdx);
            int parentIndex = (curIdx - 1)/2;

            if(list.get(curIdx).compareTo(list.get(parentIndex))>0){
                // curIdx的值 比 parentIndex的值 大
                swap(curIdx, parentIndex);
                curIdx = parentIndex;
                // 检查 parentIndex 是否是 左孩子，以及它和 它的 右孩子 的关系
                if(parentIndex % 2 == 1 && list.get(parentIndex).compareTo(list.get(parentIndex+1)) > 0){

                }

            }else if(curIdx % 2 == 0 && list.get(curIdx).compareTo(list.get(curIdx-1)) > 0){
                // curIdx 是 右孩子，并且 右孩子 > 左孩子
                swap(curIdx, curIdx-1);
                curIdx = curIdx - 1;

            }else{
                // 已经是 heap 了
                break;
            }
        }
    }

    // 把 heap 的 root 拿掉
    public E remove(){
        if(list.size()==0) return null;

        // 把 root 拿掉
        // 把 最后一个元素(最小的) 放到 root 那里
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int curIdx = 0;
        while(curIdx < list.size()){
            int leftChildIndex = 2*curIdx + 1;
            int rightChildIndex = 2*curIdx + 2;

            // -------------------------------------------------------------------------------------
            // 找 curIdx 的这俩子孩子里面，较大的那个(x)
            int maxIndex;
            if(leftChildIndex >= list.size()){
                // 没有子孩子了，就退出
                break;
            }else if(rightChildIndex >= list.size()){
                // 没有 右子孩子，x 是 左子孩子
                maxIndex = leftChildIndex;
            }else{
                if(list.get(leftChildIndex).compareTo(list.get(rightChildIndex)) < 0){
                    maxIndex = rightChildIndex;
                }else{
                    maxIndex = leftChildIndex;
                }
            }

            // -------------------------------------------------------------------------------------
            // curIdx VS maxIndex
            if(list.get(curIdx).compareTo(list.get(maxIndex)) < 0){
                // curIdx对应的值 < maxIndex对应的值
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(curIdx));
                list.set(curIdx, temp);
                curIdx = maxIndex;
            }else
                // curIdx对应的值 >= maxIndex对应的值
                // 是一个 heap 了，可以退出了
                break;
        }
        return removedObject;
    }

    /** 树中的节点个数 **/
    public int getSize(){
        return list.size();
    }

    /** 打印当前的堆 **/
    public void printArray(String info){
        StringBuilder sb = new StringBuilder();
        sb.append(info).append(": ");
        for(E i: list){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
