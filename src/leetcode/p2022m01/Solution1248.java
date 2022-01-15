package leetcode.p2022m01;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/11
 * @time 10:36 PM
 */
public class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 1);
        for (int i = 1; i < prefixSum.length; i++) {
            int t = 0;
            if (nums[i - 1] % 2 == 1) {
                t = 1;
            }
            prefixSum[i] = prefixSum[i - 1] + t;
            treeMap.put(prefixSum[i], treeMap.getOrDefault(prefixSum[i], 0) + 1);
        }

        int ans = 0;

//        System.out.println(treeMap);

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {

            int key = entry.getKey();
            int val = entry.getValue();
            if (treeMap.getOrDefault(key + k, 0) > 0) {
                ans += val * treeMap.get(key + k);
            }
        }

        return ans;


    }

    public static void main(String[] args) {
        Solution1248 solution1248 = new Solution1248();
        int          ans          = solution1248.numberOfSubarrays(new int[]{1,1,2,1,1}, 3);
        System.out.println(ans);
    }
}
