package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/19
 * @time 8:09 PM
 */
public class Solution123 {


    public int maxProfit(int m, int[] prices) {
        int       len = prices.length;
        int[][][] dp  = new int[len + 1][2][3];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int k = m; k >= 0; k--) {

                    if (k >= 2 && j == 0) {
                        dp[i][j][k] = 0;
                    } else {
                        if (j > 0) {
                            dp[i][j][k] = Math.max(prices[i] + dp[i + 1][0][k], dp[i + 1][j][k]);
                        } else {
                            dp[i][j][k] = Math.max(-prices[i] + dp[i + 1][1][k + 1], dp[i + 1][j][k]);

                        }
                    }
                }
            }
        }

        return dp[0][0][0];
    }


    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        int[]       array       = new int[]{3, 2, 6, 5, 0, 3};
        int         ans         = solution123.maxProfit(2, array);
        System.out.println(ans);
    }
}
