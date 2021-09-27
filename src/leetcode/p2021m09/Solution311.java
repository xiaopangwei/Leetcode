package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/24
 * @time 11:02 PM
 */
public class Solution311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {

        int         m1    = mat1.length;
        int         n1    = mat1[0].length;
        int         n2    = mat2[0].length;
        int[][]     ans   = new int[m1][n2];
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                if (mat1[i][j] != 0) {
                    list1.add(new int[]{i, j, mat1[i][j]});
                }
            }
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (mat2[i][j] != 0) {
                    list2.add(new int[]{i, j, mat2[i][j]});
                }
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                int[] vector1 = list1.get(i);
                int[] vector2 = list2.get(j);
                if (vector1[1] == vector2[0]) {
                    ans[vector1[0]][vector2[1]] += (vector1[2] * vector2[2]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution311 solution311 = new Solution311();
        int[][] ans = solution311.multiply(new int[][]{{1, 0, 0}, {-1, 0, 3}},
                new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
