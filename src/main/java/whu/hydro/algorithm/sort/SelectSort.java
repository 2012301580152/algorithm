package whu.hydro.algorithm.sort;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author 86187
 * @Date 2019/2/18 20:43
 * @Version 1.0
 */
public class SelectSort extends AbstractSort {
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a,i,min);
        }
    }
}
