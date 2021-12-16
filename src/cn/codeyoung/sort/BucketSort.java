package cn.codeyoung.sort;

import cn.codeyoung.utils.GenArray;
import javafx.scene.control.TableView;

import javax.swing.*;
import java.util.Arrays;

/**
 * @Data 17:26 2021/12/10
 * @Author ZhangJR
 * @Description 桶排序
 */
public class BucketSort {

    public static int[] sort(int[] arr){
        return sort(arr,1,1);
    }

    public static int[] sort(int[] array,int sort,int change){
        if (change == 1){
            return bucketSort(array,sort);
        }else {
            int[] arr = Arrays.copyOf(array,array.length);
            return bucketSort(arr,sort);
        }
    }

    private static int[] bucketSort(int[] arr,int sort){
        if (arr.length == 0){
            return arr;
        }

        int bucketSize = arr.length;

        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue){
                maxValue = arr[i];
            }
            if (arr[i] < minValue){
                minValue = arr[i];
            }
        }
        //通过这个函数创建映射的桶数量
        int bucketNum =(int)Math.floor((maxValue-minValue)/bucketSize)+ 1;
        int[][] buckets = new int[bucketNum][0];

        //映射
        for (int i = 0; i < bucketSize; i++) {
            //通过这个映射函数将数放入不同的桶中，如果离散度不够均匀，那么就要考虑其他的映射方法。
            int index = (int) Math.floor((arr[i]-minValue)/bucketSize);
            buckets[index] = arrAppend(buckets[index],arr[i]);
        }

        int sortIndex;
        if ( sort == 1) {
            sortIndex = 0;
        }else {
            sortIndex = arr.length - 1;
        }
        for (int[] bucket : buckets) {
            if (bucket.length == 0 ){
                continue;
            }
            InsertionSort.sort(bucket);
            for (int i : bucket) {
                if (sort == 1){
                    arr[sortIndex++] = i;
                }else {
                    arr[sortIndex--] = i;
                }
            }
        }
        return arr;
    }

    private static int[] arrAppend(int[] arr,int value){
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1] = value;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Bucket Sort:");
        int[] arr = GenArray.createIntArr();
        GenArray.beforeSort(arr);
        BucketSort.sort(arr);
        GenArray.afterSort(arr);
    }
}
