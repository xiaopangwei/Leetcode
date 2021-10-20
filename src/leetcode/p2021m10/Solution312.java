package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/17
 * @time 10:38 AM
 */
public class Solution312 {
    public int maxCoins(int[] nums) {

        int[] copy = new int[nums.length + 2];
        copy[0] = 1;
        copy[copy.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            copy[i + 1] = nums[i];
        }
        int     len = copy.length;
        int[][] dp  = new int[len][len];


        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len; i++) {
                int j = i + k - 1;
                if (j >= len) {
                    continue;
                }

                for (int idx = i + 1; idx < j; idx++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][idx] + copy[i] * copy[idx] * copy[j] + dp[idx][j]);
                }


            }
        }

        return dp[0][len - 1];

    }

    public static void main(String[] args) {
        Solution312 solution312 = new Solution312();
        int         ans         = solution312.maxCoins(new int[]{3,1,5,8});
        System.out.println(ans);
    }
}
