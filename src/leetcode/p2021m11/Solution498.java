package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/10
 * @time 9:25 PM
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        List<Integer> list = new ArrayList<>();

        boolean flag = true;

        int startX = 0;
        int startY = 0;

        int t = m + n;

        for (int i = 0; i < t; i++) {



        }


        return null;

    }

    public static void main(String[] args) {
        Solution498 solution498 = new Solution498();
        int[]       s           = solution498.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(s));
    }
}
