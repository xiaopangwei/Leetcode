package leetcode.p20210708;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/12
 * @time 11:02 PM
 */
public class LCP09 {
    public int minJump(int[] jump) {

        int len=jump.length;

        int[] dp=new int[len];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=1;

        for (int i=1;i<len;i++){
            int minVal=Integer.MAX_VALUE;
            for (int j=0;j<i;j++){
                if (j+jump[j]>=i+1){
                    minVal=Math.min(minVal,dp[j]+1);
                }
            }
            System.out.println("update dp["+i+"] "+" "+minVal);
            dp[i]=minVal;

            if (minVal!=Integer.MAX_VALUE) {
                for (int j = i - 1; j >= 0; j--) {
                    if (minVal + 1 < dp[j]) {
                        dp[j]=minVal+1;
                        System.out.println("update dp["+j+"] "+" "+(minVal+1));
                    }
                }
            }
        }

        return dp[len-1];
    }

    public static void main(String[] args){
        LCP09 lcp09=new LCP09();
        System.out.println(lcp09.minJump(new int[]{2,5,1,1}));
    }
}
