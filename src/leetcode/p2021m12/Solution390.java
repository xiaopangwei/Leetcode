package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/8
 * @time 8:32 PM
 */
public class Solution390 {
    Map<Integer, Integer> cached = new HashMap<>();

    public int lastRemaining(int n) {
        if (cached.containsKey(n)) {
            return cached.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (n % 2 == 1) {
            int t = lastRemaining(n - 1);
            cached.put(n, t);
            return t;
        }
        int t = 2 + n - 2 * lastRemaining(n / 2);
        cached.put(n, t);
        return t;
    }
}
