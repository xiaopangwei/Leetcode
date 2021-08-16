package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/9
 * @time 11:18 PM
 */
public class Solution213 {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int   len = nums.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        //第一个必须选，最后一个不选

        int[] copy1 = new int[len - 1];
        int[] copy2 = new int[len - 1];
        System.arraycopy(nums, 0, copy1, 0, len - 1);
        System.arraycopy(nums, 1, copy2, 0, len - 1);
        int res1 = get(copy1, dp1);
        //第一个不选，最后一个随意
        int res2 = get(copy2, dp2);

        return Math.max(res1, res2);

    }


    public int get(int[] nums, int[] dp) {

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args){
        Solution213 solution213=new Solution213();
        int ans=solution213.rob(new int[]{0});
        System.out.println(ans);
    }
}
