package leetcode.p2021m08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/14
 * @time 5:18 PM
 */
public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }

            }
        });

        int   len = envelopes.length;
        int[] dp  = new int[len];

        for (int i=0;i<len;i++){
            dp[i]=1;
        }
        int maxVal = 1;
        for (int i = 1; i < len; i++) {

            for (int j = 0; j < i; j++) {

                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            System.out.println(i+" "+dp[i]);
            maxVal = Math.max(dp[i], maxVal);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Solution354 solution354 = new Solution354();
        int         ans         = solution354.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
        System.out.println(ans);
    }
}
