package leetcode.p2021m08;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/5
 * @time 10:50 AM
 */
public class Solution802 {
    public Map<Integer, Boolean> reachable = new TreeMap<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans     = new ArrayList<>();
        boolean[]     visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                reachable.put(i, true);
            } else {
                if (!reachable.containsKey(i)) {
                    dfs(graph, i, visited);
                }
            }
        }

        for (int key : reachable.keySet()) {
            if (reachable.get(key)) {
                ans.add(key);
            }
        }

        return ans;
    }

    private boolean dfs(final int[][] graph, int start, boolean[] visited) {
        if (graph[start].length == 0) {
            return true;
        }

        int[]   nextList = graph[start];
        boolean flag     = true;
        visited[start] = true;
        for (int nextId : nextList) {
            if (visited[nextId]) {
                flag = false;
                break;
            } else {
                if (!reachable.containsKey(nextId)) {
                    flag = dfs(graph, nextId, visited);
                } else {
                    flag = reachable.get(nextId);
                }
                if (!flag) {
                    break;
                }
            }
        }
        reachable.put(start, flag);
        visited[start] = false;
        return flag;
    }

    public static void main(String[] args) {
        Solution802   solution802 = new Solution802();
        List<Integer> ans         = solution802.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
        System.out.println(ans);
    }
}
