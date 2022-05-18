package leetcode.p2022m05.day0514;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 2:52 PM
 */
public class Solution532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int i   = 0;
        int ans = 0;
        while (i < nums.length) {

            int idx = find(nums, i + 1, nums[i] + k);
            if (idx >= 0) {
                ans++;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }

            i = j;
        }
        return ans;
    }

    private int find(int[] nums, int left, int target) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution532 solution532 = new Solution532();
        int         ans         = solution532.findPairs(new int[]{1, 3, 1, 5, 4}, 0);
        System.out.println(ans);
    }
}
