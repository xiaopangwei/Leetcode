package leetcode.p2022m05.day0510;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 9:50 PM
 */
public class Solution159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        Map<Character, Integer> freq   = new HashMap<>();
        int                     left   = 0;
        int                     right  = 0;
        int                     maxLen = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            freq.put(r, freq.getOrDefault(r, 0) + 1);
            while (left < right && freq.keySet().size() > 2) {
                char l = s.charAt(left);
                int  f = freq.get(l) - 1;
                if (f > 0) {
                    freq.put(l, f);
                } else {
                    freq.remove(l);
                }
                left++;
            }
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String      s           = "eceba";
        Solution159 solution159 = new Solution159();
        int         ans         = solution159.lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(ans);
    }
}
