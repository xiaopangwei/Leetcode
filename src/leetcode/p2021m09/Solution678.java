package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/12
 * @time 10:34 AM
 */
public class Solution678 {


    public boolean checkValidString(String s) {
        int         len = s.length();
        boolean[][] dp  = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                dp[i][i] = true;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            if ((s.charAt(i) == '(' || s.charAt(i) == '*') &&
                    (s.charAt(i + 1) == ')' || s.charAt(i + 1) == '*')) {
                dp[i][i+1] = true;
            }
        }

        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len; i++) {
                int j = i + k - 1;
                if (j >= len) {
                    continue;
                }
                if ((s.charAt(i) == '(' || s.charAt(i) == '*') &&
                        (s.charAt(j) == ')' || s.charAt(j) == '*')) {
                    if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (!dp[i][j]) {
                    for (int idx = i; idx <= j; idx++) {
                        if (dp[i][idx] && dp[idx + 1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }

            }
        }
        return dp[0][len - 1];
    }


    public static void main(String[] args) {
        Solution678 solution678 = new Solution678();
        boolean     ans         = solution678.checkValidString("(*))");
        System.out.println(ans);
    }
}
