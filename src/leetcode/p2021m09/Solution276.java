package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/5
 * @time 8:10 PM
 */
public class Solution276 {
    public int numWays(int n, int k) {

        if (k == 1) {
            if (n == 2) {
                return 1;
            } else {
                return 0;
            }
        }
        if (n <= 2) {
            return (int) Math.pow(k, n);
        }

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = k;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][0]) * (k - 1);
        }

        return dp[n - 1][0] + dp[n - 1][1];

    }
}
