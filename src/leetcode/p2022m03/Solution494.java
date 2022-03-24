package leetcode.p2022m03;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 2:34 PM
 */
public class Solution494 {
    Map<String, Integer> cached = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {

        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int index, int currentSum, final int target) {
        String biKey=index+"#"+currentSum;
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        if (index >= nums.length) {
            if (currentSum == target) {
                return 1;
            }
            return 0;
        }
        int ans = 0;
        ans += dfs(nums, index + 1, currentSum + nums[index], target);
        ans += dfs(nums, index + 1, currentSum - nums[index], target);
        cached.put(biKey, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        int         ans         = solution494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(ans);
    }
}
