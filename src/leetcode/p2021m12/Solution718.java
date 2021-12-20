package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/17
 * @time 10:34 PM
 */
public class Solution718 {

    int[][] dp;
    int ans = Integer.MIN_VALUE;

    public int findLength(int[] nums1, int[] nums2) {


        dp = new int[nums1.length + 1][nums2.length + 1];

        getMax(nums1, nums2);

        return ans;
    }


    private void getMax(final int[] nums1, final int[] nums2) {

        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }


    }

    public static void main(String[] args) {
        Solution718 solution718 = new Solution718();
        int         ans         = solution718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        System.out.println(ans);
    }
}
