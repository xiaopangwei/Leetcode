package leetcode.p2022m05.day0509;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 8:02 PM
 */
public class Solution462 {
    public int minMoves2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int mid = 0;
        if (nums.length % 2 != 0) {
            mid = nums[nums.length / 2];
        } else {
            mid = nums[nums.length / 2] + nums[(nums.length - 1) / 2];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i] - mid);
        }
        return sum;

    }
}
