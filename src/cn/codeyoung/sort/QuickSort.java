package cn.codeyoung.sort;

import cn.codeyoung.utils.CompareUtils;
import cn.codeyoung.utils.GenArray;

import java.util.Arrays;

/**
 * @Data 14:26 2021/12/9
 * @Author ZhangJR
 * @Description 快速排序
 */
public class QuickSort {
    /**
     * 封装方法
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        return sort(arr,1,1);
    }

    /**
     * 快速排序
     * @param array 数组
     * @param sort 升降序 1升 0降
     * @param change 是否改变原数组
     * @return
     */
    public static int[] sort(int[] array,int sort,int change){
        if (change == 1){
            return quickSort(array,0,array.length-1,sort);
        }else {
            int[] arr = Arrays.copyOf(array,array.length);
            return quickSort(arr,0,arr.length-1,sort);
        }
    }

    /**
     * 分治快速排序
     * @param arr
     * @param left
     * @param right
     * @param sort
     * @return
     */
    //quickSort分为两个部分，首先选定一个基准指，然后遍历数组，将比基准值小或者大的数转移到基准值之前，和基准值交换位置，交换结束后
    //基准值就确定了他的位置。然后二分数组，对小的部分再进行quickSort排序。直到分成1为止，直接返回。
    private static int[] quickSort(int[] arr,int left,int right,int sort){
        if (left<right){
            int quickSortIndex = partition(arr,left,right,sort);
            quickSort(arr,left,quickSortIndex-1,sort);
            quickSort(arr,quickSortIndex+1,right,sort);
        }
        return arr;
    }

    /**
     * 分区
     * @param arr
     * @param left
     * @param right
     * @param sort
     * @return
     */
    private static int partition(int[] arr,int left,int right,int sort){
        //设定基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (CompareUtils.compare(arr[pivot],arr[i],sort)){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);
        return index-1;
    }

    /**
     * 交换元素位置。
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("Quick Sort:");
        int[] arr = GenArray.createIntArr();
        GenArray.beforeSort(arr);
        QuickSort.sort(arr);
        GenArray.afterSort(arr);
    }
}
