package leetcode.p2022m05.day0514;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 11:16 PM
 */
public class Solution1277 {
    public int countSquares(int[][] matrix) {
        int[][] dp  = new int[matrix.length][matrix[0].length];
        int     ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                ans += 1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 1) {
                dp[0][i] = 1;
                ans += 1;
            }
        }


        if (matrix[0][0] == 1) {
            ans -= 1;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int t = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(t, dp[i - 1][j - 1]) + 1;
                }
                ans += dp[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution1277 solution1277 = new Solution1277();
        //[[1,0,1],[1,1,0],[1,1,0]]
        int ans = solution1277.countSquares(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}});
        System.out.println(ans);

    }
}
