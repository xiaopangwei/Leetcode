package leetcode.p2021m12;

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
        int len   = nums.length;
        int left  = 0;
        int right = len;
        while (left +1 < right) {
            int mid = (left+right)/2;
            int gap = nums[mid] - nums[left] - (mid - left);
            if (gap >= k) {
                right = mid;

            } else {
                left = mid;
                k -= gap;
            }
        }

        return nums[left] + k;

    }

    public static void main(String[] args) {
        int[]        array        = new int[]{4, 7, 9, 10};
        Solution1060 solution1060 = new Solution1060();

        int ans = solution1060.missingElement(array, 3);
        System.out.println(ans);
    }
}
