package whu.hydro.algorithm.graph.digraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName TopologicalT
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/3 14:49
 * @Version 1.0
 */
public class TopologicalT {
    private Map<Integer, Boolean> onStack;
    private Map<Integer, Boolean> marked;
    private Map<Integer, Integer> keys;
    private boolean hasCycle;

    boolean dependAnalysis(int[][] arr) {
        onStack = new HashMap<>();
        marked = new HashMap<>();
        keys = new HashMap<>();
        hasCycle = false;
        for (int i = 0; i < arr.length; i++) {
            keys.put(arr[i][0], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!marked.containsKey(arr[i][0])){
                dfs(arr, i);
            }
        }
        return hasCycle;
    }

    private void dfs(int[][] arr, int i) {
        marked.put(arr[i][0], true);
        onStack.put(arr[i][0], true);

        for (int w = 1; w < arr[i].length; w++) {
            if (arr[i][w]!= arr[i][0]) {
                if (!marked.containsKey(arr[i][w])) {
                    if (keys.containsKey(arr[i][w])) {
                        dfs(arr, keys.get(arr[i][w]));
                    }
                } if (onStack.containsKey(arr[i][w])) {
                    hasCycle = true;
                    return;
                }
            }
        }
        onStack.remove(arr[i][0]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,2,3},{2,3,4},{3,4,5,3}};
        TopologicalT t = new TopologicalT();
        System.out.println(t.dependAnalysis(arr));
    }
}
