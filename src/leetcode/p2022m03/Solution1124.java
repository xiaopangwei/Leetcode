package leetcode.p2022m03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/3
 * @time 9:00 PM
 */
public class Solution1124 {
    public int longestWPI(int[] hours) {

        Map<Integer, Integer> posMap    = new HashMap<>();
        int[]                 prefixSum = new int[hours.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            int temp = hours[i - 1] > 8 ? 1 : -1;
            prefixSum[i] = prefixSum[i - 1] + temp;
            if (!posMap.containsKey(prefixSum[i])) {
                posMap.put(prefixSum[i], i);
            }
        }
        System.out.println(Arrays.toString(prefixSum));

        int maxVal = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            if (prefixSum[i] > 0) {
                maxVal = Math.max(maxVal, i);
            } else {
                int target = prefixSum[i] - 1;
                if (posMap.containsKey(target)) {
                    maxVal = Math.max(maxVal, i - posMap.get(target));
                }
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution1124 solution1124 = new Solution1124();
        int          ans          = solution1124.longestWPI(new int[]{6, 6, 9});
        System.out.println(ans);
    }
}
