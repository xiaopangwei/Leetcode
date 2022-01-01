package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/27
 * @time 10:36 PM
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp  = new int[nums.length];
        int   max = 0;
        dp[0]=1;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args){
        Solution674 solution674=new Solution674();
        int len=solution674.findLengthOfLCIS(new int[]{2,2,2,2,2});
        System.out.println(len);
    }
}
