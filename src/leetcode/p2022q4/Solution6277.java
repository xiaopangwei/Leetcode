package leetcode.p2022q4;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/27
 * @time 8:53 PM
 */
public class Solution6277 {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rows0 = new int[grid.length];
        int[] col0  = new int[grid[0].length];

        int[] rows1 = new int[grid.length];
        int[] col1  = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    rows0[i]++;
                } else {
                    rows1[i]++;
                }
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    col0[i]++;
                } else {
                    col1[i]++;
                }
            }
        }

        int[][] diff = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                diff[i][j] = rows1[i] + col1[j] - rows0[i] - col0[j];
            }
        }
        return diff;
    }

    public static void main(String[] args){
        Solution6277 solution6277=new Solution6277();
        //[[0,1,1],[1,0,1],[0,0,1]]
        int[][] ans=solution6277.onesMinusZeros(new int[][]{{0,1,1},{1,0,1},{0,0,1}});
        for (int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
