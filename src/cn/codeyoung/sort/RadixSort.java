package cn.codeyoung.sort;

import cn.codeyoung.utils.GenArray;

import java.util.Arrays;

/**
 * @Data 11:12 2021/12/12
 * @Author ZhangJR
 * @Description
 */
public class RadixSort {

    public static int[] sort(int[] arr){
        return sort(arr,1,1);
    }

    public static int[] sort(int[] array,int sort,int change){
        if(change == 1){
            return radixSort(array,sort);
        }else {
            int[] arr = Arrays.copyOf(array,array.length);
            return radixSort(arr,sort);
        }
    }

    private static int MaxDigit(int[] arr){
        int num =  MaxNum(arr);
        if (num == 0) return 1;
        int length = 0;
        for (;num!=0;num/=10){
            length++;
        }
        return length;
    }

    private static int MaxNum(int[] arr){
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxNum){
                maxNum = arr[i];
            }
        }
        return maxNum;
    }

    private static int[] radixSort(int[] array, int sort) {
        int maxDigit = MaxDigit(array);
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++,dev*=10,mod*=10) {
            int[][] count = new int[mod*2][0];
            for (int j = 0; j < array.length; j++) {
                int bucket = (array[j]%mod)/dev + mod;
                count[bucket] = arrAppend(count[bucket],array[j]);
            }
            if (sort == 1){
                int index = 0;
                for (int[] bucket : count) {
                    for (int num : bucket) {
                        array[index++] = num;
                    }
                }
            }else {
                int index = array.length-1;
                for (int[] bucket : count) {
                    for (int j = bucket.length-1; j >=0 ; j--) {
                        array[index--] = bucket[j];
                    }
                }
            }
        }
        return array;
    }

    private static int[] arrAppend(int[] arr,int value){
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1] = value;
        return arr;
    }


    public static void main(String[] args) {
        System.out.println("Radix Sort:");
        int[] arr = GenArray.createIntArr();
        GenArray.beforeSort(arr);
        RadixSort.sort(arr,0,1);
        GenArray.afterSort(arr);
    }


}
