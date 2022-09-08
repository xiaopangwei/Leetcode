package leetcode.p2022m05.day0514;

import java.util.TreeSet;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 11:13 AM
 */
public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int   n        = nums.length;
        int[] minArray = new int[n];
        minArray[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minArray[i] = Math.min(minArray[i], nums[i]);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            treeSet.add(nums[i]);
            if (minArray[i] >= nums[i]) {
                continue;
            }
            Integer t = treeSet.lower(nums[i]);
            if (t != null && minArray[i] < t) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] argd) {
        Solution456 solution456 = new Solution456();
        boolean     ans         = solution456.find132pattern(new int[]{3, 1, 4, 2});
        System.out.println(ans);
    }
}
