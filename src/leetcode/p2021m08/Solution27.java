package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 5:40 PM
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {

        int i     = 0;
        int j     = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }

        return j+1;

    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[]      array      = new int[]{3, 2, 2, 3};
        int        ans        = solution27.removeElement(array, 3);
        System.out.println(Arrays.toString(array));
        System.out.println(ans);

    }
}
