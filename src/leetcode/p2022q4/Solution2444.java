package leetcode.p2022q4;

import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/24
 * @time 9:30 PM
 */
public class Solution2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int                       left    = 0;
        int                       right   = 0;
        long                      ans     = 0;
        while (right < nums.length) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);

            if (treeMap.firstEntry().getKey() == minK &&
                    treeMap.lastEntry().getKey() == maxK) {
                ans++;
                System.out.println(left + " " + right);
                right++;
            } else {
                while (left < right && (treeMap.firstEntry().getKey() != minK
                        || treeMap.lastEntry().getKey() != maxK)) {
                    if (treeMap.getOrDefault(nums[left], 0) > 1) {
                        treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                    } else {
                        treeMap.remove(nums[left]);
                    }
                    left++;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2444 solution2444 = new Solution2444();
        long         ans          = solution2444.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5);
        System.out.println(ans);
    }
}
