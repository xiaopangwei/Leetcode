package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/18
 * @time 9:29 AM
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        int   len      = s.length();
        int[] dp       = new int[len];
        int   maxValue = 0;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == ')') {
                    int leftmost = i - dp[i - 1] - 1;
                    if (i - dp[i - 1] > 0 && s.charAt(leftmost) == '(') {
                        if (leftmost - 1 >= 0) {
                            dp[i] = dp[leftmost - 1] + dp[i - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                } else {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }

                }
                maxValue = Math.max(maxValue, dp[i]);
            }


        }


        return maxValue;
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int        ans        = solution32.longestValidParentheses("()(())");
        System.out.println(ans);
    }
}
