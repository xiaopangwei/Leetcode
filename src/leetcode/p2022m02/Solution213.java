package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/7
 * @time 8:46 PM
 */
public class Solution213 {
    private int get(int[] dp, int i) {
        if (i < 0) {
            return 0;
        }
        return dp[i];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxVal = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.max(get(dp, i - 2) + nums[i], dp[i - 1]);
        }

        maxVal = dp[nums.length - 2];


        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(get(dp, i - 2) + nums[i], dp[i - 1]);
        }
        maxVal = Math.max(maxVal, dp[nums.length - 1]);
        return maxVal;
    }

    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        int         nums        = solution213.rob(new int[]{2,3,2});
        System.out.println(nums);
    }
}
