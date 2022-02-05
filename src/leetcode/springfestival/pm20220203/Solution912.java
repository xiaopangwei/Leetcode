package leetcode.springfestival.pm20220203;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 4:55 PM
 */
public class Solution912 {
    public int[] sortArray(int[] nums) {
        sort2(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort2(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = (i + j) / 2;
        sort2(nums, i, mid);
        sort2(nums, mid + 1, j);
        merge(nums, i, mid, mid + 1, j);
    }

    private void merge(int[] nums, int s1, int e1, int s2, int e2) {
        int[] temp  = new int[e1 - s1 + 1 + e2 - s2 + 1];
        int   i     = s1;
        int   j     = s2;
        int   index = 0;
        while (i <= e1 && j <= e2) {
            if (nums[i] < nums[j]) {
                temp[index++] = nums[i++];
            } else if (nums[i] > nums[j]) {
                temp[index++] = nums[j++];
            } else {
                temp[index++] = nums[i++];
                temp[index++] = nums[j++];
            }
        }

        while (i <= e1) {
            temp[index++] = nums[i++];
        }

        while (j <= e2) {
            temp[index++] = nums[j++];
        }

        for (int t = 0; t < temp.length; t++) {
            nums[s1 + t] = temp[t];
        }
    }

    private void sort1(int[] nums, int i, int j) {
        if (i > j) {
            return;
        }
        int left  = i;
        int right = j;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, left, i);
        sort1(nums, i, left - 1);
        sort1(nums, left + 1, j);
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
        Solution912 solution912 = new Solution912();
        int[]       ans         = solution912.sortArray(new int[]{8,3,2,10,1});
        System.out.println(Arrays.toString(ans));
    }


}
