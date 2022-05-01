package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/23
 * @time 9:49 PM
 */
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int ans     = 0;
        int right   = 0;
        int left    = 0;
        int product = 1;
        while (right < nums.length) {
            int temp = nums[right] * product;

            while (left <= right && temp >= k) {
                temp /= nums[left++];
            }
            product = temp;
            ans += (right - left + 1);

            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution713 solution713 = new Solution713();
        int         ans         = solution713.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0);
        System.out.println(ans);
    }
}
