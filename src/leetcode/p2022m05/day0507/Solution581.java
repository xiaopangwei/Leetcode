package leetcode.p2022m05.day0507;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 2:59 PM
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];

        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }

//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] != nums[i]) {
                end = i;
            }
        }

        int start = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (right[i] != nums[i]) {
                start = i;
            }
        }


        if (start == -1 || end == -1) {
            return 0;
        } else {
            return end - start + 1;
        }

    }

    public static void main(String[] args) {
        Solution581 solution581 = new Solution581();
        int         ans         = solution581.findUnsortedSubarray(new int[]{1,2,3,4});
        System.out.println(ans);
    }
}
