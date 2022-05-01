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
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public int findMax(int[] nums) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return nums[right];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution153 solution153 = new Solution153();
        int         ans         = solution153.findMax(new int[]{4,5,6,7,0,1,2});
        System.out.println(ans);
    }
}
