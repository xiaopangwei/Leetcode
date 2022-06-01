package demo.discuss;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/17
 * @time 10:21 PM
 */
public class Solution229 {
    public int getMinAbs(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > -0) {
            return nums[0] + nums[1];
        }

        if (nums[nums.length - 1] <= 0) {
            return nums[nums.length - 2] + nums[nums.length - 1];
        }


        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int val1 = search1(nums, i + 1, -nums[i]);
                int val2 = search2(nums, i + 1, -nums[i]);
                int t    = Math.min(Math.abs(val1 + nums[i]), Math.abs(val2 + nums[i]));
//                System.out.println(t);
                minVal = Math.min(minVal, t);
            } else {
                break;
            }
        }
        return minVal;
    }

    //>=target
    public int search1(int[] nums, int left, int target) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[Math.min(left, nums.length - 1)];
    }

    //<=target
    public int search2(int[] nums, int left, int target) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[Math.max(right, 0)];
    }

    public static void main(String[] args) {
        Solution229 solution229 = new Solution229();
        int         ans         = solution229.getMinAbs(new int[]{-15, -3, 2, 1, 5, 10});
        System.out.println(ans);
    }
}
