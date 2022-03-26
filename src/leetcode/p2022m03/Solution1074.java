package leetcode.p2022m03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 9:39 PM
 */
public class Solution1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m   = matrix.length, n = matrix[0].length;

        int[][] prefixSum = new int[m + 1][n];

        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + matrix[i - 1][j];
            }
        }

        for (int i = 0; i < prefixSum.length; i++) {

            for (int j = i + 1; j < prefixSum.length; j++) {

                int[] diff = new int[n];
                for (int k = 0; k < n; k++) {
                    diff[k] = prefixSum[j][k] - prefixSum[i][k];
                }
                ans += sumSubArrayCount(diff, target);
            }
        }
        return ans;

    }

    private int sumSubArrayCount(int[] num, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int prefixSum = 0;
        int ans       = 0;
        for (int i = 0; i < num.length; i++) {
            prefixSum += num[i];
            int temp = prefixSum - target;
            if (freq.containsKey(temp)) {
                ans += freq.get(temp);
            }
            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1074 solution1074 = new Solution1074();
        //[[0,1,0],[1,1,1],[0,1,0]]
        int ans = solution1074.numSubmatrixSumTarget(
                new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0);
//        int          ans          = solution1074.sumSubArrayCount(new int[]{1, 1, 1}, 2);
        System.out.println(ans);
    }
}
