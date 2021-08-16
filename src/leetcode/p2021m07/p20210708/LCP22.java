package leetcode.p2021m07.p20210708;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/12
 * @time 10:37 PM
 */
public class LCP22 {
    private int count=0;
    private int black=1;
    public int paintingPlan(int n, int k) {

//        int[][] grid=new int[n][n];
        return 0;
    }

    private int getOnes(int[][] grid){
        int cnt=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                  cnt++;
                }
            }
        }
        return cnt;
    }

//    private boolean isRowAllBlack(int[][] grid,int rowId){
//        int[] array=grid[rowId];
//        for (int item:array){
//            if (item==0){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean isRowAllBlack(int[][] grid,int rowId){
//        int[] array=grid[rowId];
//        for (int item:array){
//            if (item==0){
//                return false;
//            }
//        }
//        return true;
//    }

    private boolean isColsAllBlack(int[][] grid,int colId){
        for (int i=0;i<grid.length;i++){
            if (grid[i][colId]==0){
                return false;
            }
        }
        return true;
    }

    private void dfs(int[][] grid,final int k,final int n){

        if (getOnes(grid)==k){
            count++;
            return;
        }

        for (int i=0;i<2*n;i++){
            if (i<n){

            }else{

            }
        }


    }
}
