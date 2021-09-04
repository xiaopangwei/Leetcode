package leetcode.p2021m09;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/3
 * @time 5:07 PM
 */
public class Solution487 {
    int maxValue = 0;

    public int findMaxConsecutiveOnes(int[] nums) {

        int[] left = new int[nums.length];
        f(nums, left);

        int[] right = new int[nums.length];


        g(nums, right);


//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));


        for (int i = 0; i < nums.length; i++) {

            int t1 = 0;
            if (i > 0) {
                t1 = left[i - 1];
            }
            int t2 = 0;
            if (i < nums.length - 1) {
                t2 = right[i + 1];
            }
            if (nums[i] == 0) {
                maxValue = Math.max(maxValue, t1 + t2 + 1);
            }
        }

        return maxValue;
    }

    private void f(int[] nums, int[] left) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i > 0) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            } else {
                left[i] = 0;
            }
            maxValue = Math.max(maxValue, left[i]);
        }
    }

    private void g(int[] nums, int[] right) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                if (i < nums.length - 1) {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = 1;
                }
            } else {
                right[i] = 0;
            }
            maxValue = Math.max(maxValue, right[i]);
        }
    }

    public static void main(String[] args) {
        Solution487 solution487 = new Solution487();
        int[]       array       = new int[]{1,1,1,1,1};
        int         ans         = solution487.findMaxConsecutiveOnes(array);
        System.out.println(ans);
    }
}
