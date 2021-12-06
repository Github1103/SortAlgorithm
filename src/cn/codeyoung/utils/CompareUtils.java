package cn.codeyoung.utils;

/**
 * @Data 16:55 2021/12/6
 * @Author ZhangJR
 * @Description
 */
public class CompareUtils {
    /**
     * 对比确定冒泡排序的顺序
     * @param a
     * @param b
     * @param sort
     * @return
     */
    public static boolean compare(int a,int b,int sort){
        if (sort == 1){
            return a>b;
        }else {
            return a<b;
        }
    }
}
