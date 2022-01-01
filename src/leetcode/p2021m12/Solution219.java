package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/27
 * @time 8:35 PM
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map   = new HashMap<>();
        int                   left  = 0;
        int                   right = k + 1;
        int                   t     = Math.min(k + 1, nums.length);
        for (int i = 0; i < t; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        while (right < nums.length) {

            int l = nums[left];
            map.put(l, map.get(l) - 1);
            left++;


            int r = nums[right];
            if (map.getOrDefault(r, 0) >= 1) {
                return true;
            }
            map.put(r, map.getOrDefault(r, 0) + 1);
            right++;

        }
        return false;
    }

    public static void main(String[] args) {
        Solution219 solution219 = new Solution219();
        boolean     ans         = solution219.containsNearbyDuplicate(new int[]{1, 2}, 2);
        System.out.println(ans);
    }
}
