package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/23
 * @time 10:21 PM
 */
public class Solution152 {

    int maxVal;

    public int maxProduct(int[] nums) {
        maxVal = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.min(nums[i], Math.min(dp[i - 1][1] * nums[i], dp[i - 1][0] * nums[i]));
            maxVal = Math.max(dp[i][0], maxVal);
            dp[i][1] = Math.max(nums[i], Math.max(dp[i - 1][1] * nums[i], dp[i - 1][0] * nums[i]));
            maxVal = Math.max(dp[i][1], maxVal);
        }

        return maxVal;
    }

    public int maxProduct2(int[] nums) {
        int maxVal = nums[0];
        int bigger  = nums[0];
        int smaller = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int t1 = nums[i];
            int t2 = smaller * nums[i];
            int t3 = bigger * nums[i];

            int max = Math.max(t1, Math.max(t2, t3));
            int min = Math.min(t1, Math.min(t2, t3));

            bigger = max;
            smaller = min;


            maxVal = Math.max(maxVal, bigger);

        }

        return maxVal;
    }

    private void dfs(int[] nums, int index, int product) {
        if (index == nums.length) {
            return;
        }
        int t1 = nums[index];
        int t2 = nums[index] * product;
        int t3 = product;

        int temp = Math.max(t1, Math.max(t2, t3));
        maxVal = Math.max(maxVal, temp);

        dfs(nums, index + 1, nums[index]);
        dfs(nums, index + 1, product * nums[index]);
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int         ans         = solution152.maxProduct(new int[]{2,3,-2,4});
        System.out.println(ans);
    }
}
