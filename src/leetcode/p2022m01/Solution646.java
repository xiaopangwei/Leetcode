package leetcode.p2022m01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/7
 * @time 11:06 PM
 */
public class Solution646 {
    public int findLongestChain(int[][] pairs) {

        int   len = pairs.length;
        int[] dp  = new int[len];

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int maxVal = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < len; i++) {

            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            maxVal = Math.max(maxVal, dp[i]);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Solution646 solution646 = new Solution646();
        int         ans         = solution646.findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}});
        System.out.println(ans);
    }
}
