package leetcode.p2021m09;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 9:48 PM
 */
public class Solution370 { public int[] getModifiedArray(int length, int[][] updates) {

    int[] diff = new int[length];

    for (int i = 0; i < updates.length; i++) {
        int s = updates[i][0];
        int e = updates[i][1];

        diff[s] += updates[i][2];
        if (e + 1 < length) {
            diff[e + 1] -= updates[i][2];
        }
    }

    int sum = diff[0];
    for (int i = 1; i < diff.length; i++) {
        diff[i] = diff[i] + sum;
        sum = diff[i];
    }
    return diff;
}


    public static void main(String[] args) {
        Solution370 solution370 = new Solution370();
        int[]       array       = solution370.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
        System.out.println(Arrays.toString(array));
    }
}
