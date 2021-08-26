package leetcode.p2021m08;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/25
 * @time 9:37 AM
 */
public class Solution797 {
    List<List<Integer>> pathList = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        dfs(graph, 0, graph.length - 1, new ArrayList<>());
        return pathList;
    }

    private void dfs(int[][] graph, int start, final int end, List<Integer> data) {
        if (start == end) {
            List<Integer> temp = new ArrayList<>();
            for (int item : data) {
                temp.add(item);
            }
            temp.add(end);
            pathList.add(temp);
            return;
        }

        data.add(start);
        for (int i = 0; i < graph[start].length; i++) {
            dfs(graph, graph[start][i], end, data);
        }
        data.remove(data.size() - 1);
    }

    public static void main(String[] args) {
        Solution797 solution797 = new Solution797();
        System.out.println(solution797.allPathsSourceTarget(new int[][]  {{1,2,3},{2},{3},{}}));
    }
}
