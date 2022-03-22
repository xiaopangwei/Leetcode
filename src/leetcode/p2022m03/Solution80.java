package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/27
 * @time 9:36 PM
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int i     = 0;
        int index = 0;
        while (i < nums.length) {
            int temp = nums[i];
            int j    = i + 1;
            while (j < nums.length && nums[j] == temp) {
                j++;
            }

            int duplicated = j - i;
            int len        = Math.min(2, duplicated);
            for (int t = 0; t < len; t++) {
                nums[index++] = nums[i + t];
            }
            i = j;

        }
        return index;
    }

    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        int[]      array      = new int[]{0,0,1,1,1,1,2,3,3};
        int        ans        = solution80.removeDuplicates(array);
        System.out.println(ans);
        System.out.println(Arrays.toString(array));

    }
}
