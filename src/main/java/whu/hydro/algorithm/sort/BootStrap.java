package whu.hydro.algorithm.sort;

import whu.hydro.algorithm.io.StdRandom;

/**
 * @ClassName BootStrap
 * @Description TODO
 * @Author 86187
 * @Date 2019/2/18 20:51
 * @Version 1.0
 */
public class BootStrap {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);   // 取消对输入的依赖
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1,hi);
    }
    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi;
        Comparable v = a[lo];
        while (true) {

        }
    }
    public static void main(String[] args) {

        String[] a = {"sd","sdsd", "xa", "aeygd", "wrety"};
        SelectSort selectSort = new SelectSort();

        selectSort.sort(a);
        selectSort.show(a);
    }
}
