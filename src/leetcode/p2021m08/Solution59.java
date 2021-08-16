package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 2:01 PM
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];
        fill(ans, 0, 0, 1);
        return ans;
    }


    private void fill(int[][] grid, int startX, int startY, int index) {
//        if (startX < 0 || startY < 0 || startX >= grid.length || startY >= grid.length) {
//            return;
//        }
        if (index == grid.length * grid.length) {
            grid[startX][startY] = index;
            return;
        }
        int x = startX;
        int y = startY;
        //--->
        while (y < grid.length && grid[x][y] == 0) {
            grid[x][y] = index++;
            y++;
        }


        y--;
        x++;
        while (x < grid.length && grid[x][y] == 0) {
            grid[x][y] = index++;
            x++;
        }

        x--;
        y--;
        while (y >= 0 && grid[x][y] == 0) {
            grid[x][y] = index++;
            y--;
        }

        y++;
        x--;
        while (x >= 0 && grid[x][y] == 0) {
            grid[x][y] = index++;
            x--;
        }

        fill(grid, startX + 1, startY + 1, index);
    }


    public static void main(String[] args){
        Solution59 solution59=new Solution59();
        int[][] ans=solution59.generateMatrix(5);
        for (int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
