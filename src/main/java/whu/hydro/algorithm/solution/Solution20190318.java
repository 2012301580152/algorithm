package whu.hydro.algorithm.solution;

import whu.hydro.algorithm.base.Stack;

/**
 * @ClassName Solution20190318
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/18 19:28
 * @Version 1.0
 */
public class Solution20190318 {

    private void reverse(int[] A, int point, int K) {
        for(int i = point; i <point+K; i++) {
            A[i] ^= 1;
        }
    }

    public int minKBitFlips(int[] A, int K) {
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i]==0) {
                if(A.length-i<K) {
                    return -1;
                }
                reverse(A, i, K);
                result++;
            }
        }
        return result;
    }

    public int bulbSwitch(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n>0) {
            stack.push(n&3);
            n >>= 2;
        }
        int result = 0;
        int remain = 0;
        while (!stack.isEmpty()) {
            remain = (remain<<2)+stack.pop();
            if (remain>=(result<<2)+1){
                remain -= (result<<2)+1;
                result = (result<<1)+1;
            } else {
                result <<=1;
            }
        }
        Math.sqrt(23);
        return result;

    }



    public static void main(String[] args) {
        Solution20190318 s = new Solution20190318();
        int[] arr = {0,1,0};
        int k = 2;
        s.minKBitFlips(arr, k);
        System.out.println(s.bulbSwitch(127));
    }
}
