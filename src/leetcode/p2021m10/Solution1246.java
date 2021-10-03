package leetcode.p2021m10;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 1:11 PM
 */
public class Solution1246 {
    public int minimumMoves(int[] arr) {

        int     len = arr.length;
        int[][] dp  = new int[len][len];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            } else {
                dp[i][i + 1] = 2;
            }
        }

        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len; i++) {
                int j = i + k - 1;
                if (j >= len) {
                    continue;
                }

                if (arr[i] == arr[j]) {
                    dp[i][j] = Math.min(dp[i + 1][j - 1], dp[i][j]);
                } else {
                    for (int m = i; m < j; m++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                    }

                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        Solution1246 solution1246 = new Solution1246();
        int          ans          = solution1246.minimumMoves(new int[]{1,2});
        System.out.println(ans);
    }
}
