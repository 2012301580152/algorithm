package whu.hydro.algorithm.graph.digraph;

import whu.hydro.algorithm.base.Bag;

/**
 * @ClassName Digraph
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/3 12:43
 * @Version 1.0
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w: adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
