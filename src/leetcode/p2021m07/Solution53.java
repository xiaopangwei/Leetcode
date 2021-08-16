package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/22
 * @time 4:16 PM
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {

        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int maxVal=nums[0];
        for (int i=1;i<nums.length;i++){
            if (dp[i-1]<=0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]+nums[i];
            }
            maxVal=Math.max(maxVal,dp[i]);
        }
        return maxVal;
    }

    public static void main(String[] args){
        Solution53 solution53=new Solution53();
        System.out.println(solution53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
