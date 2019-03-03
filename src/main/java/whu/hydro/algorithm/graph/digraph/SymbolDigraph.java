package whu.hydro.algorithm.graph.digraph;

import whu.hydro.algorithm.graph.Graph;
import whu.hydro.algorithm.io.In;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SymbolDigraph
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/3 13:34
 * @Version 1.0
 */
public class SymbolDigraph {
    private Map<String, Integer> st;
    private String[] keys;
    private Digraph G;

    public SymbolDigraph(String stream, String sp) {
        st = new HashMap<>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.containsKey(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name: st.keySet()) {
            keys[st.get(name)] = name;
        }

        G = new Digraph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);

            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.containsKey(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Digraph G() {
        return G;
    }
}
