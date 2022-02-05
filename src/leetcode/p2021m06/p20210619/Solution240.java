package leetcode.p2021m06.p20210619;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/19
 * @time 2:58 PM
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length - 1;
        int y = 0;

        while (true) {
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                return false;
            }
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
    }


    public static void main(String[] args) {
        int[][]     matrix      = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Solution240 solution240 = new Solution240();
        System.out.println(solution240.searchMatrix(matrix, 100));

    }


}
