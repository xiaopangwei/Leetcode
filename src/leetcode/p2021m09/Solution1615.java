package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/13
 * @time 9:26 PM
 */
public class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[][] matrix = new int[n][n];
        int[]   cnt    = new int[n];
        for (int i = 0; i < roads.length; i++) {
            int start = roads[i][0];
            int end   = roads[i][1];
            matrix[start][end] = 1;
            cnt[start]++;

            matrix[end][start] = 1;
            cnt[end]++;

        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                max = Math.max(max, cnt[i] + cnt[j] - matrix[i][j]);
            }
        }


        return max;
    }

    public static void main(String[] args) {
        Solution1615 solution1615 = new Solution1615();
        int          ans          = solution1615.maximalNetworkRank(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}});
        System.out.println(ans);
    }
}
