package leetcode.p2021m10;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/7
 * @time 9:25 PM
 */
public class Solution1216 {
    public boolean isValidPalindrome(String s, int k) {

        int     len = s.length();
        int[][] dp  = new int[len][len];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < len; i++) {
            dp[i][i] = 0;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 0;
            } else {
                dp[i][i + 1] = 1;
            }
        }

        for (int L = 3; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;
                if (j >= len) {
                    continue;
                }

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]+1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]+1);
            }
        }

        return dp[0][len - 1] <= k;
    }

    public static void main(String[] args){
        Solution1216 solution1216=new Solution1216();
        boolean ans=solution1216.isValidPalindrome("abcdeca",2);
        System.out.println(ans);
    }
}
