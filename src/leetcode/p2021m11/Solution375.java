package leetcode.p2021m11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/12
 * @time 11:29 PM
 */
public class Solution375 {
    Map<String, Integer> cached = new HashMap<>();

    public int getMoneyAmount(int n) {

        return dfs(1, n);

    }


    private int dfs(int start, int end) {

        String key = start + "#" + end;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (start >= end) {
            return 0;
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int larger = Math.max(dfs(start, i - 1), dfs(i + 1, end));
            minVal = Math.min(minVal, larger + i);
        }

        cached.put(key, minVal);
        return minVal;
    }

    public static void main(String[] args) {
        Solution375 solution375 = new Solution375();
        int         ans         = solution375.getMoneyAmount(10);
        System.out.println(ans);
    }


}
