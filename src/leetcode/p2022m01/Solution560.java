package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/17
 * @time 10:05 PM
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int                   prefixSum = 0;
        Map<Integer, Integer> map       = new HashMap<>();
        map.put(0, 1);
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int target = prefixSum - k;

            ans += map.getOrDefault(target, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;

    }

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        int         cnt         = solution560.subarraySum(new int[]{2, 2, 2,2}, 4);
        System.out.println(cnt);
    }
}
