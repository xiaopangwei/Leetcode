package leetcode.p2022m05.day0510;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 10:27 PM
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[]                 prefixSum      = new int[nums.length + 1];
        Map<Integer, Integer> modLeftmostPos = new HashMap<>();

        modLeftmostPos.put(0, 0);
        for (int i = 1; i < prefixSum.length; i++) {

            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];

            int mod = prefixSum[i] % k;
            if (modLeftmostPos.containsKey(mod)) {
                if (i - modLeftmostPos.get(mod) >= 2) {
                    return true;
                }
            } else {
                modLeftmostPos.put(mod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution523 solution523 = new Solution523();
        boolean     flag        = solution523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6);
        System.out.println(flag);
    }
}
