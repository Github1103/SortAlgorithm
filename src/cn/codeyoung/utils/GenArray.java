package cn.codeyoung.utils;

import java.util.Random;

/**
 * @Data 15:47 2021/12/6
 * @Author ZhangJR
 * @Description 随机生成一个整数数组,工具
 */
public class GenArray {
    private static int NUM = 15;
    private static int RANGE = 100;

    /**
     * 随机生成一个整数数组
     * @return
     */
    public static int[] createIntArr(){
        int[] arr = new int[NUM];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < NUM; i++) {
            arr[i] = random.nextInt(RANGE);
        }
        return arr;
    }

    public static int[] createIntArr(int num,int range){
        int[] arr = new int[num];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < num; i++) {
            arr[i] = random.nextInt(range);
        }
        return arr;
    }

    /**
     * 随机生成一个浮点数数组
     * @return
     */
    public static double[] createDoubleArr(){
        double[] arr = new double[NUM];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < NUM; i++) {
            arr[i] = random.nextDouble()*RANGE;
        }
        return arr;
    }

    public static double[] createDoubleArr(int num,int range){
        double[] arr = new double[num];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < num; i++) {
            arr[i] = random.nextDouble()*range;
        }
        return arr;
    }

    /**
     * 输出排序前数组的演示
     * @param arr
     */
    public static void beforeSort(int[] arr){
        System.out.println("Before Sort:");
        printArr(arr);
    }

    /**
     * 输出排序后数组的演示
     * @param arr
     */
    public static void afterSort(int[] arr){
        System.out.println("After Sort:");
        printArr(arr);
    }

    /**
     * 打印数组
     * @param arr
     */
    private static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

}
