package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/22
 * @time 8:40 PM
 */
public class Solution694 {
    public int numDistinctIslands(int[][] grid) {
        int         rows = grid.length;
        int         cols = grid[0].length;
        Set<String> sets = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    dfs(grid, i, j, i, j, list);
                    StringBuilder builder = new StringBuilder();
                    for (int item : list) {
                        builder.append(item);
                    }
                    sets.add(builder.toString());
                }
            }
        }
        return sets.size();
    }

    private void dfs(int[][] grid, int x, int y, int leftUpX, int leftUpY, List<Integer> temp) {
        grid[x][y] = 0;
        temp.add(x - leftUpX);
        temp.add(y - leftUpY);
        if (isValid(grid, x + 1, y) && grid[x + 1][y] == 1) {
            dfs(grid, x + 1, y, leftUpX, leftUpY, temp);
        }
        if (isValid(grid, x - 1, y) && grid[x - 1][y] == 1) {
            dfs(grid, x - 1, y, leftUpX, leftUpY, temp);
        }
        if (isValid(grid, x, y + 1) && grid[x][y + 1] == 1) {
            dfs(grid, x, y + 1, leftUpX, leftUpY, temp);
        }
        if (isValid(grid, x, y - 1) && grid[x][y - 1] == 1) {
            dfs(grid, x, y - 1, leftUpX, leftUpY, temp);
        }
    }


    private boolean isValid(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        //11011
        //10000
        //00001
        //11011
        int[][]     grid        = new int[][]
                {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        Solution694 solution694 = new Solution694();
        int         ans         = solution694.numDistinctIslands(grid);
        System.out.println(ans);
    }
}
