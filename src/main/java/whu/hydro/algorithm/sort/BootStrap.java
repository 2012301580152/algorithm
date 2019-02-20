package whu.hydro.algorithm.sort;

/**
 * @ClassName BootStrap
 * @Description TODO
 * @Author 86187
 * @Date 2019/2/18 20:51
 * @Version 1.0
 */
public class BootStrap {
    public static void main(String[] args) {

        String[] a = {"sd","sdsd", "xa", "aeygd", "wrety"};
        SelectSort selectSort = new SelectSort();

        selectSort.sort(a);
        selectSort.show(a);
    }
}
