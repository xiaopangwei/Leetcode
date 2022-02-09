package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/8
 * @time 9:08 PM
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        //[2,0,2,2,3,1,1,2,0,3]
        //[0,0,1,1,2,2]
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[index4++] = 3;
                nums[index3++] = 2;
                nums[index2++] = 1;
                nums[index1++] = 0;
            } else if (nums[i] == 1) {
                nums[index4++] = 3;
                nums[index3++] = 2;
                nums[index2++] = 1;
            } else if (nums[i] == 2) {
                nums[index4++] = 3;
                nums[index3++] = 2;
            } else {
                nums[index4++] = 3;
            }
        }
    }

    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        int[]      array      = new int[]{2,0,2,2,3,1,1,2,0,3,3};
        solution75.sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}
