package leetcode.p2022m05.day0515;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/15
 * @time 10:06 PM
 */
public class Solution325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int                   maxLen      = 0;
        int[]                 prefixSum   = new int[nums.length + 1];
        Map<Integer, Integer> earliestPos = new HashMap<>();
        earliestPos.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = nums[i] + prefixSum[i];
            if (!earliestPos.containsKey(prefixSum[i + 1])) {
                earliestPos.put(prefixSum[i + 1], i + 1);
            }
        }
        for (int i = 0; i < prefixSum.length; i++) {
            int target = prefixSum[i] - k;
            if (earliestPos.containsKey(target)) {
                int left = earliestPos.get(target);
                maxLen = Math.max(maxLen, i - left);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution325 solution325 = new Solution325();
        int         len         = solution325.maxSubArrayLen(new int[]{-1, 1}, -1);
        System.out.println(len);
    }
}
