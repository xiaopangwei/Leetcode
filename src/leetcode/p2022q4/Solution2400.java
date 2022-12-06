package leetcode.p2022q4;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/3
 * @time 10:10 PM
 */
public class Solution2400 {

    int target;
    int k;
    int MOD = (int) 1e9 + 7;

    Map<String, Integer> cached = new HashMap<>();

    public int numberOfWays(int startPos, int endPos, int k) {

        target = endPos;
        this.k = k;
        return dfs(startPos, 0);
    }


    private int dfs(int currPos, int steps) {
        String key = currPos + "#" + steps;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (Math.abs(currPos - target) > this.k - steps) {
            cached.put(key, 0);
            return 0;
        }
        if (steps == this.k) {
            if (currPos == target) {
                cached.put(key, 1);
                return 1;
            } else {
                cached.put(key, 0);
                return 0;
            }
        }
        if (steps > this.k) {
            cached.put(key, 0);
            return 0;
        }
        int t1 = dfs(currPos + 1, steps + 1);
        int t2 = dfs(currPos - 1, steps + 1);


        cached.put(key, (t1 + t2) % MOD);
        return (t1 + t2) % MOD;
    }

    public static void main(String[] args) {
        Solution2400 solution2400 = new Solution2400();
        System.out.println(solution2400.numberOfWays(2, 5, 10));
    }
}
