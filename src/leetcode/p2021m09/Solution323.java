package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/4
 * @time 3:27 PM
 */
public class Solution323 {

    public int countComponents(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        int       count   = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, i, edges);
                count++;
            }

        }

        return count;

    }


    private void dfs(boolean[] visited, int start, int[][] edges) {

        visited[start] = true;

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == start && !visited[edges[i][1]]) {
                dfs(visited, edges[i][1], edges);
            } else if (edges[i][1] == start && !visited[edges[i][0]]) {
                dfs(visited, edges[i][0], edges);
            }
        }
    }

    public static void main(String[] args) {
        Solution323 solution323 = new Solution323();
        int         res         = solution323.countComponents(2, new int[][]{{1, 0}});
        System.out.println(res);
    }
}
