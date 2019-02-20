package whu.hydro.algorithm.sort;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author 86187
 * @Date 2019/2/18 20:54
 * @Version 1.0
 */
public class InsertSort extends AbstractSort{

    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j++) {
                exch(a, j, j-1);
            }
        }
    }
}
