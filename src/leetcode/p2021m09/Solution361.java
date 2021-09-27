package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/25
 * @time 1:54 PM
 */
public class Solution361 {
    public int maxKilledEnemies(char[][] grid) {

        int maxValue = -1;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    int count = 0;
                    for (int k = 0; k < directions.length; k++) {
                        int newX = directions[k][0] + i;
                        int newY = directions[k][1] + j;
                        if (!isValid(newX, newY, grid.length, grid[0].length)) {
                            continue;
                        }
                        while (grid[newX][newY] == 'E' || grid[newX][newY] == '0') {
                            if (grid[newX][newY] == 'E') {
//                                System.out.println(newX+" "+newY);
                                count++;
                            }

                            newX += directions[k][0];
                            newY += directions[k][1];
                            if (!isValid(newX, newY, grid.length, grid[0].length)) {
                                break;
                            }
                        }
                    }

                    maxValue = Math.max(maxValue, count);
//                    System.out.println(i+" "+j+" ==> "+count+" "+maxValue);
                }
            }
        }
        return maxValue;
    }


    private boolean isValid(int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution361 solution361 = new Solution361();
        int         ans         = solution361.maxKilledEnemies(new char[][]{{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}});
        System.out.println(ans);
    }
}
