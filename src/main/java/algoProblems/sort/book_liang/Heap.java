package algoProblems.sort.book_liang;

/**

 Integer i = 2;
 Integer j = 3;
 i.compareTo(j) // -1
 compareTo: 为负的话，说明前面那个元素小
 */


public class Heap<E extends Comparable>{
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

    // 建一个默认的Heap
    public Heap(){

    }

    // 从一个 ver1arr 创建 Heap
    public Heap(E[] objects){
        for(E i:objects)
            add(i);
    }

    // 从大到小排序
    // 给 Heap 加入一个新的元素
    public void add(E newObject){
        list.add(newObject); //append to the heap
        // 最后一个点的 index
        int curIdx = list.size() - 1;

        while(curIdx > 0){
            int parentIndex = (curIdx - 1)/2;
            // insert if the current object is greater than its parent
            if(list.get(curIdx).compareTo(list.get(parentIndex))>0){
                // curIdx的值 比 parentIndex的值 大
                E temp = list.get(curIdx);
                list.set(curIdx, list.get(parentIndex));
                list.set(parentIndex, temp);

            }else
                break; // the tree is a heap now

            curIdx = parentIndex;
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
