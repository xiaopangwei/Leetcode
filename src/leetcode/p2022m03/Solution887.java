package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 7:47 PM
 */
public class Solution887 {
    int[][] dp;

    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return dfs(k, n);

    }

    private int dfs(int k, int n) {
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        if (n <= 1) {
            return n;
        }

        if (dp[k][n] != Integer.MAX_VALUE) {
            return dp[k][n];
        }

        //dfs(k-1,i)==dfs(k,n-i)
        int left  = 1;
        int right = n;

        //f(a)>=f(b) 的 第一个mid
        while (left <= right) {
            int mid = (left + right) / 2;
            int a   = dfs(k - 1, mid - 1);
            int b   = dfs(k, n - mid);
            if (a < b) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int minVal = Math.max(dfs(k - 1, left - 1), dfs(k, n - left)) + 1;


        dp[k][n] = minVal;
        return minVal;
    }

    public static void main(String[] args) {
        Solution887 solution887 = new Solution887();
        //6

        int         ans         = solution887.superEggDrop(6, 10000);
        System.out.println(ans);

    }
}
