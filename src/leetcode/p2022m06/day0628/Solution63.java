package leetcode.p2022m06.day0628;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/4
 * @time 10:47 PM
 */
public class Solution63 {
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, 0, obstacleGrid);
    }


    private int dfs(int x, int y, int[][] obstacleGrid) {


        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return 1;
        }


        int ans = dfs(x + 1, y, obstacleGrid) + dfs(x, y + 1, obstacleGrid);
        dp[x][y] = ans;
        return ans;
    }

}
