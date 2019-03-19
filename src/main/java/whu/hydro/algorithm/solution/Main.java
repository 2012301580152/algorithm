package whu.hydro.algorithm.solution;



import java.util.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/10 16:37
 * @Version 1.0
 */
public class Main {

    // 括号交叉匹配问题

    static int[][] dp;

    static private int getNums(int[] arr, int apoint, int[] b, int bpoint) {
        int result = 0;
        if (arr.length-1==apoint) {
            return 1;
        }
        if (b.length-1==bpoint) {
            for (int i = apoint; i < arr.length; i++) {
                if (arr[i]>=b[bpoint]) result++;
            }
            return result;
        }

        for (int i = apoint; i < arr.length; i++) {
            if (arr[i]>=b[bpoint]) {
                if (dp[i][bpoint+1]==0) {
                    dp[i][bpoint+1] = getNums(arr, i, b, bpoint+1);
                }else {
                    System.out.println(i+"==================="+(bpoint+1));
                }
                result += dp[i][bpoint+1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int[] aint = new int[a.length()+1];
        int[] bint = new int[b.length()+1];

        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)=='('){
                aint[i+1] = aint[i]+1;

            }else {
                aint[i+1] = aint[i]-1;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i)==')') {
                bint[i+1] = bint[i] + 1;
            } else {
                bint[i+1] = bint[i] - 1;
            }
        }

        if (aint[aint.length-1]!=bint[bint.length-1]) {
            System.out.println(0);
            return;
        }

        dp = new int[aint.length][bint.length];

        System.out.println(getNums(aint, 0, bint, 1));

    }



    public static void main02(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] schar = s.toCharArray();
        char min = 'z';
        for (int i = 0; i < schar.length; i++) {
            if (schar[i]<'a') {
                schar[i] += 32;
            }
            min = min<schar[i]?min:schar[i];
        }

        System.out.println(min);
    }

    static class Bank implements Comparable<Bank>{
        int position;
        int value;
        @Override
        public int compareTo(Bank o) {
            return ((Integer)this.value).compareTo(o.value);
        }
    }

    static int getDistance(Bank a, Bank b) {
        return Math.abs(a.position - b.position);

    }

    static int getValue(Bank a, Bank b) {
        return a.value + b.value;

    }
    public static void main03(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        Bank[] banks = new Bank[n];
        for (int i = 0; i < n; i++) {
            banks[i] = new Bank();
            banks[i].position = in.nextInt();
            banks[i].value = in.nextInt();
        }
        Arrays.sort(banks);
        int maxValue = 0;
        for (int i = n-1; i >0 ; i--) {
            if (maxValue>getValue(banks[i], banks[i-1])) {
                break;
            }
            for (int j = n-2; j >= 0; j--) {
                if (maxValue>getValue(banks[i], banks[j])) {
                    break;
                }
                if(getDistance(banks[i], banks[j]) >= d) {
                    int temp = getValue(banks[i], banks[j]);
                    maxValue = maxValue > temp?maxValue:temp;
                }
            }
        }
        System.out.println(maxValue);
    }



    public static void main01(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int sum = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            sum+=a[i]*b[n-i-1];
        }
        System.out.println(sum);
    }



    public static void main021(String args[]){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        HashMap<Character,Integer> map = new HashMap<>();
        Set<Character> set = new TreeSet<>();
        for (int i=0;i<str.length();i++){
            char chr = str.charAt(i);
            if (chr >= 'A'){
                chr = Character.toLowerCase(chr);
            }
            if (map.containsKey(chr)){
                map.put(chr,2);
            }else {
                map.put(chr,1);
            }
        }
        char minchar = 'z';
        for (int i=0;i<str.length();i++){
            char chr = str.charAt(i);
            if (chr >= 'A'){
                chr = Character.toLowerCase(chr);
            }
            if (map.get(chr) == 1){
                if (chr < minchar){
                    minchar = chr;
                }
                break;
            }else {
                if (chr < minchar){
                    minchar = chr;
                }
                if (set.contains(chr)){
                    break;
                }
            }
            set.add(chr);
        }
        System.out.println(minchar);
    }

}
