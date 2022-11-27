package leetcode.p2022q4;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/22
 * @time 10:05 PM
 */
public class Solution2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int                   left  = 0;
        int                   right = 0;
        int                   sum   = 0;
        Map<Integer, Integer> freq  = new HashMap<>();
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }
        int maxAns = 0;
        if (freq.keySet().size() == k) {
            maxAns = Math.max(maxAns, sum);
        }

        right = k;
        while (right < nums.length) {

            sum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right],0) + 1);

            sum -= nums[left];

            if (freq.getOrDefault(nums[left], 0) > 1) {
                freq.put(nums[left], freq.get(nums[left] - 1));
            } else {
                freq.remove(nums[left]);
            }
            left++;
            if (freq.keySet().size() == k) {
                maxAns = Math.max(maxAns, sum);
            }
            right++;
        }
        return maxAns;
    }

    public static void main(String[] args) {
        Solution2461 solution2461 = new Solution2461();
        System.out.println(solution2461.maximumSubarraySum(new int[]{4,4,4}, 3));
    }
}
