package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 10:31 PM
 */
public class TicTacToe {
    private char[][] grid;
    private int      size;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {

        this.size = n;
        this.grid = new char[size][size];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '0');
        }
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {

        char pattern = 'X';
        if (player == 2) {
            pattern = 'O';
        }
        grid[row][col] = pattern;

        for (int i = 0; i < size; i++) {
            char first = grid[i][0];
            if (first == '0') {
                continue;
            }
            boolean flag = true;
            for (int j = 1; j < size; j++) {
                if (grid[i][j] != first) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (first == 'X') {
                    return 1;
                } else {
                    return 2;
                }
            }
        }

        for (int j = 0; j < size; j++) {
            char first = grid[0][j];
            if (first == '0') {
                continue;
            }
            boolean flag = true;
            for (int i = 1; i < size; i++) {
                if (grid[i][j] != first) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (first == 'X') {
                    return 1;
                } else {
                    return 2;
                }
            }
        }

        boolean flag = true;
        for (int i = 1; i < size; i++) {
            if (grid[0][0] == '0') {
                flag = false;
                break;
            }
            if (grid[i][i] != grid[0][0]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            if (grid[0][0] == 'X') {
                return 1;
            } else {
                return 2;
            }
        }


        flag = true;
        char temp = grid[0][size - 1];
        if (temp != '0') {
            for (int i = 1; i < size; i++) {
                if (grid[i][size - 1 - i] == '0') {
                    flag = false;
                    break;
                }
                if (grid[i][size - 1 - i] != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (temp == 'X') {
                    return 1;
                } else {
                    return 2;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        int       ans       = -1;
        ans = ticTacToe.move(0, 0, 1);
        System.out.println(ans);
        ans = ticTacToe.move(0, 2, 2);
        System.out.println(ans);
        ans = ticTacToe.move(2, 2, 1);
        System.out.println(ans);
    }
}
