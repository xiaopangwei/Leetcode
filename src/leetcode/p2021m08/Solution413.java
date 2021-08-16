package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 9:51 AM
 */
public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }
        int   len = nums.length;
        int[] dp  = new int[len];

        for (int i = 0; i < len; i++) {
            int j = i + 1;
            if (j >= len) {
                continue;
            }
            int delta = nums[j] - nums[i];
            int count = 0;
            if (i < 1) {
                continue;
            }
            if (2 * nums[i] == nums[i - 1] + nums[j]) {
                count = 1;
                int k = i - 1;
                while (k >= 1) {
                    if (nums[k] - nums[k - 1] == delta) {
                        count++;
                    } else {
                        break;
                    }
                    k--;
                }
            } else {
                count = 0;
            }
            dp[j] = dp[i] + count;
        }
//
//        System.out.println(Arrays.toString(dp));

        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution413 solution413 = new Solution413();
        int         ans         = solution413.numberOfArithmeticSlices(new int[]{3,-1,-5,-9});
        System.out.println(ans);
    }
}
