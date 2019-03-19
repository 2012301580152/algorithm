package whu.hydro.algorithm.solution;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName Main0316
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/16 10:02
 * @Version 1.0
 */
public class Main0316 {

    private static int getCounts(int num) {

        int result = 0;
        for (int i = 3; i >= 0 && num!=0; i--) {
            result += num/(1<<(2*i));
            num %= 1<<(2*i);
        }

        return result;

    }

    public static void main01(String[] args) {
        Scanner in = new Scanner(System.in);
//        int N = 200;
        int N = in.nextInt();
        System.out.println(getCounts(1024-N));

    }

    private static String modify(String s) {
        if (s==null) return null;
        if (s.length()==0) return "";

        int point = 1;
        StringBuffer result = new StringBuffer();
        char tail = s.charAt(0);
        result.append(tail);
        boolean first = false;
        boolean second = false;

        while (point<s.length()) {
            if (first) {
                if (s.charAt(point)==tail){
                    point++;
                } else  {
                    if (point==s.length()-1){
                        result.append(s.charAt(point));
                        break;
                    }else if (s.charAt(point+1)==s.charAt(point+2)){
                        tail = s.charAt(point++);
                        result.append(tail);
                        second = true;
                        first = false;
                    }

                }
            }else if (second) {
                if(s.charAt(point)==tail) {
                    point++;
                }
            } else {
                if(s.charAt(point)==tail) {
                    tail = s.charAt(point++);
                    result.append(tail);
                    first =true;
                    point++;
                } else {
                    tail = s.charAt(point++);
                    result.append(tail);


                }
            }

        }
        return result.toString();
    }

    public static void main02(String[] args) {
        Scanner in = new Scanner(System.in);
//        int N = 200;
        int N = Integer.valueOf(in.nextLine());
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            System.out.println(modify(in.nextLine()));
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int N = 200;
        int N = in.nextInt();
        int M = in.nextInt();
        double[] values = new double[N];
//        int[] values = {4,2,1,3,5,8};
        for (int i = 0; i < N; i++) {
            values[i]=in.nextDouble();
        }
        Queue<Double> integerPriorityQueue = new PriorityQueue<>(M);

        Queue<Double> MaxIntegerPriorityQueue = new PriorityQueue<Double>(M, new Comparator<Double>() {

            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });


        integerPriorityQueue.add(values[0]);

        for (int i = 1; i < N; i++) {
            if(integerPriorityQueue.size()<M){
                integerPriorityQueue.add(values[i]);
                MaxIntegerPriorityQueue.add(values[i]);
            } else if(integerPriorityQueue.peek()<values[i]) {
                integerPriorityQueue.poll();
                integerPriorityQueue.add(values[i]);
            }
        }

        while (integerPriorityQueue.size()!=M){
            double temp = MaxIntegerPriorityQueue.poll();
            if (temp>integerPriorityQueue.peek()*2){
            int n = (int)(temp /MaxIntegerPriorityQueue.peek());
            integerPriorityQueue.remove(temp);

            for (int i = 0; i < n; i++) {
                integerPriorityQueue.add(temp/n);
                MaxIntegerPriorityQueue.add(temp/n);
            }


        }


        System.out.println(integerPriorityQueue.peek());

    }
}}
