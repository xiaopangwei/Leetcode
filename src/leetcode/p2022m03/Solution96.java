package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/27
 * @time 8:39 PM
 */
public class Solution96 {
    int[] dp;

    public int dfs(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            //以i为根
            //[1,i-1]左子树
            //[i+1,n]右子树
            ans += (dfs(i - 1) * dfs(n - i));
        }
        dp[n] = ans;
        return ans;
    }

    public int numTrees(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(n);
    }

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        int        ans        = solution96.numTrees(4);
        System.out.println(ans);
    }
}
