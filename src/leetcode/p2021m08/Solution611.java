package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/4
 * @time 9:16 AM
 */
public class Solution611 {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int k = nums.length - 1; k >= 0; k--) {
            int j = k - 1;
            int i = 0;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count+=(j-i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution611 solution611 = new Solution611();
        int         ans         = solution611.triangleNumber(new int[]{8,8,8,9,10});
        System.out.println(ans);
    }
}
