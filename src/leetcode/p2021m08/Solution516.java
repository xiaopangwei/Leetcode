package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/12
 * @time 11:20 PM
 */
public class Solution516 {


    public int longestPalindromeSubseq(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int     length = s.length();
        int[][] dp     = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
            } else {
                dp[i][i + 1] = 1;
            }
        }

        for (int len = 3; len <= length; len++) {
            for (int i = 0; i < length; i++) {
                int j = i + len - 1;
                if (j >= length) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, dp[i][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1]);
                }
                System.out.println(i+","+j+" "+dp[i][j]);
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }


        return dp[0][length - 1];
    }

    public static void main(String[] args) {
        Solution516 solution516 = new Solution516();
        int         ans         = solution516.longestPalindromeSubseq("abaababaab");
        System.out.println(" ===> " + ans);
        System.out.println(ans);
    }

}
