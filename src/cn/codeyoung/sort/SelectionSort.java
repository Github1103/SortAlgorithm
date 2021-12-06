package cn.codeyoung.sort;

import cn.codeyoung.utils.ArrayUtils;
import cn.codeyoung.utils.CompareUtils;
import cn.codeyoung.utils.GenArray;

import java.util.Arrays;

/**
 * @Data 16:46 2021/12/6
 * @Author ZhangJR
 * @Description 选择排序
 */
public class SelectionSort {
    /**
     * 对排序的封装
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        return sort(arr,1,1);
    }

    /**
     *
     * @param array 数组
     * @param sort 升降序 1升 0降
     * @param change 是否改变原数组 1改变 0不改变
     * @return
     */
    public static int[] sort(int[] array,int sort,int change){
        int[] arr = ArrayUtils.copyArray(array,change);
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int maxOrMin = i;
            for (int j = i+1; j < len; j++) {
                if (CompareUtils.compare(arr[maxOrMin],arr[j],sort)){
                    maxOrMin = j;
                }
            }
            if (i!=maxOrMin){
                int temp = arr[maxOrMin];
                arr[maxOrMin] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Selection Sort:");
        int[] intArr = GenArray.createIntArr();
        GenArray.beforeSort(intArr);
        SelectionSort.sort(intArr);
        GenArray.afterSort(intArr);
    }
}
