package leetcode.springfestival.pm20220203;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/3
 * @time 11:57 AM
 */
public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {

        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] + nums[i], nums[i]);
            minDp[i] = Math.min(minDp[i - 1] + nums[i], nums[i]);
            sum += nums[i];
        }

        int maxVal = maxDp[0];
        for (int i = 1; i < maxDp.length; i++) {
            maxVal = Math.max(maxVal, maxDp[i]);
        }

        int minVal = maxDp[0];
        for (int i = 1; i < minDp.length; i++) {
            minVal = Math.min(minVal, minDp[i]);
        }
        return Math.max(sum - minVal == 0 ? maxVal : sum - minVal, maxVal);
    }

    public static void main(String[] args) {
        Solution918 solution918 = new Solution918();
        int         ans         = solution918.maxSubarraySumCircular(new int[]{-2, -3, -1});
        System.out.println(ans);
    }
}
