package whu.hydro.algorithm.string;

/**
 * @ClassName kmp
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/13 19:05
 * @Version 1.0
 */
public class kmp {


    void makeNext(final char P[],int next[])
    {
        int q,k;
        int m = P.length;
        next[0] = 0;
        for (q = 1,k = 0; q < m; ++q)
        {
            while(k > 0 && P[q] != P[k])
                k = next[k-1];
            if (P[q] == P[k])
            {
                k++;
            }
            next[q] = k;
        }
    }


    public int findSubString(String a, String b) {
        if (a==null || b==null || b.length()==0 || a.length()<b.length()){
            return -1;
        }
        int[] next = new int[b.length()];
        makeNext(b.toCharArray(), next);
        int subPoint = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i)==b.charAt(subPoint)){
                subPoint++;
            } else if (subPoint!=0) {
                subPoint = next[subPoint-1];
                i--;
            }

            if (subPoint==b.length()) {
                return i-subPoint+1;
            }
        }
        return -1;
    }

    int[] makeNext(char[] ms) {
        int[] next = new int[ms.length];
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos-1]==ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn>0){
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public int findSubString2(String a, String b) {
        if (a==null || b==null || b.length()==0 || a.length()<b.length()){
            return -1;
        }
        int[] next = makeNext(b.toCharArray());
        int ai = 0, bi = 0;
        while (ai<a.length() && bi<b.length()) {
            if (a.charAt(ai)==b.charAt(bi)) {
                ai++; bi++;
            } else {
                if(bi==0) ai++;
                bi = next[bi];
            }
        }



        return bi==b.length()?ai-bi:-1;
    }

    public static void main(String[] args) {
        kmp k = new kmp();
        String a = "BCC ABCDAB ABCDABCDABDE";
        String b = "ABCDABD";
        System.out.println(k.findSubString2(a,b));

        String s = "ABAABA";
        int[] next = new int[s.length()];

        k.makeNext(s.toCharArray(), next);

        for (int i = 0; i < next.length; i++) {
            System.out.printf(next[i]+" ");
        }

        System.out.println();

        next = k.makeNext(s.toCharArray());

        for (int i = 0; i < next.length; i++) {
            System.out.printf(next[i]+" ");
        }

    }
}
