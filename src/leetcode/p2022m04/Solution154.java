package leetcode.p2022m04;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/4/12
 * @time 9:11 PM
 */
public class Solution154 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[left] <= nums[right]) {
                return nums[left];
            } else if (nums[mid] == nums[left]) {
                left++;
                continue;
            } else if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
