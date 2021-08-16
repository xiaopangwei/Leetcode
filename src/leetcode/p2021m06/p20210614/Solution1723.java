package leetcode.p2021m06.p20210614;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/17
 * @time 4:58 PM
 */
public class Solution1723 {
    public int[] findSquare(int[][] matrix) {

        int[][] dp=new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
//                    dp[]
                }
            }

        }
            return null;
    }

    private boolean isAllMatrix(int[][] matrix,int r,int c,int size){
        return false;
    }

    private boolean isAllBlack(int[][] matrix,int r,int c,int size){
        for (int i=0;i<r+size;i++) {
            for (int j = 0; j < c + size; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
