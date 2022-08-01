package leetcode.p2022m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/29
 * @time 10:06 PM
 */
public class Solution861 {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = 0;

                    }
                }
            }
        }


        for (int j = 1; j < n; j++) {
            int zeroCnt = 0;
            int oneCnt  = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }
            if (zeroCnt > oneCnt) {
                for (int i = 0; i < m; i++) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = 0;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        for (int i = 0; i < m; i++) {
            int base = 1;
            int temp = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    temp += base;
                }
                base *= 2;
            }
            ans += temp;
        }

        return ans;


    }

    public static void main(String[] args) {
        Solution861 solution861 = new Solution861();
        //[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
        int ans = solution861.matrixScore(new int[][]{{0, 1}, {1, 1}});
        System.out.println(ans);
    }
}
