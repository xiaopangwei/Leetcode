package leetcode.p2022m05.day0515;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/15
 * @time 9:56 PM
 */
public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int   n     = nums.length;
        int[] left  = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
        right[right.length - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        for (int i = 0; i < n; i++) {
            if (left[i] < right[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution915 solution915 = new Solution915();
        int         left        = solution915.partitionDisjoint(new int[]{5, 0, 3, 8, 6});
        System.out.println(left);
    }
}
