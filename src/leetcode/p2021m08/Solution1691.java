package leetcode.p2021m08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/22
 * @time 10:15 AM
 */
public class Solution1691 {
    public int maxHeight(int[][] cuboids) {

        for (int[] arr : cuboids) {
            Arrays.sort(arr);
        }

        Arrays.sort(cuboids, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });

        int[] dp = new int[cuboids.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = cuboids[i][2];
        }
        int maxVal = dp[0];
        for (int i = 1; i < cuboids.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] &&
                        cuboids[j][1] <= cuboids[i][1] &&
                        cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }


        return maxVal;
    }

    public static void main(String[] args) {
        Solution1691 solution1691 = new Solution1691();
        int[][]      array        = new int[][]{{7, 11, 17}, {7, 17, 11}, {11, 7, 17}, {11, 17, 7}, {17, 7, 11}, {17, 11, 7}};
        System.out.println(solution1691.maxHeight(array));

    }
}
