package leetcode.p2022m05.day0509;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 9:39 PM
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {

        List<Integer> list = new ArrayList<>();
        int           x    = 0;
        int           y    = 0;


        while (list.size() != mat.length * mat[0].length) {
            while (isValid(mat, x, y)) {
                list.add(mat[x][y]);
                System.out.println(mat[x][y]);
                x--;
                y++;

            }

            if (!isValid(mat, x, y)) {
                x++;
                if (!isValid(mat, x, y)) {
                    x++;
                    y--;
                }
            }


            while (isValid(mat, x, y)) {
                list.add(mat[x][y]);
                System.out.println(mat[x][y]);
                x++;
                y--;

            }
            if (!isValid(mat, x, y)) {
                y++;
                if (!isValid(mat, x, y)) {
                    x--;
                    y++;
                }
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }


    private boolean isValid(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution498 solution498 = new Solution498();
        int[]       ans         = solution498.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(ans));
    }

}
