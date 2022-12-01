package leetcode.p2022q4;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/30
 * @time 9:34 PM
 */
public class Solution2414 {
    public int longestContinuousSubstring(String s) {
        int   len    = s.length();
        int[] dp     = new int[len];
        int   maxLen = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) + 1 == s.charAt(i)) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution2414 solution2414=new Solution2414();
        System.out.println(solution2414.longestContinuousSubstring("abcde"));
    }
}
