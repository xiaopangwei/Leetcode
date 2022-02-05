package leetcode.springfestival.sf20220201;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/2
 * @time 11:37 PM
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPeek(nums, mid)) {
                return mid;
            }
            if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private boolean isPeek(int[] nums, int index) {
        if (index == 0) {
            return nums[index] > nums[index + 1];
        } else if (index == nums.length - 1) {
            return nums[index] > nums[index - 1];
        } else {
            return nums[index] > nums[index + 1] && nums[index] > nums[index - 1];
        }
    }

    public static void main(String[] args) {
        Solution162 solution162 = new Solution162();
        int         index       = solution162.findPeakElement(new int[]{1,2,1,3,5,6,4});
        System.out.println(index);
    }
}
