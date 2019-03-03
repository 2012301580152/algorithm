package whu.hydro.algorithm.graph.digraph;

import whu.hydro.algorithm.io.StdOut;

/**
 * @ClassName Topological
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/3 13:13
 * @Version 1.0
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }



    public static void main(String[] args) {
        String filename = "datas/jobs.txt";
        String separator = "/";
        SymbolDigraph sg = new SymbolDigraph(filename, separator);

        Topological top = new Topological(sg.G());

        for (int v : top.order()) {
            StdOut.println(sg.name(v));
        }
    }
}
