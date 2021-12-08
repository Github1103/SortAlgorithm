package cn.codeyoung.sort;

import cn.codeyoung.utils.ArrayUtils;
import cn.codeyoung.utils.CompareUtils;
import cn.codeyoung.utils.GenArray;
import com.sun.org.apache.bcel.internal.generic.MethodGen;
import sun.util.resources.cldr.ga.CurrencyNames_ga;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Data 11:53 2021/12/8
 * @Author ZhangJR
 * @Description
 */
public class MergeSort {

    public static int[] RSort(int[] arr){
        return recursionSort(arr,1);
    }

    public static int[] ISort(int[] arr){
        return iterationSort(arr,1,1);
    }

    /**
     * 是否改变原数组
     * @param arr
     * @return
     */
    public static int[] localSort(int[] arr){
        int[] sort = recursionSort(arr,1);
        for (int i = 0; i < sort.length; i++) {
            arr[i] = sort[i];
        }
        return arr;
    }

    /**
     * 使用递归的方法进行进行排序
     * @param array 排序数组
     * @param sort 1升序，0降序
     * 默认改变原数组,因为是开辟新空间
     * @return
     */
    public static int[] recursionSort(int[] array,int sort){
        //分割为1的时候就不用排序了
        if (array.length < 2){
            return array;
        }
        int m = 0 + (array.length>>1);
        int[] arrL = Arrays.copyOfRange(array,0,m);
        int[] arrR = Arrays.copyOfRange(array,m,array.length);
        return merge(recursionSort(arrL,sort),recursionSort(arrR,sort),sort);
    }

    private static int[] merge(int[] arrL, int[] arrR,int sort) {
        int lenL = arrL.length,lenR = arrR.length;
        int[] result = new int[lenL+lenR];
        //左右游标用来代替指针
        int cursorL = 0,cursorR = 0;
        int index = 0;
        while (cursorL<lenL && cursorR <lenR){
            if (CompareUtils.compare(arrL[cursorL],arrR[cursorR],sort)){
                result[index++] = arrR[cursorR];
                cursorR++;
            }else{
                result[index++] = arrL[cursorL];
                cursorL++;
            }
        }
        while (cursorL < lenL){
            result[index++] = arrL[cursorL];
            cursorL++;
        }
        while (cursorR < lenR){
            result[index++] = arrR[cursorR];
            cursorR++;
        }
        return result;
    }

    /**
     * 用循环的方法，对对象进行归并排序
     * @param array 数组
     * @param sort 排序 1 升，0 降
     * @param change 是否改变，原数组
     * @return
     */
    public static int[] iterationSort(int[] array,int sort,int change){
        int[] arr = ArrayUtils.copyArray(array,change);
        //定义左指针，右指针
        int cursorL,cursorR;
        //可变数组用于存储顺序值。
        List<Integer> list = new ArrayList<>();
        //自下向上，则一开始是2个比较，再然后是4个，再然后是8个
        int len = arr.length;
        for(int i = 1;i<len;i<<=1){
            cursorL = 0;
            cursorR = 0+i;
            while (cursorR<len){
                int maxL = cursorL+i;
                int maxR = cursorR+i;
                if (maxR >= len){
                    maxR = len;
                }
                //普通的归并过程
                while (cursorL<maxL&&cursorR<maxR){
                    if (CompareUtils.compare(arr[cursorL],arr[cursorR],sort)){
                        list.add(arr[cursorR++]);
                    }else {
                        list.add(arr[cursorL++]);
                    }
                }
                while (cursorL<maxL){
                    list.add(arr[cursorL++]);
                }
                while (cursorR<maxR){
                    list.add(arr[cursorR++]);
                }
                //准备转移过程
                Integer[] result = new Integer[list.size()];
                list.toArray(result);
                list.clear();
                //更新指针坐标
                cursorL = maxR;
                cursorR = cursorL + i;
                //移入回原数组
                int length =  result.length;
                while (length>0){
                    arr[--maxR] = result[--length];
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println("Merge Sort:");
        int[] arr = GenArray.createIntArr();
        GenArray.beforeSort(arr);
        MergeSort.ISort(arr);
        GenArray.afterSort(arr);
    }

}
