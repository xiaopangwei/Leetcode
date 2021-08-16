package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 3:54 PM
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {

        int     len1 = word1.length() + 1;
        int     len2 = word2.length() + 1;
        int[][] dp   = new int[len1][len2];

        dp[0][0] = 0;

        for (int i = 1; i < len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < len1; i++) {
            dp[i][0] = i;
        }


        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int temp = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    temp = dp[i - 1][j - 1] + 1;
                }

                int t1 = Math.min(temp, dp[i - 1][j] + 1);
                int t2 = Math.min(t1, dp[i][j-1] + 1);
                dp[i][j] = t2;
            }
        }

        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        int        ans        = solution72.minDistance("", "execution");
        System.out.println(ans);
    }
}
