package leetcode.p2022m05.day0510;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 9:29 PM
 */
public class Solution279 {
    int[] dp;

    int[] cached;

    public int numSquares(int n) {
        cached = new int[10001];
        Arrays.fill(cached, -1);
        dp = new int[101];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i * i;
        }

        return dfs(n, 0);
    }

    private int dfs(final int n, int currentSum) {

        if (cached[currentSum] != -1) {
            return cached[currentSum];
        }
        if (currentSum == n) {
            cached[currentSum] = 0;
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= (int) (Math.sqrt(n)); i++) {
            if (currentSum + dp[i] > n) {
                continue;
            }
            ans = Math.min(ans, dfs(n, currentSum + dp[i]) + 1);
        }
        cached[currentSum] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        int         ans         = solution279.numSquares(12);
        System.out.println(ans);
    }
}
