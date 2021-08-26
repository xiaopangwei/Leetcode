package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/24
 * @time 3:30 PM
 */
public class Solution1928 {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        /**
         * f[t][i]= (i,j相连) min{f[t-cost[j]][i]}}+Fee[i]
         */
        int     inf = 10000;
        int     n   = passingFees.length;
        int[][] dp  = new int[maxTime + 1][n];


        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], inf);
        }

        dp[0][0] = passingFees[0];

        for (int k = 1; k <= maxTime; k++) {
            for (int i = 0; i < edges.length; i++) {
                int start = edges[i][0];
                int end   = edges[i][1];
                int cost  = edges[i][2];

                if (cost > k) {
                    continue;
                }
                dp[k][start] = Math.min(dp[k][start], dp[k - cost][end] + passingFees[start]);
                dp[k][end] = Math.min(dp[k][end], dp[k - cost][start] + passingFees[end]);
            }
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            minVal = Math.min(minVal, dp[i][n - 1]);
        }

        if (minVal == inf) {
            return -1;
        }

        return minVal;
    }
}
