package leetcode.p2021m08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/22
 * @time 10:48 AM
 */
public class Solution0813 {
    public int pileBox(int[][] box) {
        Arrays.sort(box, new Comparator<int[]>() {
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

        int[] dp = new int[box.length];

        for (int i = 0; i < box.length; i++) {
            dp[i] = box[i][2];
        }
        int maxValue = dp[0];
        for (int i = 1; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[j][0] < box[i][0] && box[j][1] < box[i][1] && box[j][2] < box[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Solution0813 solution0813 = new Solution0813();
        int          maxHeight    = solution0813.pileBox(new int[][]{{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}});
        System.out.println(maxHeight);
    }
}
