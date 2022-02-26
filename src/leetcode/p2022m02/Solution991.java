package leetcode.p2022m02;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/24
 * @time 9:33 PM
 */
public class Solution991 {
    Map<Integer, Integer> map = new HashMap<>();

    public int brokenCalc(int startValue, int target) {
        return dfs(startValue, target);
    }

    private int dfs(int value, final int target) {
        if (map.containsKey(value)) {
            return map.get(value);
        }
        if (value <= target) {
            return target - value;
        }

        int ans = 0;
        if ((target & 1) == 0) {
            if (map.containsKey(target / 2)) {
                ans = map.get(target / 2);
            } else {
                ans = dfs(value, target / 2) + 1;
            }
        } else {
            if (map.containsKey(target + 1)) {
                ans = map.get(target + 1);
            } else {
                ans = dfs(value, target + 1) + 1;
            }
        }

        map.put(value, ans);
        return ans;

    }

    public static void main(String[] args) {
        Solution991 solution991 = new Solution991();
        int         ans         = solution991.brokenCalc(5, 8);
        System.out.println(ans);
    }
}
