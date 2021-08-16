package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 2:43 PM
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {

        int len = nums.length;
        int j   = len - 1;
        int i   = j - 1;

        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        int startIdx = i + 1;
        if (i >= 0) {
            int minValue = nums[j];
            int minIndex = j;
            for (int k = startIdx; k < len; k++) {
                if (nums[k] > nums[i] && nums[k] <= minValue) {
                    minValue = nums[k];
                    minIndex = k;
                }
            }
            swap(nums, i, minIndex);
        }


        int endIndex = len - 1;
        while (startIdx < endIndex) {
            swap(nums, startIdx, endIndex);
            startIdx++;
            endIndex--;
        }
    }

    private void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }


    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[]      array      = new int[]{1,2};
        for (int i = 0; i < 7; i++) {
            solution31.nextPermutation(array);
            System.out.println(Arrays.toString(array));
        }
    }
}
