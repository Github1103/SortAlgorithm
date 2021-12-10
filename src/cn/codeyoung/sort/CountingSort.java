package cn.codeyoung.sort;

import cn.codeyoung.utils.GenArray;
import com.sun.org.apache.xerces.internal.impl.dtd.DTDGrammarBucket;

import java.util.Arrays;

/**
 * @Data 17:19 2021/12/9
 * @Author ZhangJR
 * @Description CountingSort 必须是有确定的取值范围的，因为GenArray的随机数生成只生成0-100，这里就只默认创建按0-100的版本，没有普用性，
 *                             一般基数排序都是临时写的，比如要对字母进行统计排序什么的。leetcode：748
 *
 */
public class CountingSort {
    /**
     * 整合counting sort
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        return sort(arr,1,1);
    }

    /**
     * 封装
     * @param array
     * @param sort 1升序，0降序
     * @param change 1改变对象，0不改变原对象
     * @return
     */
    public static int[] sort(int[] array,int sort,int change){
        if (change == 1){
            return countingSort(array,sort);
        }else {
            int[] arr = Arrays.copyOf(array,array.length);
            return countingSort(arr,sort);
        }
    }

    private static int[] countingSort(int[] arr, int sort) {
        int[] bucket = new int[100];

        for (int i : arr) {
            bucket[i]++;
        }
        //升序
        if (sort == 1){
            int sortIndex = 0;
            for (int j = 0; j < 100; j++) {
               while (bucket[j] > 0){
                   arr[sortIndex++] = j;
                   bucket[j]--;
               }
            }
        }else {
            int sortIndex = arr.length-1;
            for (int i = 0; i < 100; i++) {
                while (bucket[i] > 0){
                    arr[sortIndex--] = i;
                    bucket[i]--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Counting Sort:");
        int[] arr = GenArray.createIntArr();
        GenArray.beforeSort(arr);
        CountingSort.sort(arr);
        GenArray.afterSort(arr);
    }

}
