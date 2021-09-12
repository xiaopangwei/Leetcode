package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/11
 * @time 5:03 PM
 */
public class Solution647 {
    public int countSubstrings(String s) {

        int         len = s.length();
        boolean[][] dp  = new boolean[len][len];

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count += 1;
            } else {
                dp[i][i + 1] = false;
            }
        }


        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len; i++) {

                int j = i + k - 1;
                if (j >= len) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                } else {
                    dp[i][j] = false;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        int         ans         = solution647.countSubstrings("aaaac");
        System.out.println(ans);
    }
}
