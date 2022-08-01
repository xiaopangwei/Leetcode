package leetcode.p2022m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/23
 * @time 10:52 AM
 */
public class Solution1884 {

    int[][] dp;

    public int twoEggDrop(int n) {
        dp = new int[n + 1][3];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(n, 2);
    }


    private int dfs(int n, int k) {

        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }

        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        int minAns = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            //在第i层碎了 [1,i)
            int t1 = dfs(i - 1, k - 1);
            //第i层没有碎 [i+1,n]
            int t2     = dfs(n - i, k);
            int maxVal = Math.max(t1, t2) + 1;
            minAns = Math.min(minAns, maxVal);
        }
        dp[n][k] = minAns;
        return minAns;
    }

    public static void main(String[] args) {
        Solution1884 solution1884 = new Solution1884();
        int          ans          = solution1884.twoEggDrop(100);
        System.out.println(ans);
    }
}
