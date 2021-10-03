package leetcode.p2021m10;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 1:10 PM
 */
public class Solution1259 {


    Map<Integer, Long> cached = new HashMap<>();

    int maxValue = 1000000007;

    public int numberOfWays(int num_people) {

        return (int) dfs(num_people);
    }


    private long dfs(int n) {

        if (cached.containsKey(n)) {
            return cached.get(n);
        }
        if (n == 2 || n == 0) {
            return 1;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res += ((dfs(i) * dfs(n - 2 - i)) % maxValue);
            }
        }

        cached.put(n, res % maxValue);

        return res % maxValue;

    }

    public static void main(String[] args) {
        Solution1259 solution1259 = new Solution1259();
        System.out.println(solution1259.numberOfWays(6));
    }
}
