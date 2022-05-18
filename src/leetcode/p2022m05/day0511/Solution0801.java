package leetcode.p2022m05.day0511;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/11
 * @time 8:18 PM
 */
public class Solution0801 {
    public int waysToStep(int n) {
        long[] dp = new long[n + 1];

        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            if (i >= 1) {
                dp[i] += dp[i - 1];
            }
            if (i >= 2) {
                dp[i] += dp[i - 2];
            }
            if (i >= 3) {
                dp[i] += dp[i - 3];
            }
        }

        return (int) (dp[n] % 1000000007);
    }

    public static void main(String[] args){
        Solution0801 solution0801=new Solution0801();
        int ans=solution0801.waysToStep(3);
        System.out.println(ans);
    }
}
