package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/20
 * @time 5:12 PM
 */
public class Solution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int i = 0;
        while (i < arr.length - 1 && arr[i] <= arr[i + 1]) {
            i++;
        }
        int left = i + 1;
        int j = arr.length - 2;
        while (j >= 0 && arr[j] <= arr[j + 1]) {
            j--;
        }
        int right  = j;
        int minLen = arr.length;
        for (int t = 0; t < left; t++) {
            int index = search(arr, right + 1, arr[t]);
            if (index >= 0 && index < arr.length) {
                minLen = Math.min(minLen, index - t - 1);
            }
        }
        int temp= Math.min(minLen, Math.min(arr.length - left, right+1));
        return Math.max(temp,0);
    }

    private int search(int[] nums, int left, int target) {
        int i = left;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        Solution1574 solution1574 = new Solution1574();
        int ans = solution1574.
                findLengthOfShortestSubarray(new int[]{13,0,14,7,18,18,18,16,8,15,20});
        System.out.println(ans);
    }
}