package leetcode.p2022m02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/14
 * @time 9:57 PM
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        //行
        Set<Integer> sets = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            sets.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!sets.add(board[i][j] - '0')) {
                    return false;
                }
            }
        }


        for (int i = 0; i < 9; i++) {
            sets.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (!sets.add(board[j][i] - '0')) {
                    return false;
                }
            }
        }


        int[][] pos = new int[9][4];
        // 0 (0,0,2,2)
        // 1 (0,3,2,5)
        // 2 (0,6,2,8)
        // 3 (3,0,5,2)
        // 4 (3,3,5,5)
        // 5 (3,6,5,8)

        int i = 0;
        int x = 0;
        int y = 0;
        while (i < 9) {
            pos[i++] = new int[]{x, y, x + 2, y + 2};
            sets.clear();
            for (int row = x; row <= x + 2; row++) {
                for (int col = y; col <= y + 2; col++) {
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (!sets.add(board[row][col] - '0')) {
                        return false;
                    }
                }
            }
            y += 3;
            if (y >= 9) {
                y = 0;
                x += 3;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        char[][] array = new char[][]{{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        Solution36 solution36 = new Solution36();
        boolean    ans        = solution36.isValidSudoku(array);
        System.out.println(ans);
    }
}
