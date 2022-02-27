package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/15
 * @time 9:18 PM
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        //[1，2，4，4，4，6]

        int index = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[index--];
        }

        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[index--];
        }
    }

    public static void main(String[] args) {
        Solution324 solution324 = new Solution324();
        solution324.wiggleSort(new int[]{1, 2, 3, 4, 5, 6});
    }
}
