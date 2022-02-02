package leetcode.springfestival.sf20220130;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 10:09 AM
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length==0){
            return new int[]{};
        }
        int cols = mat[0].length;
        int rows = mat.length;

        int count    = 0;
        int maxCount = cols * rows;

        int     x         = 0;
        int     y         = 0;
        int[]   ans       = new int[maxCount];
        int     index     = 0;
        boolean direction = true;
        while (count < maxCount) {
            if (direction) {
                while (isValid(mat, x, y)) {
                    ans[index++] = mat[x][y];
                    count++;
                    x--;
                    y++;
                }
                x++;
                if (!isValid(mat,x,y)){
                    x++;
                    y--;
                }
                direction=false;
            } else {
                while (isValid(mat, x, y)) {
                    ans[index++] = mat[x][y];
                    count++;
                    x++;
                    y--;
                }
                y++;
                if (!isValid(mat,x,y)){
                    x--;
                    y++;
                }
                direction=true;
            }
        }

        return ans;
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution498 solution498 = new Solution498();
        int[]       ans         = solution498.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6}});
        System.out.println("res"+Arrays.toString(ans));
    }
}
