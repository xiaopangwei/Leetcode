package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/9
 * @time 6:46 PM
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    int t = dp[i - coins[j]];
                    int temp;
                    if (t == Integer.MAX_VALUE) {
                        temp = t;
                    } else {
                        temp = t + 1;
                    }
                    dp[i] = Math.min(temp, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int         ans         = solution322.coinChange(new int[]{1}, 0);
        System.out.println(ans);
    }
}
