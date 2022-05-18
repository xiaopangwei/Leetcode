package leetcode.p2022m05.day0507;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 1:46 PM
 */
public class Solution1275 {
    public String tictactoe(int[][] moves) {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(matrix[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                matrix[moves[i][0]][matrix[i][1]] = 1;
            } else {
                matrix[moves[i][0]][matrix[i][1]] = 2;
            }
        }


        if (isOk(matrix, 1)) {
            return "A";
        } else if (isOk(matrix, 2)) {
            return "B";
        } else if (matrix.length >= 9) {
            return "Draw";
        } else {
            return "Pending";
        }

    }


    private boolean isOk(int[][] matrix, int target) {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == target && matrix[i][1] == target && matrix[i][2] == target) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (matrix[0][i] == target && matrix[1][i] == target && matrix[2][i] == target) {
                return true;
            }
        }

        if (matrix[0][0] == target && matrix[1][1] == target && matrix[2][2] == target) {
            return true;
        }

        if (matrix[0][2] == target && matrix[1][1] == target && matrix[2][0] == target) {
            return true;
        }

        return false;
    }
}
