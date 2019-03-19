package whu.hydro.algorithm.solution;

import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/9 10:54
 * @Version 1.0
 */
public class Solution {
    public static void main01(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Set set = new HashSet();
        for (int i = 0; i < N; i++) {
            set.add(in.nextInt());
        }
        for (int i = 0; i < N-1; i++) {
            set.remove(in.nextInt());
        }
        System.out.println(set.iterator().next());
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static int[] duplicate(int[] nums) {
        if (nums==null || nums.length==0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i]>nums.length-1){
                return null;
            }
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i && nums[i]!=-1) {
                if(nums[nums[i]]==nums[i]) {
                    set.add(nums[i]);
                    nums[i] = -1;
                } else {
                    exch(nums, i, nums[i]);
                }
            }
        }
        int[] duplication =  new int[set.size()];
        int i = 0;
        for (int key:set) {
            duplication[i++] = key;
        }
        return duplication;
    }

    static int[] dp;
    static void setDp(int n) {
        if (dp[n]==0){
            dp[n] = getStep(n);
        }
    }

    static int getStep(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
       setDp(n-1);
       setDp(n-2);
        return dp[n-1]+dp[n-2];
    }
    static int getStepDp(int n) {
        dp = new int[n];
        return getStep(n);
    }

    static int getAC(int m, int n) {
        int result = 1;
        if (n>m) {
            int temp = n;
            n = m;
            m = temp;
        }
        for (int i = m+1; i < m+n+1; i++) {
            result *= i;
        }
        for (int i = 2; i <= n; i++) {
            result /= i;
        }
        return result;
    }

    static int getStepAC(int n) {
        int result = 0;
        for (int i = 0; i <= n/2; i++) {
            result += getAC(i, n-2*i);
        }
        return result;
    }


    static int getStepMath(int n) {
        double sqrt5 = Math.sqrt(5);
        double left = (1.0 + sqrt5)/2.0;
        double right = (1.0- sqrt5)/2.0;
        return (int)Math.round(Math.pow(left, n+1)/sqrt5);
    }

    public static void main(String[] args) {
//        int[] arr = {3,2,5,4,2,5,3};
//        int[] result = duplicate(arr);
//
//
//        Arrays.stream(result).forEach(System.out::println);
//        System.out.println(result);

        System.out.println(getStepAC(26));

        System.out.println(getStepDp(66));

        System.out.println(getStepMath(66));

    }
}
