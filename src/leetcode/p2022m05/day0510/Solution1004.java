package leetcode.p2022m05.day0510;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 10:19 PM
 */
public class Solution1004 {
    public int longestOnes(int[] nums, int k) {

        int zeros  = 0;
        int maxLen = 0;
        int left   = 0;
        int right  = 0;
        while (right < nums.length) {
            int r = nums[right];
            if (r == 0) {
                zeros++;
            }
            while (left < right && zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            if (zeros <= k) {
                right++;
                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution1004 solution1004 = new Solution1004();
        int          ans          = solution1004.longestOnes(new int[]{0, 0, 0, 0}, 0);
        System.out.println(ans);
    }
}
