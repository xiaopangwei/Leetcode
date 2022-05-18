package leetcode.p2022m05.day0502;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 5:02 PM
 */
public class Solution343 {
    int[] dp;

    public int integerBreak(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = dfs(n);

        return ans;
    }


    private int dfs(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int maxVal = 1;
        for (int i = 1; i <= n-1; i++) {
            if (i >= 1 && n - i >= 1) {
                maxVal = Math.max(i * dfs(n - i), maxVal);
                maxVal = Math.max(i * (n - i), maxVal);
            }
        }
        dp[n] = maxVal;
        return maxVal;
    }

    public static void main(String[] args) {
        Solution343 solution343 = new Solution343();
        int         ans         = solution343.integerBreak(10);
        System.out.println(ans);
    }
}
