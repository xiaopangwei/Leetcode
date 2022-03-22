package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/27
 * @time 9:25 PM
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int x = 0;
        int y = matrix[0].length - 1;

        while (true) {
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                break;
            }
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }

        return false;
    }
}
