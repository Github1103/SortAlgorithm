package cn.codeyoung.sort;

import cn.codeyoung.utils.ArrayUtils;
import cn.codeyoung.utils.CompareUtils;
import cn.codeyoung.utils.GenArray;

/**
 * @Data 17:21 2021/12/6
 * @Author ZhangJR
 * @Description
 */
public class InsertionSort {

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
     * @param sort 升降序 1升 0降
     * @param change 是否改变原数组 1改变 0不改变
     * @return
     */
    public static int[] sort(int[] array,int sort,int change){
        int[] arr = ArrayUtils.copyArray(array,change);
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            //记录要插入的数据
            int temp = arr[i];
            int j = i;
            while (j>0 && CompareUtils.compare(arr[j-1],temp,sort)){
                arr[j] = arr[j-1];
                j--;
            }
            if(j!=i){
                arr[j] = temp;
            }
        }
        return arr;
    }

    /**
     * 使用拆半插入优化比较次数
     * @param array 数组
     * @param sort 升降序 1升 0降
     * @param change 是否改变原数组
     * @return
     */
    public static int[] binarySort(int[] array,int sort,int change){
        int[] arr =  ArrayUtils.copyArray(array,change);
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            //记录要插入的数据
            int temp = arr[i];
            int l = 0,r = i-1,m;
            while (r>=l){
                m = l + ((r-l)>>1);
                if (CompareUtils.compare(temp,arr[m],sort)){
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
            for (int j = i; j >= l+1; j--) {
                arr[j] = arr[j-1];
            }
            arr[l] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Insertion Sort:");
        int[] arr =  GenArray.createIntArr();
        GenArray.beforeSort(arr);
        int[] array = InsertionSort.binarySort(arr,1,0);
        InsertionSort.sort(arr);
        GenArray.afterSort(array);
        GenArray.afterSort(arr);
    }
}
