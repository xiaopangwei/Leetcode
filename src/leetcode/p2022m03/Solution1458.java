package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/15
 * @time 8:43 PM
 */
public class Solution1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < dp.length; i++) {
            //这里要注意，不能初始化为最小值
//            Arrays.fill(dp[i], Integer.MIN_VALUE);
            Arrays.fill(dp[i], -1000*1000*500);
        }

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
//                dp[i][j]的含义是到nums1[i-1]和nums2[j-1]为止的子序列的最大点积。
                int t1 = nums1[i - 1] * nums2[j - 1];
                int t2 = dp[i - 1][j];
                int t3 = dp[i][j - 1];
                int t4 = dp[i - 1][j - 1];
                int t5 = t4 + t1;
                dp[i][j] = Math.max(dp[i][j], Math.max(t1, t2));
                dp[i][j] = Math.max(dp[i][j], Math.max(t3, t4));
                dp[i][j] = Math.max(dp[i][j], t5);
            }
        }

        return dp[nums1.length][nums2.length];
    }

}
