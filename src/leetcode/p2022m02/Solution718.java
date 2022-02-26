package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/15
 * @time 10:00 PM
 */
public class Solution718 {
    int[][] dp;

    int maxVal = 0;

    public int findLength(int[] nums1, int[] nums2) {
        dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                maxVal=Math.max(maxVal,dp[i][j]);
            }
        }
        return maxVal;
    }

    public static void main(String[] args){
//        nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
        Solution718 solution718=new Solution718();
        int ans=solution718.findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7});
        System.out.println(ans);
    }

}
