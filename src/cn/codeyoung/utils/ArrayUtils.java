package cn.codeyoung.utils;

import java.util.Arrays;

/**
 * @Data 17:30 2021/12/6
 * @Author ZhangJR
 * @Description
 */
public class ArrayUtils {
    public static int[] copyArray(int[] array,int change){
        if (change == 0){
            return Arrays.copyOf(array,array.length);
        }else {
            return array;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
