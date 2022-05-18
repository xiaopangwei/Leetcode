package leetcode.p2022m05.day0513;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/13
 * @time 10:35 PM
 */
public class Solution338 {
    public int[] countBits(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            int t=i&1;
            dp[i]=dp[i>>1];
            if (t==1){
                dp[i]+=1;
            }
        }
        return dp;
    }

    public static void main(String[] args){
        Solution338 solution338=new Solution338();
        int[] ans=solution338.countBits(5);
        System.out.println(Arrays.toString(ans));
    }
}
