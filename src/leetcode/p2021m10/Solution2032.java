package leetcode.p2021m10;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/11
 * @time 10:16 PM
 */
public class Solution2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Set<Integer>> freq = new HashMap<>();
        for (int item : nums1) {
            if (!freq.containsKey(item)) {
                freq.put(item, new HashSet<>());
            }
            freq.get(item).add(1);
        }
        for (int item : nums2) {
            if (!freq.containsKey(item)) {
                freq.put(item, new HashSet<>());
            }
            freq.get(item).add(2);
        }
        for (int item : nums3) {
            if (!freq.containsKey(item)) {
                freq.put(item, new HashSet<>());
            }
            freq.get(item).add(3);
        }

        List<Integer> data = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : freq.entrySet()) {
            if (entry.getValue().size() >= 2) {
                data.add(entry.getKey());
            }
        }

        return data;
    }

    public static void main(String[] args) {
        Solution2032  solution2032 = new Solution2032();
        List<Integer> ans          = solution2032.twoOutOfThree(new int[]{2,2,1}, new int[]{4,3, 3}, new int[]{5});
        System.out.println(ans);
    }
}
