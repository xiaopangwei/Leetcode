package leetcode.p20210703;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/5
 * @time 2:32 PM
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;

        int[][] ans=new int[rows][cols];

        int firstCol=-1;
        for (int i=0;i<rows;i++){
            if (obstacleGrid[i][0]==1){
               ans[i][0]=0;
               firstCol=i;
               break;
            }else{
                ans[i][0]=1;
            }
        }
        if (firstCol>=0) {
            for (int i = firstCol + 1; i < rows; i++) {
                ans[i][0] = 0;
            }
        }

        int firstRow=-1;
        for (int i=0;i<cols;i++){
            if (obstacleGrid[0][i]==1){
                ans[0][i]=0;
                firstRow=i;
                break;
            }
            else{
                ans[0][i]=1;
            }
        }
        if (firstRow>=0) {
            for (int i = firstRow + 1; i < cols; i++) {
                ans[0][i]=0;
            }
        }


        for (int i=1;i<rows;i++){
            for (int j=1;j<cols;j++){

                int left=ans[i][j-1];
                int up=ans[i-1][j];
                if(obstacleGrid[i][j]==1)
                {
                    ans[i][j] = 0;
                }
                else{
                    if (obstacleGrid[i][j - 1] == 0 && obstacleGrid[i - 1][j] == 0) {
                        ans[i][j] = left + up;
                    } else if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 0) {
                        ans[i][j] = up;
                    } else if (obstacleGrid[i][j - 1] == 0 && obstacleGrid[i - 1][j] == 1) {
                        ans[i][j] = left;
                    } else {
                        ans[i][j] = 0;
                    }
                }
            }
        }

        return ans[rows-1][cols-1];
    }

    public static void main(String[] args){
        Solution63 solution63=new Solution63();
//
        int ans=solution63.uniquePathsWithObstacles(new int[][]{ {0,0},{0,1}});
        System.out.println(ans);

    }
}
