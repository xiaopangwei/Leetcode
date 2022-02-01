package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 2:07 PM
 */
public class Solution76 {
    public String minWindow(String s, String t) {


        Map<Character, Integer> standard = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            standard.put(ch, standard.getOrDefault(ch, 0) + 1);
        }

        int                     minVal     = Integer.MAX_VALUE;
        int                     startIndex = -1;
        Map<Character, Integer> map1       = new HashMap<>();
        int                     left       = 0;
        int                     right      = 0;
        int                     okCount    = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (standard.containsKey(ch)) {
                int temp = map1.getOrDefault(ch, 0);
                map1.put(ch, temp + 1);
                if (temp + 1 == standard.get(ch)) {
                    okCount++;
                }
            }

            if (okCount == standard.keySet().size()) {
                if (right - left + 1 < minVal) {
                    minVal = Math.min(minVal, right - left + 1);
                    startIndex = left;
                }
                while (left <= right) {
                    char leftChar = s.charAt(left);
                    int  freq     = standard.getOrDefault(leftChar, 0);
                    if (standard.containsKey(leftChar)) {
                        if (map1.get(leftChar) > freq) {
                            left++;
                            int f = map1.get(leftChar) - 1;
                            if (f > 0) {
                                map1.put(leftChar, f);
                            } else {
                                map1.remove(leftChar);
                            }
                            if (right - left + 1 < minVal) {
                                minVal = Math.min(minVal, right - left + 1);
                                startIndex = left;
                            }
                        } else {
                            left++;
                            int f = map1.get(leftChar) - 1;
                            if (f > 0) {
                                map1.put(leftChar, f);
                            } else {
                                map1.remove(leftChar);
                            }
                            okCount--;
                            break;
                        }
                    } else {
                        left++;
                        if (right - left + 1 < minVal) {
                            minVal = Math.min(minVal, right - left + 1);
                            startIndex = left;
                        }
                    }
                }
            }
            right++;
        }

        if (minVal == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, minVal + startIndex);
    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String     s          = "aaaaaaaaaaaabbbbbcdd";
        String     t          = "abcdd";
        String     ans        = solution76.minWindow(s, t);
        System.out.println(ans);
    }
}
