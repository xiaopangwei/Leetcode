package leetcode.p2022m05.day0505;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 11:02 PM
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int minAbsVal       = Integer.MAX_VALUE;
        int threeSumClosest = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int gap = Math.abs(target - sum);
                if (gap < minAbsVal) {
                    threeSumClosest = sum;
                    minAbsVal=gap;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return threeSumClosest;
    }

    public static void main(String[] args) {
        int[]      array      = new int[]{1,1,1,0};
        Solution16 solution16 = new Solution16();
        int        s          = solution16.threeSumClosest(array, -100);
        System.out.println(s);
    }
}
