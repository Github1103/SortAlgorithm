package cn.codeyoung.sort;

import cn.codeyoung.utils.ArrayUtils;
import cn.codeyoung.utils.CompareUtils;
import cn.codeyoung.utils.GenArray;

import java.util.Arrays;

/**
 * @Data 15:46 2021/12/6
 * @Author ZhangJR
 * @Description 冒泡排序
 */
public class BubbleSort {
    /**
     * 对sort方法的封装，默认改变元素值，升序排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        return sort(arr,1,1);
    }

    /**
     *
     * @param array 数组
     * @param sort 升降序 升序1，降序0
     * @param change 是否改变原数组 1改变，0不改变
     * @return
     */
    public static int[] sort(int[] array,int sort,int change){
        int[] arr = ArrayUtils.copyArray(array,change);
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            //用来判断是否有发生交换，如果没有交换说明排序已经有序，则无需再排序直接退出即可
            boolean flag = true;
            for (int j = 0; j < len - i; j++) {
                if (CompareUtils.compare(arr[j],arr[j+1],sort)){
                    //交换位置
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println("Bubble Sort:");
        int[] arr = GenArray.createIntArr();
        GenArray.beforeSort(arr);
        BubbleSort.sort(arr);
        GenArray.afterSort(arr);
    }
}
