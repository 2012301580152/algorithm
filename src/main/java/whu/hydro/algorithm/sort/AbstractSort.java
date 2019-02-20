package whu.hydro.algorithm.sort;

/**
 * @ClassName AbstractSort
 * @Description TODO
 * @Author 86187
 * @Date 2019/2/18 20:47
 * @Version 1.0
 */
public abstract class AbstractSort {
    public abstract void sort(Comparable[] a);

    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }

    protected void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }


}
