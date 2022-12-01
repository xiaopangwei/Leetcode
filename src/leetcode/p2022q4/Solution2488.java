package leetcode.p2022q4;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/28
 * @time 9:49 PM
 */
public class Solution2488 {
    public int countSubarrays(int[] nums, int k) {

        int   midIndex = -1;
        int[] prefix   = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                prefix[i] = -1;
            } else if (nums[i] == k) {
                midIndex = i;
                prefix[i] = 0;
            } else {
                prefix[i] = 1;
            }
        }

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int ans    = 0;
        int preSum = 0;
        for (int i = 0; i < prefix.length; i++) {
            preSum += prefix[i];
            if (i < midIndex) {
                freq.put(preSum, freq.getOrDefault(preSum, 0) + 1);
            } else {
                ans += freq.getOrDefault(preSum, 0) + freq.getOrDefault(preSum - 1, 0);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution2488 solution2488=new Solution2488();
        System.out.println(solution2488.countSubarrays(new int[]{3,2,1,4,5},4));
    }
}
