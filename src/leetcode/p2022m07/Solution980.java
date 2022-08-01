package leetcode.p2022m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/20
 * @time 9:27 PM
 */
public class Solution980 {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] grid;
    int     targetX;
    int     targetY;

    public int uniquePathsIII(int[][] grid) {

        this.grid = grid;

        int startX = -1;
        int startY = -1;
        int endX   = -1;
        int endY   = -1;

        int blankCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 2) {
                    endX = i;
                    endY = j;
                } else if (grid[i][j] == 0) {
                    blankCnt++;
                }
            }
        }

        targetX = endX;
        targetY = endY;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[startX][startY] = true;
        int ans = dfs(startX, startY, blankCnt, visited);
        return ans;
    }


    private int dfs(int x, int y, int blankCount, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }

        if (blankCount <= 0 && x == targetX && y == targetY) {
            return 1;
        }


        int ans = 0;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newY < 0 || newX >= grid.length ||
                    newY >= grid[0].length || visited[newX][newY] || grid[newX][newY] == -1) {
                continue;
            }

            visited[newX][newY] = true;
            if (grid[newX][newY] == 0) {
                ans += dfs(newX, newY, blankCount - 1, visited);
            } else {
                ans += dfs(newX, newY, blankCount, visited);
            }
            visited[newX][newY] = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0,2}};
        Solution980 solution980=new Solution980();
        int ans=solution980.uniquePathsIII(array);
        System.out.println(ans);
    }
}
