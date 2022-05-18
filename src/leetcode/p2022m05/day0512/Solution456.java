package leetcode.p2022m05.day0512;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 9:55 PM
 */
public class Solution456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length<3){
            return false;
        }
        int[] left = new int[nums.length];
        left[0] = Integer.MAX_VALUE;

        int[] right = new int[nums.length];
        right[nums.length - 1] = Integer.MAX_VALUE;


        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.min(nums[i - 1], left[i - 1]);
        }

        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.min(nums[i + 1], right[i + 1]);
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 1; i <= nums.length - 2; i++) {
            if (left[i] < nums[i] && right[i] < nums[i] && left[i] < right[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution456 solution456 = new Solution456();
        boolean     ans         = solution456.find132pattern(new int[]{3,5,0,3,4});
        System.out.println(ans);
    }
}
