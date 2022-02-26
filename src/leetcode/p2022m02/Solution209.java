package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/23
 * @time 10:32 PM
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left  = 0;
        int right = 0;

        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            if (sum < target) {
                right++;
            } else {
                while (left <= right && sum >= target) {
                    int len = right - left + 1;
                    ans = Math.min(ans, len);
                    sum -= nums[left++];
                }

                right++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int         ans         = solution209.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1});
        System.out.println(ans);
    }
}
