package leetcode.p2022m06.day0625;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/25
 * @time 11:17 PM
 */
public class Solution97 {


    Map<String, Boolean> cached = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length()!=s1.length()+s2.length()){
            return false;
        }
        return dfs(s1, 0, s2, 0, s3, 0);
    }

    private boolean dfs(String s1, int i, String s2, int j, String s3, int k) {
        String biKey = i + "#" + j + "#" + k;
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        if (i >= s1.length() && j >= s2.length()) {
            cached.put(biKey, true);
            return true;
        }
        if (i >= s1.length()) {
            if (s2.charAt(j) != s3.charAt(k)) {
                cached.put(biKey, false);
                return false;
            }

            return dfs(s1, i, s2, j + 1, s3, k + 1);

        }
        if (j >= s2.length()) {
            if (s1.charAt(i) != s3.charAt(k)) {
                cached.put(biKey, false);
                return false;
            }
            return dfs(s1, i + 1, s2, j, s3, k + 1);
        }

        if (s3.charAt(k) == s1.charAt(i)) {
            if (dfs(s1, i + 1, s2, j, s3, k + 1)) {
                cached.put(biKey, true);
                return true;
            }
        }
        if (s3.charAt(k) == s2.charAt(j)) {
            if (dfs(s1, i, s2, j + 1, s3, k + 1)) {
                cached.put(biKey, true);
                return true;
            }
        }
        cached.put(biKey, false);
        return false;
    }
}
