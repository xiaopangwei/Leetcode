package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 10:45 AM
 */
public class Solution122 {
    public int maxProfit(int[] prices) {

        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;

        for (int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][1]-prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }

        int ans=dp[prices.length-1][1];
//        System.out.println(Arrays.toString(prices));
//        for (int i=0;i<prices.length;i++){
//            System.out.println(dp[i][0]+" : "+dp[i][1]);
//        }
        return ans;
    }

    public static void main(String[] args){
        Solution122 solution122=new Solution122();
        solution122.maxProfit(new int[]{7,1,5,3,6,4});
    }
}
