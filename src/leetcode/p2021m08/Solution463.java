package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/25
 * @time 11:26 PM
 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {

        int m   = grid.length;
        int n   = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int temp = 0;
                    if (isValid(i + 1, j, m, n) && grid[i + 1][j] == 1) {
                        temp++;
                    }
                    if (isValid(i - 1, j, m, n) && grid[i - 1][j] == 1) {
                        temp++;
                    }
                    if (isValid(i, j - 1, m, n) && grid[i][j - 1] == 1) {
                        temp++;
                    }
                    if (isValid(i, j + 1, m, n) && grid[i][j + 1] == 1) {
                        temp++;
                    }

                    ans += (4 - temp);
                }
            }
        }
        return ans;
    }


    private boolean isValid(int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution463 solution463 = new Solution463();
        int[][]     array       = new int[][]{{1,0}};
//        int[][]     array       = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int         ans         = solution463.islandPerimeter(array);
        System.out.println(ans);
    }
}
