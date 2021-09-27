package leetcode.p2021m09;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/26
 * @time 1:23 PM
 */
public class Solution723 {
    public int[][] candyCrush(int[][] board) {

        int         m       = board.length;
        int         n       = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int round=0;
        while (true) {
            //同行不同列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {

                        int t = j;

                        int type = board[i][t];

                        int count = 0;

                        while (t < n) {
                            if (board[i][t] == type) {
                                t++;
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count >= 3) {
                            for (int k = j; k < t; k++) {
                                visited[i][k] = true;
                            }
                        }
                    }
                }
            }

            //同列不同行

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (board[i][j] != 0) {

//                        System.out.println(i + " " + j + " " + board[i][j]);
                        int t = i;

                        int type = board[t][j];

                        int count = 0;

                        while (t < m) {
                            if (board[t][j] == type) {
                                t++;
                                count++;
                            } else {

                                break;
                            }
                        }
                        if (count >= 3) {
                            for (int k = i; k < t; k++) {
                                visited[k][j] = true;
                            }
                        }
                    }
                }
            }

            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) {
                break;
            }

            round++;
            System.out.println(round);
            for (int j = 0; j < n; j++) {
                int i     = m - 1;
                int count = 0;
                while (i >= 0) {
                    if (visited[i][j]) {
                        count++;
                        board[i][j] = 0;
                        visited[i][j] = false;
                    } else {
                        if (count != 0) {
                            board[i + count][j] = board[i][j];
                            board[i][j] = 0;
                        }
                    }
                    i--;
                }
            }

        }
        return board;

    }

    public static void main(String[] args) {
        Solution723 solution723 = new Solution723();
        int[][] array = new int[][]{{1,3,5,5,2},{3,4,3,3,1},{3,2,4,5,2},{2,4,4,5,5},{1,4,4,1,1}};
        int[][] res = solution723.candyCrush(array);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

}
