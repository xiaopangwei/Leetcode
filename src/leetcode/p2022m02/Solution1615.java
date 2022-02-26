package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/24
 * @time 1:19 PM
 */
public class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[]       adj   = new int[n];
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < roads.length; i++) {
            adj[roads[i][0]]++;
            adj[roads[i][1]]++;
            graph[roads[i][0]][roads[i][1]] = true;
            graph[roads[i][1]][roads[i][0]] = true;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int gap = graph[i][j] || graph[j][i] ? 1 : 0;
                maxVal = Math.max(maxVal, adj[i] + adj[j] - gap);
            }
        }
        return maxVal;
    }
}
