package leetcode.p2022m05.day0516;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/16
 * @time 8:20 PM
 */
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
//        int[] values = new int[5];
        int[] values = new int[10001];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int item : nums) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        for (int i = 0; i < values.length; i++) {
            values[i] = freq.getOrDefault(i, 0) * i;
        }
//        System.out.println(Arrays.toString(values));
        return dfs(values);
    }

    private int dfs(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int t = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            dp[i] = Math.max(dp[i], t);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution740 solution740 = new Solution740();
        int         ans         = solution740.deleteAndEarn(new int[]{2,2,3,3,3,4});
        System.out.println(ans);
    }
}
