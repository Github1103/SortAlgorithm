package cn.codeyoung.sort;

import cn.codeyoung.utils.ArrayUtils;
import cn.codeyoung.utils.CompareUtils;
import cn.codeyoung.utils.GenArray;
import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @Data 15:50 2021/12/9
 * @Author ZhangJR
 * @Description
 */
public class HeapSort {
    static class Heapify{
        protected int[] data;
        protected int count;
        protected int capacity;
        protected int sort;

        public Heapify(int[] arr,int _sort){
            int n = arr.length;

            data = new int[n+1];

            for (int i = 0;i<n;i++){
                data[i+1] = arr[i];
            }
            sort = _sort;
            count = n;
            capacity = n;

            for (int i = count/2;i>=1;i--){
                shiftDown(i);
            }
        }

        //堆的核心辅助函数

        /**
         * 将k位置的元素往上交换
         * @param k
         */
        private void shiftUp(int k){
            while (k > 1 && CompareUtils.compare(data[k>>1],data[k],sort)){
                swap(k,k>>1);
                k>>=1;
            }
        }

        /**
         * 将位置的元素往下交换
         * @param k
         */
        private void shiftDown(int k){
            while (k<<1 <= count){
                int j = k<<1;
                if (j+1 <= count && CompareUtils.compare(data[j+1],data[j],sort)){
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
            data[count+1] = item;
            count++;
            shiftUp(count);
        }

        /**
         * 获取根节点数据
         */
        public int poll(){
            assert count > 0;
            int result = data[1];
            swap(1,count);
            count--;
            shiftDown(1);
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
