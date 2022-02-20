package leetcode.p2022m02;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 11:19 AM
 */
public class Solution97 {

    Map<String, Boolean> cached = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1, 0, s2, 0, s3, 0);
    }

    private boolean dfs(String s1, int index1, String s2, int index2, String s3, int index3) {
        String key = index1 + "#" + index2 + "#" + index3;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index3 == s3.length()) {
            cached.put(key, true);
            return true;
        }
        if (index1 == s1.length()) {
            if (s2.charAt(index2) == s3.charAt(index3)) {
                return dfs(s1, index1, s2, index2 + 1, s3, index3 + 1);
            }
            return false;
        }
        if (index2 == s2.length()) {
            if (s1.charAt(index1) == s3.charAt(index3)) {
                return dfs(s1, index1 + 1, s2, index2, s3, index3 + 1);
            }
            return false;
        }
        char target = s3.charAt(index3);
        if (target == s1.charAt(index1)) {
            boolean flag = dfs(s1, index1 + 1, s2, index2, s3, index3 + 1);
            cached.put(key, flag);
            if (flag) {
                return true;
            }
        }
        if (target == s2.charAt(index2)) {
            boolean flag = dfs(s1, index1, s2, index2 + 1, s3, index3 + 1);
            cached.put(key, flag);
            if (flag) {
                return true;
            }
        }
        cached.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Solution97 solution97 = new Solution97();
        boolean    ans        = solution97.isInterleave("a", "", "c");
        System.out.println(ans);
    }
}
