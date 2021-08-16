package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 10:14 AM
 */
public class Solution198 {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            int acc=0;
            if (i>=2){
               acc=dp[i-2];
            }
            dp[i]=Math.max(acc+nums[i],dp[i-1]);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }

    public static void main(String[] args){
        Solution198 solution198=new Solution198();
        int ans=solution198.rob(new int[]{8});
        System.out.println(ans);
    }
}
