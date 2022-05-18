package leetcode.p2022m05.day0501;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 2:26 PM
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        //[2,3,5,4,1] => [2,3,1,4,5] => [2,4,1,3,5]
        //[1,2,3,4,5]
        //[5,4,3,2,1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }
        //[0,i]
        //[i+1,len-1]
//        System.out.println(i);
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        reverse(nums, i + 1, nums.length - 1);
        int index = search(nums, i + 1, nums.length - 1, nums[i]);
        swap(nums, index, i);

    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void reverse(int[] array, int i, int j) {
        if (i >= j) {
            return;
        }

        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private int search(int[] array, int i, int j, int target) {
        if (i > j) {
            return -1;
        }

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (array[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        int ans = i;
        return ans;
    }


    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[]      array      = new int[]{1, 1};
        solution31.nextPermutation(array);
        System.out.println(Arrays.toString(array));

    }
}
