package leetcode.p2021m08;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/20
 * @time 1:55 PM
 */
public class Solution97 {
    static class Tuple3 {
        public int x;
        public int y;
        public int z;

        public Tuple3(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tuple3 tuple3 = (Tuple3) o;

            if (x != tuple3.x) return false;
            if (y != tuple3.y) return false;
            return z == tuple3.z;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }
    }

    private Map<Tuple3, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, s1.length() - 1, s2, s2.length() - 1, s3, s3.length() - 1);
    }

    public boolean isInterleave(String s1, int i, String s2, int j, String s3, int k) {

        Tuple3 tuple3 = new Tuple3(i, j, k);
        if (cache.containsKey(tuple3)) {
            return cache.get(tuple3);
        }
        boolean ans = false;
        if (i < 0 && j < 0) {
            ans = true;
        } else if (i < 0) {
            if (s2.charAt(j) != s3.charAt(k)) {
                ans = false;
            } else {
                ans = isInterleave(s1, i, s2, j - 1, s3, k - 1);
            }
        } else if (j < 0) {
            if (s1.charAt(i) != s3.charAt(k)) {
                ans = false;
            } else {
                ans = isInterleave(s1, i - 1, s2, j, s3, k - 1);
            }
        } else {
            if (s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) {
                ans = false;
            } else if (s1.charAt(i) != s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
                ans = isInterleave(s1, i, s2, j - 1, s3, k - 1);
            } else if (s1.charAt(i) == s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) {
                ans = isInterleave(s1, i - 1, s2, j, s3, k - 1);
            } else {
                ans = isInterleave(s1, i - 1, s2, j, s3, k - 1) || isInterleave(s1, i, s2, j - 1, s3, k - 1);
            }
        }
        cache.put(tuple3, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution97 solution97 = new Solution97();
        System.out.println(solution97.isInterleave("ab", "bc", "bbac"));
    }
}
