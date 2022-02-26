package leetcode.p2022m02;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/22
 * @time 9:01 PM
 */
public class Solution1155 {

    int                  maxVal = 1000000007;
    Map<String, Integer> cached = new HashMap<>();

    public int numRollsToTarget(int n, int k, int target) {
        return dfs(0, n, k, target, 0);
    }

    private int dfs(int count, final int n, final int k, final int target, int currentSum) {

        String key = count + "#" + currentSum;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (currentSum == target && count == n) {
            return 1;
        }
        if (currentSum > target) {
            return 0;
        }
        if (count >= n) {
            return 0;
        }

        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = (ans + dfs(count + 1, n, k, target, currentSum + i)) % maxVal;
        }

        cached.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution1155 solution1155 = new Solution1155();
        int          ans          = solution1155.numRollsToTarget(30, 30, 500);
        System.out.println(ans);
    }
}
