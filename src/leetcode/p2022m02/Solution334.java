package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/10
 * @time 9:59 PM
 */
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int mostMin   = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int item : nums) {
            if (item <= mostMin) {
                mostMin = item;
            } else if (item <= secondMin) {
                secondMin = item;
            } else {
                return true;
            }

            System.out.println(mostMin + " " + secondMin);
        }

        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int[] left  = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (left[i] < nums[i] && nums[i] < right[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]       array       = new int[]{2, 1, 5, 0, 6};
        Solution334 solution334 = new Solution334();
        boolean     ans         = solution334.increasingTriplet2(array);
        System.out.println(ans);
    }
}
