package leetcode.p2022m06.day0628;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/28
 * @time 10:44 PM
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int                     left             = 0, right = 0;
        int                     minLen           = Integer.MAX_VALUE;
        Map<Character, Integer> freq             = new HashMap<>();
        int                     startOfMinWindow = -1;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (need.containsKey(rightChar)) {
                freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            }
            right++;
            while (left < right && isShrink(freq, need)) {
                int len = right - left;
                if (len < minLen) {
                    minLen = len;
                    startOfMinWindow = left;
                }
                if (need.containsKey(s.charAt(left))) {
                    int temp = freq.getOrDefault(s.charAt(left), 0);
                    freq.put(s.charAt(left), temp - 1);
                }
                left++;
            }
        }
        if (startOfMinWindow == -1) {
            return "";
        } else {
            return s.substring(startOfMinWindow, startOfMinWindow + minLen);
        }

    }

    private boolean isShrink(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (Map.Entry<Character, Integer> e : m2.entrySet()) {
            if (m1.getOrDefault(e.getKey(), 0) < e.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow("a", "aa"));
    }
}
