package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/21
 * @time 8:13 PM
 */
public class Solution797 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        visited = new boolean[graph.length];

        List<Integer> data = new ArrayList<>();
        data.add(0);
        dfs(graph, 0, graph.length - 1, data);
        return ans;
    }

    private void dfs(int[][] graph, int start, final int end, List<Integer> list) {
        if (start == end) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < graph[start].length; i++) {
            int index = graph[start][i];
            if (visited[index]) {
                continue;
            }
            list.add(index);
            visited[index] = true;
            dfs(graph, index, end, list);
            visited[index] = false;
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[][]             array       = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        Solution797         solution797 = new Solution797();
        List<List<Integer>> ans         = solution797.allPathsSourceTarget(array);
        System.out.println(ans);
    }
}
