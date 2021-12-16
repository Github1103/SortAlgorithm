package cn.codeyoung.sort;

import cn.codeyoung.utils.ArrayUtils;
import cn.codeyoung.utils.CompareUtils;
import cn.codeyoung.utils.GenArray;
import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @Data 15:50 2021/12/9
 * @Author ZhangJR
 * @Description 堆排序
 */
public class HeapSort {
    //等价于java中的PriorityQueue
    static class Heapify{
        protected int[] data;
        protected int count;
        protected int capacity;
        protected int sort;

        public Heapify(int[] arr,int _sort){
            int n = arr.length;

            data = new int[n];

            for (int i = 0;i<n;i++){
                data[i] = arr[i];
            }
            sort = _sort;
            count = n;
            capacity = n;

            for (int i = count>>>1-1;i>=0;i--){
                shiftDown(i);
            }
        }

        //堆的核心辅助函数

        /**
         * 将k位置的元素往上交换
         * @param k
         */
        private void shiftUp(int k){
            while (k > 0 && CompareUtils.compare(data[k],data[(k-1)>>>1],sort)){
                int parent = (k-1)>>>1;
                swap(k,parent);
                k = parent;
            }
        }

        /**
         * 将位置的元素往下交换
         * @param k
         */
        private void shiftDown(int k){
            while (k < count>>>1){
                int j = (k<<1)+1;
                if (j+1 < count && CompareUtils.compare(data[j+1],data[j],sort)){
                    j++;
                }
                if (CompareUtils.compare(data[k],data[j],sort)) break;
                swap(k,j);
                k = j;
            }
        }

        private void swap(int i,int j){
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        /**
         * 插入元素
         * @param item
         */
        public void insert(int item){
            assert count + 1 <= capacity;
            data[count] = item;
            count++;
            shiftUp(count-1);
        }

        /**
         * 获取根节点数据
         */
        public int poll(){
            assert count > 0;
            int result = data[0];
            swap(0,count-1);
            count--;
            shiftDown(0);
            return result;
        }

        public int[] toArray(){
            int[] arr = new int[data.length-1];
            for (int i = arr.length-1;i>=0;i--){
                arr[i] = poll();
            }
            return arr;
        }
    }

    public static int[] sort(int[] arr){
        return sort(arr,1,1);
    }

    public static int[] sort(int[] array,int sort,int change){
        //利用小/大根堆的特性，就可以取出顺序和倒序
        Heapify heapify = new Heapify(array,sort);
        if (change == 1){
            for (int i = array.length-1; i >=0; i--) {
                array[i] = heapify.poll();
            }
            return array;
        }else {
            return heapify.toArray();
        }
    }


    public static void main(String[] args) {
        int[] arr = GenArray.createIntArr();
        GenArray.beforeSort(arr);
        HeapSort.sort(arr);
        GenArray.afterSort(arr);
    }

}
