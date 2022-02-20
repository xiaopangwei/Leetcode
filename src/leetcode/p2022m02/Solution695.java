package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 4:53 PM
 */
public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxVal = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int temp = dfs(grid, i, j);
                    maxVal = Math.max(maxVal, temp);
                }
            }
        }
        return maxVal;
    }

    private int dfs(int[][] grid, int x, int y) {
        int ans = 1;
        grid[x][y] = 0;

        if (isValid(grid, x + 1, y) && grid[x + 1][y] == 1) {
            ans += dfs(grid, x + 1, y);
        }
        if (isValid(grid, x - 1, y) && grid[x - 1][y] == 1) {
            ans += dfs(grid, x - 1, y);
        }
        if (isValid(grid, x, y + 1) && grid[x][y + 1] == 1) {
            ans += dfs(grid, x, y + 1);
        }
        if (isValid(grid, x, y - 1) && grid[x][y - 1] == 1) {
            ans += dfs(grid, x, y - 1);
        }

        return ans;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution695 solution695=new Solution695();
        int ans=solution695.maxAreaOfIsland(new int[][]{{1,1}});
        System.out.println(ans);
    }
}
