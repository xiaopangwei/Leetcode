package leetcode.springfestival.sf20220201;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/3
 * @time 12:04 AM
 */
public class Solution153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left  = 0;
        int right = nums.length - 1;
        while (left < right) {
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
        return nums[left];
    }

    private boolean isBottom(int[] nums, int index) {
        if (index == 0) {
            return nums[index] < nums[index + 1];
        } else if (index == nums.length - 1) {
            return nums[index] < nums[index - 1];
        } else {
            return nums[index] < nums[index + 1] && nums[index] < nums[index - 1];
        }
    }


    public static void main(String[] args) {
        Solution153 solution153 = new Solution153();
        int         ans         = solution153.findMin(new int[]{3, 1, 2});
        System.out.println(ans);
    }
}
