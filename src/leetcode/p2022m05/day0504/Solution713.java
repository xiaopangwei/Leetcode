package leetcode.p2022m05.day0504;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 6:53 PM
 */
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left    = 0;
        int right   = 0;
        int product = 1;
        int ans     = 0;
        while (right < nums.length) {
            product *= nums[right];

            while (left < right && product >= k) {
                product /= nums[left++];
            }

            if (product < k) {
                ans += (right - left + 1);
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution713 solution713 = new Solution713();
        int         count       = solution713.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
        System.out.println(count);

    }
}
