package leetcode.p2021m12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/25
 * @time 2:50 PM
 */
public class Solution974 {
    public int subarraysDivByK(int[] A, int K) {
        int[] prefixSum = new int[A.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }


        int                   ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println(Arrays.toString(prefixSum));
        for (int i = 0; i < prefixSum.length; i++) {
            int t   = (prefixSum[i] % K + K) % K;
            int val = map.getOrDefault(t, 0);
            ans += val;
            map.put(t, val + 1);
        }


        return ans;
    }


    public static void main(String[] args) {
        Solution974 solution974 = new Solution974();
        int         ans         = solution974.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println(ans);
    }
}
