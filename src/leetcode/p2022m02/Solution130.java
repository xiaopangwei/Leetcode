package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/23
 * @time 8:36 PM
 */
public class Solution130 {
    public void solve(char[][] board) {


        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, '#');
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i, '#');
            }
        }


        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, '#');
            }

            if (board[i][board[i].length - 1] == 'O') {
                dfs(board, i, board[i].length - 1, '#');
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int x, int y, final char filled) {
        if (board[x][y] == 'O') {
            board[x][y] = filled;
        }

        if (isValid(board, x + 1, y) && board[x + 1][y] == 'O') {
            dfs(board, x + 1, y, filled);
        }

        if (isValid(board, x - 1, y) && board[x - 1][y] == 'O') {
            dfs(board, x - 1, y, filled);
        }

        if (isValid(board, x, y + 1) && board[x][y + 1] == 'O') {
            dfs(board, x, y + 1, filled);
        }

        if (isValid(board, x, y + 1) && board[x][y + 1] == 'O') {
            dfs(board, x, y + 1, filled);
        }


    }

    private boolean isValid(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution130 solution130 = new Solution130();
        char[][]    array       = new char[][]{{'X', 'X', 'X', 'X' }, {'X', 'O', 'O', 'X' }, {'X', 'X', 'O', 'X' }, {'X', 'O', 'X', 'X' }};
        solution130.solve(array);
        for (char[] item : array) {
            System.out.println(Arrays.toString(item));
        }
    }
}
