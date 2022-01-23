package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/23
 * @time 10:21 PM
 */
public class Solution152 {

    Map<Integer, Integer> cached = new HashMap<>();

    public int maxProduct(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int index) {
        if (cached.containsKey(index)) {
            return cached.get(index);
        }
        if (index == nums.length) {
            return 1;
        }
        int t1 = dfs(nums, index + 1);
        int t2 = t1 * nums[index];
        int t3 = nums[index];

        int ans = Math.max(t1, Math.max(t2, t3));
        cached.put(index, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int         ans         = solution152.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(ans);
    }
}
