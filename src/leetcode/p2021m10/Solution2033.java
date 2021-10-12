package leetcode.p2021m10;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/11
 * @time 10:31 PM
 */
public class Solution2033 {
    public int minOperations(int[][] grid, int x) {

        int   m        = grid.length;
        int   n        = grid[0].length;
        int[] flatten  = new int[m * n];
        int   index    = 0;
        int   maxValue = Integer.MIN_VALUE;
        int   minValue = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxValue = Math.max(maxValue, grid[i][j]);
                minValue = Math.min(minValue, grid[i][j]);
                flatten[index++] = grid[i][j];
            }
        }

        Arrays.sort(flatten);
        int lIndex, rIndex;
        if (flatten.length % 2 != 0) {
            lIndex = flatten.length / 2;
            rIndex = flatten.length / 2;
        } else {
            lIndex = flatten.length / 2 - 1;
            rIndex = flatten.length / 2;
        }
        int res = Integer.MAX_VALUE;
        for (int i = flatten[lIndex]; i <= flatten[rIndex]; i++) {
            int minStep = getMinSteps(flatten, x, i);
            res = Math.min(minStep, res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int getMinSteps(int[] flatten, int x, int target) {
        int count = 0;
        for (int i = 0; i < flatten.length; i++) {
            int gap = Math.abs(target - flatten[i]);
            if (gap % x != 0) {
                return Integer.MAX_VALUE;
            }
            count += (gap / x);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution2033 solution2033 = new Solution2033();
        int[][]      grid         = new int[][]{{146}};
        int          ans          = solution2033.minOperations(grid, 86);
        System.out.println(ans);
    }
}
