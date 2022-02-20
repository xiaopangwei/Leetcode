package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/14
 * @time 10:22 PM
 */
public class Solution37 {
    public void solveSudoku(char[][] board) {
        List<int[]> blankList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    continue;
                }
                blankList.add(new int[]{i, j});
            }
        }

        dfs(board, blankList, 0);
    }

    private boolean dfs(char[][] board, List<int[]> posList, int index) {
        if (index == posList.size()) {
            return true;
        }
        int[]         temp        = posList.get(index);
        int           x           = temp[0];
        int           y           = temp[1];
        List<Integer> occuredList = getOccuredDigit(board, x, y);
        for (int i = 1; i < 10; i++) {
            if (!occuredList.contains(i)) {
                board[x][y] = (char) (i + '0');
                if (dfs(board, posList, index + 1)) {
                    return true;
                }
                board[x][y] = '.';
            }
        }
        return false;
    }

    private List<Integer> getOccuredDigit(char[][] board, int x, int y) {
        int chunkX = x / 3 * 3;
        int chunkY = y / 3 * 3;
//        System.out.println(x + " " + y + ": " + chunkX + " " + chunkY);
        List<Integer> list = new ArrayList<>();
        for (int i = chunkX; i < chunkX + 3; i++) {
            for (int j = chunkY; j < chunkY + 3; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                list.add(ch - '0');
            }
        }

        for (int i = 0; i < 9; i++) {
            char ch = board[x][i];
            if (ch == '.') {
                continue;
            }
            list.add(ch - '0');
        }

        for (int i = 0; i < 9; i++) {
            char ch = board[i][y];
            if (ch == '.') {
                continue;
            }
            list.add(ch - '0');
        }
        return list;
    }

    public static void main(String[] args) {
        char[][] array = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Solution37 solution37 = new Solution37();
        solution37.solveSudoku(array);

        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

    }
}
