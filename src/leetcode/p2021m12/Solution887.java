package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/29
 * @time 10:57 PM
 */
public class Solution887 {

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int t = 2; t <= k; t++) {
                for (int j = 1; j <= i; i++) {
                    max = Math.max(dp[t - 1][j - 1] + 1, dp[t][i - j] + 1);
                }

            }
            ans = Math.min(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution887 solution887 = new Solution887();
        int         ans         = solution887.superEggDrop(3, 14);
        System.out.println(ans);
    }
}
