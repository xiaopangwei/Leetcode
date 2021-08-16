package leetcode.p2021m08;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/14
 * @time 10:26 PM
 */
public class Solution96 {
    Map<Integer, Integer> cache = new HashMap<>();

    public int numTrees(int n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            //[1,i-1]
            //i
            //[i+1,n]
            count += (numTrees(i - 1) * numTrees(n - i));
        }
        cache.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(1));
        System.out.println(solution96.numTrees(2));
        System.out.println(solution96.numTrees(3));
        System.out.println(solution96.numTrees(4));
        System.out.println(solution96.numTrees(5));
    }
}
