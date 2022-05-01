package leetcode.p2021m12;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/22
 * @time 9:01 PM
 */
public class Solution1060 {
    public int missingElement(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = 0;
        int missingCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int valueGap = nums[i + 1] - nums[i];
            missingCount = valueGap - 1;
            prefix[i + 1] = prefix[i] + missingCount;
        }
        System.out.println(Arrays.toString(prefix));
        int left  = 0;
        int right = prefix.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (prefix[mid] >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[right] + k - prefix[right];
    }

    public static void main(String[] args) {
        int[]        array        = new int[]{4, 7, 9, 10};
        Solution1060 solution1060 = new Solution1060();

        int ans = solution1060.missingElement(array, 3);
        System.out.println(ans);
    }
}
