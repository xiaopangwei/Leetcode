package leetcode.springfestival.pm20220205;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/5
 * @time 11:17 AM
 */
public class Solution1493 {
    public int longestSubarray(int[] nums) {

        int left      = 0;
        int right     = 0;
        int zeroCount = 0;

        int ans = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            if (zeroCount <= 1) {
                ans = Math.max(ans, right - left + 1);
            } else {
                while (left < right && zeroCount > 1) {
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans - 1 < 0 ? 0 : ans - 1;
    }

    public static void main(String[] args) {
        Solution1493 solution1493 = new Solution1493();
        int          ans          = solution1493.longestSubarray(new int[]{0,0,0});
        System.out.println(ans);
    }
}
