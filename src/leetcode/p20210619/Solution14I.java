package leetcode.p20210619;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/24
 * @time 4:26 PM
 */
public class Solution14I {
    public int cuttingRope(int n) {
        if (n==0) return 0;
        if (n==1) return 0;
        if (n==2) return 1;
        if (n==3) return 2;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i=4;i<=n;i++){
            int max=Integer.MIN_VALUE;
            for (int k=1;k<=i/2;k++)
            {
                max=Math.max(max,dp[k]*dp[i-k]);
            }
            System.out.println(i+" "+max);
            dp[i]=max;
        }
        return dp[n];
    }



    public static void main(String[] args){
        Solution14I solution14 =new Solution14I();
        System.out.println(solution14.cuttingRope(3));
        System.out.println(solution14.cuttingRope(10));
    }
}
