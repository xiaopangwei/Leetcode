package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/22
 * @time 4:43 PM
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {

        if (amount==0){return 0;}
        int[] dp=new int[amount+1];
        dp[0]=0;
        for (int j=1;j<=amount;j++) {
            int minVal=Integer.MAX_VALUE;
            for (int i=0;i<coins.length;i++){
                if (coins[i] > j) {
                    continue;
                }
                int temp=dp[j - coins[i]];
                if (temp!=Integer.MAX_VALUE)
                {
                    minVal = Math.min(temp+ 1, minVal);
                }

//                System.out.println(j+" "+coins[i]+" "+minVal);
            }
            dp[j]=minVal;
        }

        if (dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];

    }

    public static void main(String[] args){
        Solution322 solution322=new Solution322();
        System.out.println(solution322.coinChange(new int[]{1, 2, 5},11));
    }
}
