package leetcode.p2021m09;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/11
 * @time 11:29 PM
 */
public class Solution137 {
    public int singleNumber(int[] nums) {

        if (nums.length<3){
            return nums[0];
        }

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (i < nums.length - 1) {
                if (nums[i] != nums[i + 2]) {
                    return nums[i];
                } else {
                    i += 3;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution137 solution137 = new Solution137();
        int         ans         = solution137.singleNumber(new int[]{1,1,1,2,3,3,3});
        System.out.println(ans);
    }
}