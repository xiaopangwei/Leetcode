package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/3
 * @time 10:36 PM
 */
public class Solution2373 {
    public int[][] largestLocal(int[][] grid) {
        int     n   = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans[i][j] = getMax(grid, i, 0);
            }
        }
        return ans;
    }

    private int getMax(int[][] g, int x, int y) {
        int max = Integer.MIN_VALUE;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                max = Math.max(max, g[i][y]);
            }
        }
        return max;
    }
}
