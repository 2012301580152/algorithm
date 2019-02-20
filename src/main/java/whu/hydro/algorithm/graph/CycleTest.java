package whu.hydro.algorithm.graph;

import whu.hydro.algorithm.base.Stack;
import whu.hydro.algorithm.io.In;
import whu.hydro.algorithm.io.StdOut;

/**
 * @ClassName CycleTest
 * @Description TODO
 * @Author 86187
 * @Date 2019/2/19 15:10
 * @Version 1.0
 */
public class CycleTest {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
//    private boolean hasCycle;

    public CycleTest(Graph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i, -1);
            }
        }
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;



        for (int w : G.adj(v)) {
            if (cycle != null) return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w, v);
            } else if (w != u) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public boolean hasCycle() {
        return cycle!=null;
    }

    public static void main(String[] args) {
        args = new String[2];
        args[0] = "datas/tinyCG.txt";
        In in = new In(args[0]);
        Graph G = new Graph(in);
        CycleTest finder = new CycleTest(G);
        if (finder.hasCycle()) {
            for (int c:finder.cycle()) {
                StdOut.print(c+" ");
            }
            StdOut.println();
        }
        else {
            StdOut.println("Graph is acyclic");
        }
    }
}
