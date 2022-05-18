package leetcode.p2022m05.day0507;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 2:13 PM
 */
public class Solution289 {
    int[][] directions = new int[][]{{-1, 0}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public void gameOfLife(int[][] board) {

        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = board[i].clone();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int t = getResult(copy, i, j);
                board[i][j] = t;
            }
        }
    }


    private int getResult(int[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length) {
                continue;
            }

            if (board[newX][newY] == 1) {
                cnt++;
            }
        }

        if (board[x][y] == 1) {
            if (cnt < 2 || cnt > 3) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (cnt == 3) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution289 solution289 = new Solution289();
        //[0,1,0],[0,0,1],[1,1,1],[0,0,0]
        int[][] copy = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

        for (int i = 0; i < copy.length; i++) {
            System.out.println(Arrays.toString(copy[i]));
        }

    }
}
