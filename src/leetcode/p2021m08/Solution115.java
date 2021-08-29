package leetcode.p2021m08;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/26
 * @time 10:23 AM
 */
public class Solution115 {
    static class BiKey {
        public int x;
        public int y;

        public BiKey(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BiKey biKey = (BiKey) o;

            if (x != biKey.x) return false;
            return y == biKey.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    Map<BiKey, Integer> cached = new HashMap<>();

    public int numDistinct(String s, String t) {
        return dfs(s, 0, t, 0);
    }

    // a a
    private int dfs(final String s, int idx1, final String t, int idx2) {

        BiKey key = new BiKey(idx1, idx2);
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (idx2 >= t.length()) {
            return 1;
        } else if (idx1 >= s.length()) {
            return 0;
        }
        if (s.charAt(idx1) == t.charAt(idx2)) {
            int temp = 0;
            temp += dfs(s, idx1 + 1, t, idx2 + 1);
            temp += dfs(s, idx1 + 1, t, idx2);
            cached.put(key, temp);
            return temp;
        } else {
            int temp = dfs(s, idx1 + 1, t, idx2);
            cached.put(key, temp);
            return temp;
        }
    }

    public static void main(String[] args) {
        Solution115 solution115 = new Solution115();
        int         ans         = solution115.numDistinct("babgbag", "bag");
        System.out.println(ans);
    }
}
