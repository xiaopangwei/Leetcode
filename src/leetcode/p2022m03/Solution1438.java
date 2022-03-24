package leetcode.p2022m03;

import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/16
 * @time 9:50 PM
 */
public class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> freq   = new TreeMap<>();
        int                       left   = 0;
        int                       right  = 0;
        int                       maxVal = 0;

        while (right < nums.length) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            while (left < right && freq.lastKey() - freq.firstKey() > limit) {
                int f = freq.get(nums[left]);
                if (f - 1 > 0) {
                    freq.put(nums[left], f - 1);
                } else {
                    freq.remove(nums[left]);
                }
                left++;
            }
            maxVal = Math.max(maxVal, right - left + 1);
            right++;
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution1438 solution1438 = new Solution1438();
        int          ans          = solution1438.longestSubarray(new int[]{8, 2, 4, 7}, 4);
        System.out.println(ans);
    }
}
