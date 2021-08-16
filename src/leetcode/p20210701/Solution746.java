package leetcode.p20210701;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/1
 * @time 10:33 PM
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        int[] dp=new int[len+1];
        dp[0]=0;
        dp[1]=0;

        for (int i=2;i<=cost.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }

        return dp[len];
    }

    public static void main(String[] args){
        Solution746 solution746=new Solution746();
        int min1=solution746.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(min1);
        int min2=solution746.minCostClimbingStairs(new int[]{10,15,20});
        System.out.println(min2);
    }
}
