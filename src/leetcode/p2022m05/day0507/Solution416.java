package leetcode.p2022m05.day0507;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 4:35 PM
 */
public class Solution416 {
    Map<String, Boolean> cached = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int s = Arrays.stream(nums).sum();
        if (s % 2 != 0) {
            return false;
        }
        int half = s / 2;
        return dfs(nums, 0, 0, half);

    }

    private boolean dfs(int[] nums, int index, int currentSum, final int target) {
        String biKey = index + "#" + currentSum;
        if (index>nums.length || currentSum>target){
            return false;
        }
        if (index == nums.length) {
            return currentSum == target;
        }
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        boolean ans = dfs(nums, index + 1, currentSum, target) || dfs(nums, index + 1, currentSum + nums[index], target);
        cached.put(biKey, ans);
        return ans;
    }
}
