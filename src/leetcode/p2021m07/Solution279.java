package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 2:43 PM
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i=1;i<=n;i++){
            int minVal=Integer.MAX_VALUE;
            for (int j=1;j<=100;j++){
                if (j*j>i){
                    break;
                }else{
                    minVal=Math.min(dp[i-j*j]+1,minVal);
                }
            }
            dp[i]=minVal;
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution279 solution279=new Solution279();
        int n=solution279.numSquares(9999);
        System.out.println(n);
    }
}
