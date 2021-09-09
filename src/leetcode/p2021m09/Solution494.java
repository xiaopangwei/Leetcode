package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/8
 * @time 10:15 PM
 */
public class Solution494 {
    Map<String, Integer> cached = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {

        return dfs(0, nums, target, 0);
    }

    private int dfs(int index, final int[] nums, final int target, int currentSum) {
        String biKey = index + "#" + currentSum;
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }

        if (index == nums.length) {
            if (target == currentSum) {
                return 1;
            } else {
                return 0;
            }
        }

        int t1   = dfs(index + 1, nums, target, currentSum + nums[index]);
        int t2   = dfs(index + 1, nums, target, currentSum - nums[index]);
        int temp = t1 + t2;

        cached.put(biKey, temp);

        return temp;
    }

    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        int         ans         = solution494.findTargetSumWays(new int[]{1}, 1);
        System.out.println(ans);
    }
}
