package leetcode.p2021m11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/22
 * @time 8:27 PM
 */
public class Solution120 {

    private Map<String, Integer> cache = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {

        int minVal = dfs(triangle, 0, 0);
        return minVal;
    }

    private int dfs(List<List<Integer>> triangle, int rowId, int colId) {
        String biKey = rowId + "#" + colId;
        if (cache.containsKey(biKey)) {
            return cache.get(biKey);
        }
        if (rowId == triangle.size()) {
            return 0;
        }
        int currentSum = triangle.get(rowId).get(colId);

        int    t1 = dfs(triangle, rowId + 1, colId) + currentSum;


        int    t2 = dfs(triangle, rowId + 1, colId + 1) + currentSum;


        int res = Math.min(t1, t2);
//        System.out.println(t1 + " " + t2);
        cache.put(biKey, res);
        return res;
    }

    public static void main(String[] args) {
        Solution120 solution120 = new Solution120();
        int         ans         = solution120.minimumTotal(Arrays.asList(Arrays.asList(-1), Arrays.asList(-2, -3)));
        System.out.println(ans);
    }
}
