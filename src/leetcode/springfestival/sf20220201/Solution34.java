package leetcode.springfestival.sf20220201;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/2
 * @time 5:16 PM
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
            return new int[]{};
        }
        int[] ans = new int[2];
        ans[0] = getLeftBound(nums, target);
        ans[1] = getRightBound(nums, target);

        return ans;
    }

    private int getLeftBound(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid - 1 >= 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private int getRightBound(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid + 1 < nums.length && nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[]      ans        = solution34.searchRange(new int[]{1}, 1);
        System.out.println(Arrays.toString(ans));
    }
}
