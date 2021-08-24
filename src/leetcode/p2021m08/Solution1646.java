package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/23
 * @time 9:49 PM
 */
public class Solution1646 {
    public int getMaximumGenerated(int n) {

        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        int maxValue = -1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            maxValue = Math.max(maxValue, dp[i]);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Solution1646 solution1646 = new Solution1646();
        int          ans          = solution1646.getMaximumGenerated(1);
        System.out.println(ans);
    }
}
