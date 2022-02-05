package leetcode.p2021m08;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 3:54 PM
 */
public class Solution72 {
    String word1;
    String word2;
    Map<String, Integer> cached = new HashMap<>();

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        int t = dfs(0, 0);
        return t;

    }


    private int dfs(int start1, int start2) {
        String key = start1 + "#" + start2;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (start1 == word1.length() && start2 == word2.length()) {
            cached.put(key, 0);
            return 0;
        }
        if (start1 == word1.length()) {
            cached.put(key, word2.length() - start2);
            return word2.length() - start2;
        }
        if (start2 == word2.length()) {
            cached.put(key, word1.length() - start1);
            return word1.length() - start1;
        }

        int t1 = dfs(start1 + 1, start2);
        int t2 = dfs(start1, start2 + 1);
        int t  = Math.min(t1, t2) + 1;

        int t3  = dfs(start1 + 1, start2 + 1);
        int ans = 0;
        if (word1.charAt(start1) == word2.charAt(start2)) {
            ans = Math.min(t, t3);
        } else {

            ans = Math.min(t, t3 + 1);
        }
        cached.put(key, ans);
        return ans;
    }


    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        int        ans        = solution72.minDistance("horse", "ros");
        System.out.println(ans);
    }
}
