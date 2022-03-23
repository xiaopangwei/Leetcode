package leetcode.p2022m03;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/20
 * @time 9:58 PM
 */
public class Solution120 {
    Map<String, Integer> cached = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int x, int y) {
        String key = x + "#" + y;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (x == triangle.size()) {
            return 0;
        }
        int temp = Math.min(dfs(triangle, x + 1, y),
                dfs(triangle, x + 1, y + 1)) + triangle.get(x).get(y);
        cached.put(key, temp);
        return temp;
    }

    public static void main(String[] args) {
        Solution120         solution120 = new Solution120();
        List<List<Integer>> t1          = new ArrayList<>();
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        t1.add(Arrays.asList(2));
        t1.add(Arrays.asList(3, 4));
        t1.add(Arrays.asList(6, 5, 7));
        t1.add(Arrays.asList(4, 1, 8, 3));
        int ans=solution120.minimumTotal(t1);
        System.out.println(ans);
    }
}
