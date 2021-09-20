package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 10:25 AM
 */
public class Solution650 {

    public int minSteps(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    temp = Math.min(temp, dp[j] + i / j);
                }
            }

            dp[i] = temp;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Solution650 solution650 = new Solution650();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+" "+solution650.minSteps(i));
        }
    }
}
