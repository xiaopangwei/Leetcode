package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/22
 * @time 3:57 PM
 */
public class Solution152 {

    public int maxProduct(int[] nums) {
        int[][] dp=new int[nums.length][2];

        dp[0][0]=nums[0];
        dp[0][1]=nums[0];

        int maxProduct=nums[0];

        for (int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][1]*nums[i],dp[i-1][0]*nums[i]);
            dp[i][0]=Math.max(dp[i][0],nums[i]);
            dp[i][1]=Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]);
            dp[i][1]=Math.min(dp[i][1],nums[i]);
            maxProduct=Math.max(maxProduct,Math.max(dp[i][0],dp[i][1]));
        }

        return maxProduct;
    }

    public static void main(String[] args){
        Solution152 solution152=new Solution152();
        System.out.println(solution152.maxProduct(new int[]{-2,3,-4}));
    }
}
