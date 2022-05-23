package leetcode.p2022m05.day0502;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 2:54 PM
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        Solution300 solution300=new Solution300();
        int ans=solution300.lengthOfLIS(nums);
        System.out.println(ans);
    }
}
