package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/23
 * @time 10:19 PM
 */
public class Solution1143 {
    Map<String, Integer> cached = new HashMap<>();

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, 0, text2, 0);
    }

    private int longestCommonSubsequence(String text1, int start1, String text2, int start2) {
        String key = start1 + "#" + start2;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (start1 == text1.length() || start2 == text2.length()) {
            return 0;
        }
        int temp = 0;
        if (text1.charAt(start1) == text2.charAt(start2)) {
            temp = longestCommonSubsequence(text1, start1 + 1, text2, start2 + 1) + 1;
        } else {
            int t1 = longestCommonSubsequence(text1, start1 + 1, text2, start2);
            int t2 = longestCommonSubsequence(text1, start1, text2, start2 + 1);
            temp = Math.max(t1, t2);
        }
        cached.put(key, temp);
        return temp;
    }

    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        int          ans          = solution1143.longestCommonSubsequence("abc", "def");
        System.out.println(ans);
    }
}
