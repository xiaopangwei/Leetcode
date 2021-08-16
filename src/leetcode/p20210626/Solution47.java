package leetcode.p20210626;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/26
 * @time 11:09 AM
 */
public class Solution47 {
    public int maxValue(int[][] grid) {
        int rowLen=grid.length;
        int colLen=grid[0].length;

        int[][] dp=new int[rowLen][colLen];

        dp[0][0]=grid[0][0];
        for (int i=1;i<rowLen;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for (int i=1;i<colLen;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for (int i=1;i<rowLen;i++){
            for (int j=1;j<colLen;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[rowLen-1][colLen-1];
    }

    public static void main(String[] args){
        Solution47 solution47=new Solution47();
        int[][] matrix=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution47.maxValue(matrix));
    }
}
