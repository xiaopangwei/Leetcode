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
        if (ans[0]==-1){
            return new int[]{-1,-1};
        }
        ans[1] = getRightBound(nums, target);
        if (ans[1]==-1){
            return new int[]{-1,-1};
        }
        return ans;
    }

    //第一个大于等于target的
    private int getLeftBound(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left>=0 && left<nums.length && nums[left]==target){
            return left;
        }
        return -1;
    }

    //最后一个小于等于target的
    private int getRightBound(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right>=0 && right<nums.length && nums[right]==target){
            return right;
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[]      ans        = solution34.searchRange(new int[]{1,2,2,3,3,3,65}, 65);
        System.out.println(Arrays.toString(ans));
    }
}
