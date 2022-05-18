package leetcode.p2022m05.day0504;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 8:09 PM
 */
public class Solution516 {
    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(s, 0, s.length() - 1);

    }


    private int dfs(String s, int start, int end) {

        if (start > end) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (start == end) {
            dp[start][end] = 1;
            return 1;
        }
        if (start + 1 == end) {
            if (s.charAt(start) == s.charAt(end)) {
                dp[start][end] = 2;
                return 2;
            } else {
                dp[start][end] = 1;
                return 1;
            }
        }

        int ans = 0;
        if (s.charAt(start) == s.charAt(end)) {
            ans = dfs(s, start + 1, end - 1) + 2;
        } else {
            ans = Math.max(dfs(s, start + 1, end), dfs(s, start, end - 1));
        }

        dp[start][end] = ans;
        return ans;
    }

    public static void main(String[] args){
        Solution516 solution516=new Solution516();
        System.out.println(solution516.longestPalindromeSubseq("cbbd"));
    }
}
