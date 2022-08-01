package leetcode.p2022m06.day0625;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/26
 * @time 8:56 PM
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int s = Arrays.stream(nums).sum();
        if (s % 2 != 0) {
            return false;
        }
        int half = s / 2;
        return dfs(nums, 0, 0, half);
    }

    public boolean dfs(int[] nums, int index, int currentSum, final int target) {
        if (currentSum > target) {
            return false;
        }
        if (index == nums.length) {
            return currentSum == target;
        }
        if (currentSum == target) {
            return true;
        }

        return dfs(nums, index, currentSum, target) ||
                dfs(nums, index + 1, currentSum + nums[index], target);
    }

}
