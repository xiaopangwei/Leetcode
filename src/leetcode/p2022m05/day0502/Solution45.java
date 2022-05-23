package leetcode.p2022m05.day0502;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/22
 * @time 9:22 PM
 */
public class Solution45 {

    Map<Integer, Integer> cached = new HashMap<>();

    public int jump(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int startIndex) {
        if (startIndex >= nums.length - 1) {
            return 0;
        }
        if (cached.containsKey(startIndex)) {
            return cached.get(startIndex);
        }

        int minVal = nums.length;
        if (nums[startIndex] == 0) {
            return minVal;
        }
        for (int i = 1; i <= nums[startIndex]; i++) {
            int t = dfs(nums, startIndex + i) + 1;
            minVal = Math.min(t, minVal);
        }
        cached.put(startIndex, minVal);
        return minVal;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        //[5,9,3,2,1,0,2,3,3,1,0,0]
        int ans = solution45.jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        System.out.println(ans);
    }
}
