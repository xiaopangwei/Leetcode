package common.sorting;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/16
 * @time 11:05 PM
 */
public class QuickSort {

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;

        int pivot = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, left, i);
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }


    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    public static void main(String[] args) {
        QuickSort sort  = new QuickSort();
        int[]     array = new int[]{-10, -20, 9, 0, 8, 7, 1, 3, 2};
        sort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
