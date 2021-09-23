package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 1:33 PM
 */
public class Solution651 {
    public int maxA(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int a      = dp[i - 1] + 1;
            int maxVal = a;

            for (int j = 1; j < i-1; j++) {

                    maxVal = Math.max(maxVal,  (i - j - 1) * dp[j]);

            }

            dp[i] = maxVal;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution651 solution651 = new Solution651();
        for (int i = 1; i <= 13; i++) {
            int ans = solution651.maxA(i);
            System.out.println(i + " => " + ans);
        }

    }

}
