package leetcode.p2022m05.day0514;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 3:50 PM
 */
public class Solution493 {
    int ans = 0;

    public int reversePairs(int[] nums) {
        System.out.println(Arrays.toString(nums));
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return ans;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            long a = (long) nums[i];
            long b = 2 * (long)(nums[j]);
            if (a > b) {
                ans += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }
        merge(nums, left, mid, mid + 1, right);
    }

    private void merge(int[] nums, int start1, int end1, int start2, int end2) {
        int[] temp  = new int[end2 - start1 + 1];
        int   i     = start1;
        int   j     = start2;
        int   index = 0;
        while (i <= end1 && j <= end2) {
            if (nums[i] > nums[j]) {
                temp[index++] = nums[j++];
            } else {
                temp[index++] = nums[i++];
            }
        }
        while (i <= end1) {
            temp[index++] = nums[i++];
        }
        while (j <= end2) {
            temp[index++] = nums[j++];
        }
        for (int t = 0; t < temp.length; t++) {
            nums[t + start1] = temp[t];
        }
    }

    public static void main(String[] args) {
        Solution493 solution493 = new Solution493();
        int         ans         = solution493.reversePairs(new int[]{2, 4, 3, 5, 1});
        System.out.println(ans);
    }
}
