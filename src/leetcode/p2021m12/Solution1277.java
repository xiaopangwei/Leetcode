package leetcode.p2021m12;

import leetcode.p2021m08.Solution277;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/13
 * @time 9:49 PM
 */
public class Solution1277 {
    public int countSquares(int[][] matrix) {
        int     m  = matrix.length;
        int     n  = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] != 0) {
                dp[0][i] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] != 0) {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j != 0) {
                    if (matrix[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        min = Math.min(min, dp[i - 1][j]);
                        min = Math.min(min, dp[i][j - 1]);
                        min = Math.min(min, dp[i - 1][j - 1]);
                        dp[i][j] = min + 1;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Solution1277 solution1277=new Solution1277();
        int ans=solution1277.countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}});
        System.out.println(ans);

    }
}
