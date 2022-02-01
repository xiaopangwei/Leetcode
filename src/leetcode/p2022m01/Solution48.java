package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 11:46 PM
 */
public class Solution48 {
    public int lengthOfLongestSubstring(String s) {

        int                     left   = 0;
        int                     right  = 0;
        Map<Character, Integer> freq   = new HashMap<>();
        int                     maxLen = 1;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (freq.containsKey(ch)) {
                while (left < right && freq.containsKey(ch)) {
                    char t = s.charAt(left);
                    freq.put(t, freq.get(t) - 1);
                    if (freq.get(t) <= 0) {
                        freq.remove(t);
                    }
                    left++;
                }

                freq.put(ch, freq.getOrDefault(ch,0) + 1);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;

            } else {
                freq.put(ch, freq.getOrDefault(ch,0) + 1);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int        ans        = solution48.lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }
}
