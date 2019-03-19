package whu.hydro.algorithm.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Solution20190314
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/14 16:02
 * @Version 1.0
 */
public class Solution20190314 {

    private static boolean isOdd(int a) {
        return (a&1)==1;
    }
    public static void foo(List<Integer> list) {
        if (list==null || list.size()==0) return;
        boolean hasPrintFirst = false;
        for (int l:list) {
            if (isOdd(l)) {
                if (hasPrintFirst){
                    System.out.print(","+l);
                }else {
                    System.out.print(l);
                    hasPrintFirst = true;
                }

            }
        }
    }

    public static int search(List<Integer> list, int key) {
        if (list==null || list.size()==0) return -1;
        int result = -1;
        int left = 0;
        int right = list.size()-1;
        int mid;
        while (left<right) {
            mid = (left + right)/2;
            if(key == list.get(mid)){
                result = mid;
                break;
            }else if(key < list.get(mid)) {
                right = mid;
            }else {
                left = mid;
            }
        }
        if (result==-1) {
            return -1;
        } else {
            for (int i = result-1; i >= 0; i--) {
                if (list.get(i)==list.get(result)){
                    result = i;
                } else {
                    break;
                }
            }
            return result;
        }
    }           



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String arrStr = in.nextLine();
        String[] arr = arrStr.split(",");
        arr[0] = arr[0].substring(1);
        arr[arr.length-2] = arr[arr.length-2].substring(0,arr[arr.length-2].length()-1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            list.add(Integer.valueOf(arr[i]));
        }
        int key = Integer.valueOf(arr[arr.length-1]);
        System.out.println(search(list, key));



//        Solution20190314 s = new Solution20190314();
//        Integer[] test = {1,2,3,4,6};
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//
//        list.add(7);
//        list.add(-1);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);list.add(4);
////        s.foo(list);
//
//        System.out.println(s.search(list, 3));
//        ;



    }


}
