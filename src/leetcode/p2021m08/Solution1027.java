package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/6
 * @time 11:15 AM
 */
public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int     length = nums.length;
        int[][] dp     = new int[length][length];
        int     maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = 2 * nums[i] - nums[j];
                for (int k = i - 1; k >= 0; k--) {
                    if (target == nums[k]) {
                        dp[i][j] = dp[k][i] + 1;
                        break;
                    }
                }
                maxVal = Math.max(dp[i][j], maxVal);
            }

        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution1027 solution1027 = new Solution1027();
        int          ans          = solution1027.longestArithSeqLength(new int[]{1,2,4});
        System.out.println(ans);
    }
}
