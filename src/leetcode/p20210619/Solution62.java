package leetcode.p20210619;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/19
 * @time 11:33 PM
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {

        int[][] dp=new int[m][n];
        dp[0][0]=0;
        for (int i=1;i<m;i++)
        {
            dp[i][0]=1;
        }
        for (int i=1;i<n;i++)
        {
           dp[0][i]=1;
        }

        for (int i=1;i<m;i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        Solution62 solution62=new Solution62();
        System.out.println(solution62.uniquePaths(3,7));
    }

}
