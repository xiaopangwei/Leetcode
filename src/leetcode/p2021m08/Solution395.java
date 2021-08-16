package leetcode.p2021m08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 3:46 PM
 */
public class Solution395 {
    public int longestSubstring(String s, int k) {

        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<String> temp = new ArrayList<>();
        int          last = 0;
        int          i    = 0;
        boolean      flag = false;
        while (i < s.length()) {
            if (freq.getOrDefault(s.charAt(i), 0) < k) {
                flag = true;
                temp.add(s.substring(last, i));
                int j = i + 1;
                while (j < s.length() && freq.getOrDefault(s.charAt(j), 0) < k) {
                    j++;
                }
                i = j;
                last = i;
            } else {
                i++;
            }
        }

        if (last < s.length()) {
            temp.add(s.substring(last, s.length()));
        }

        if (!flag) {
            return s.length();
        } else {
            int ans = -1;
            for (String c : temp) {
                ans = Math.max(ans, longestSubstring(c, k));
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution395 solution395 = new Solution395();
        int         ans         = solution395.longestSubstring("abab", 2);
        System.out.println(ans);
    }
}
