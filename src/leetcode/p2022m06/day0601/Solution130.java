package leetcode.p2022m06.day0601;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/5
 * @time 10:18 PM
 */
public class Solution130 {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        int          m    = board.length;
        int          n    = board[0].length;
        Queue<int[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                list.add(new int[]{0, i});
                board[0][i] = 'N';
            }
            if (board[m - 1][i] == 'O') {
                list.add(new int[]{m - 1, i});
                board[m - 1][i] = 'N';
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                list.add(new int[]{i, 0});
                board[i][0] = 'N';
            }
            if (board[i][n - 1] == 'O') {
                list.add(new int[]{i, n - 1});
                board[i][n - 1] = 'N';
            }
        }

        while (!list.isEmpty()) {
            int[] t = list.poll();
            for (int i = 0; i < directions.length; i++) {
                int newX = t[0] + directions[i][0];
                int newY = t[1] + directions[i][1];
                if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                    continue;
                }
                if (board[newX][newY] != 'O') {
                    continue;
                }
                board[newX][newY] = 'N';
                list.add(new int[]{newX, newY});
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        //[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
        char[][]    array       = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Solution130 solution130 = new Solution130();
        solution130.solve(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
