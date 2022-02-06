package leetcode.springfestival.pm20220205;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/3
 * @time 11:31 AM
 */
public class Solution709 {
    /**
     * dis = {d | abs(nums[i], nums[j]) , i != j}
     * f(x): dis中<= x的个数
     * <p>
     * when x1 < x2, f(x1) <= f(x2), 故f(x)单调递增的
     * <p>
     * x = {min(dis),..., max(dis)}
     * 第k大数的为 x | f(x) >= k, 且 f(x-1) < k -> 我们可以使用二分和双指针求出
     * 证明:
     * 如果x属于dis，那么x显然正确
     * <p>
     * 如果x不属于dis，.. 这种情况不存在
     * （反证法）如果x不属于dis,那么f(x-1) >= k,与f(x-1) < k矛盾
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left  = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getDistLessThanKCount(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int getDistLessThanKCount(int[] nums, int mid) {

        int left  = 0;
        int right = 1;
        int ans   = 0;

        while (right < nums.length) {
            while (left < right && nums[right] - nums[left] > mid) {
                left++;
            }
            ans += (right - left);
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[]       array       = new int[]{1, 3, 1};
        Solution709 solution709 = new Solution709();
        int         ans         = solution709.smallestDistancePair(array, 1);
        System.out.println(ans);
    }
}
