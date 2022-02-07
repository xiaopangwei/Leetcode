package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/7
 * @time 8:36 PM
 */
public class Solution198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i >= 2) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args){
        Solution198 solution198=new Solution198();
        int ans=solution198.rob(new int[]{1,2,3,1});
        System.out.println(ans);
    }
}
