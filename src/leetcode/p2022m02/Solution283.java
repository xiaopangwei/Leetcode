package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/8
 * @time 8:55 PM
 */
public class Solution283 {
    public void moveZeroesRight(int[] nums) {
        //[0,1,0,3,12]
        //[1,3,12,0,0]
        int count = 0;
        int len   = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (count != 0) {
                    nums[i - count] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        for (int i = len - count; i < len; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesLeft(int[] nums) {
        //[0,1,0,3,12]
        //[0,0,1,3,12]
        int count = 0;
        int len   = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (count != 0) {
                    nums[i + count] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[]       array       = new int[]{1,0};
        solution283.moveZeroesLeft(array);
        System.out.println(Arrays.toString(array));
    }
}
