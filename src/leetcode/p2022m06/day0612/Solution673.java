package leetcode.p2022m06.day0612;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/19
 * @time 9:12 PM
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {

        int   n   = nums.length;
        int[] dp  = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            System.out.println(i);
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        int ans=0;
        for (int i=0;i<dp.length;i++){
            if (dp[i]==maxLen){
                ans+=cnt[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution673 solution673 = new Solution673();
        int ans=solution673.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(ans);
    }
}
