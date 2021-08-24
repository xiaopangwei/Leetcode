package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/21
 * @time 9:55 AM
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int[] count = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    if (dp[j] + 1 > dp[i]) {

                        count[i] = count[j];
//                        System.out.println("1st:" + nums[i] + " " + dp[i] + " " + nums[j] + " " + dp[j] + " " + count[i] + " " + count[j]);
                    } else if (dp[j] + 1 == dp[i]) {

                        count[i] += count[j];
//                        System.out.println("2nd:" + nums[i] + " " + dp[i] + " " + nums[j] + " " + dp[j] + count[i] + " " + count[j]);
                    }

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));


        int maxLength = -1;
        for (int item : dp) {
            maxLength = Math.max(maxLength, item);
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLength) {
                res += count[i];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution673 solution673 = new Solution673();
        int[]       array       = new int[]{1, 3, 5, 4, 7};
        System.out.println(solution673.findNumberOfLIS(array));
    }
}
