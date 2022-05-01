package leetcode.p2021m07;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 2:47 PM
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int totalLen = s.length();

        int left  = 0;
        int right = 0;

        int ans = 0;

        Set<Character> sets = new HashSet<>();
        while (right < totalLen) {
            char ch = s.charAt(right);
            while (left < right && sets.contains(ch)) {
                sets.remove(s.charAt(left++));
            }
            sets.add(ch);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int       ans       = solution3.lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }


}
