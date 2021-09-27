package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/25
 * @time 12:39 PM
 */
public class Solution583 {
    private Map<String, Integer> cached = new HashMap<>();

    public int minDistance(String word1, String word2) {

        int temp = longestCommonSeq(word1.length() - 1, word1, word2.length() - 1, word2);
        int ans  = word1.length() + word2.length() - 2 * temp;
        return ans;
    }

    private int longestCommonSeq(int index1, String word1, int index2, String word2) {

        String key = String.valueOf(index1) + "#" + String.valueOf(index2);
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            int ans = longestCommonSeq(index1 - 1, word1, index2 - 1, word2) + 1;
            cached.put(key, ans);
            return ans;
        } else {
            int ans = Math.max(longestCommonSeq(index1 - 1, word1, index2, word2),
                    longestCommonSeq(index1, word1, index2 - 1, word2));
            cached.put(key, ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution583 solution583 = new Solution583();
        int         minDist     = solution583.minDistance("sea", "eat");
        System.out.println(minDist);
    }
}
