package cn.codeyoung.sort;

import cn.codeyoung.utils.ArrayUtils;
import cn.codeyoung.utils.CompareUtils;
import cn.codeyoung.utils.GenArray;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import jdk.nashorn.tools.Shell;

import java.net.StandardProtocolFamily;

/**
 * @Data 11:26 2021/12/8
 * @Author ZhangJR
 * @Description
 */
public class ShellSort {

    /**
     * 对排序的封装
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        return sort(arr,1,1);
    }

    /**
     * 使用拆半插入优化比较次数
     * @param array 数组
     * @param sort 升降序 1升 0降
     * @param change 是否改变原数组
     * @return
     */
    public static int[] sort(int[] array,int sort,int change){
        int[] arr = ArrayUtils.copyArray(array,sort);
        int len = arr.length;
        for (int step = len/2; step>=1; step/=2){
            for (int i = step;i<len;i++){
                int temp = arr[i];
                int j = i - step;
                while (j>=0 && CompareUtils.compare(arr[j],temp,sort)){
                    arr[j+step] = arr[j];
                    j -= step;
                }
                arr[j+step] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Shell's Sort:");
        int[] arr =  GenArray.createIntArr();
        GenArray.beforeSort(arr);
        int[] array = ShellSort.sort(arr, 0, 0);
        ShellSort.sort(arr);
        GenArray.afterSort(array);
        GenArray.afterSort(arr);
    }
}
