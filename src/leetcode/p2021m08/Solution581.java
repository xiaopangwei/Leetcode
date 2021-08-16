package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/3
 * @time 9:21 AM
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        Arrays.sort(copy);
        int start = -1;
        int end   = -1;
        for (int i = 0; i < len; i++) {
            if (copy[i] != nums[i]) {
                start = i;
                break;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (copy[i] != nums[i]) {
                end = i;
                break;
            }
        }

        if (start == -1 && end == -1) {
            return 0;
        } else {
            return end - start + 1;
        }
    }

    public static void main(String[] args) {
        Solution581 solution581 = new Solution581();
        int         ans         = solution581.findUnsortedSubarray(new int[]{1,3,5,7,8,9});
        System.out.println(ans);
    }
}
