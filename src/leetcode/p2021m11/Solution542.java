package leetcode.p2021m11;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/21
 * @time 8:41 PM
 */
public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {

        int     m  = mat.length;
        int     n  = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]!=0) {
                    if (isValid(m,n,i-1,j) && dp[i-1][j]!=Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+1);
                    }

                    if (isValid(m,n,i,j-1) && dp[i][j-1]!=Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
                    }


                }
            }
        }

        //dp[i][j]=min{dp[i+1][j],dp[i][j+1]}
        for (int i = m-1; i>=0; i--) {
            for (int j = n-1; j>=0; j--) {
                if (dp[i][j]!=0) {
                    if (isValid(m,n,i+1,j) && dp[i+1][j]!=Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],dp[i+1][j]+1);
                    }

                    if (isValid(m,n,i,j+1) && dp[i][j+1]!=Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],dp[i][j+1]+1);
                    }
                }
            }
        }



        return dp;
    }

    private boolean isValid(final int m,final int n,int i,int j){
        if (i<0||i>=m||j<0||j>=n){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution542 solution542=new Solution542();
        int[][] array=new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] dp=solution542.updateMatrix(array);
        for (int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }

}
