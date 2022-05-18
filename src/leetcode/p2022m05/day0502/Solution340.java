package leetcode.p2022m05.day0502;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 3:01 PM
 */
public class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freq   = new HashMap<>();
        int                     left   = 0;
        int                     right  = 0;
        int                     maxLen = 0;
        while (right < s.length()) {
            int f = freq.getOrDefault(s.charAt(right), 0) + 1;
            freq.put(s.charAt(right), f);
            while (left < right && freq.keySet().size() > k) {
                char ch = s.charAt(left);
                int  t  = freq.getOrDefault(ch, 0) - 1;
                if (t <= 0) {
                    freq.remove(ch);
                } else {
                    freq.put(ch, t);
                }
                left++;
            }
            right++;
            System.out.println(left+" "+right);
            maxLen = Math.max(maxLen, right - left);

        }
        return maxLen;
    }

    public static void main(String[] args){
        Solution340 solution340=new Solution340();
        int len=solution340.lengthOfLongestSubstringKDistinct("aa",1);
        System.out.println(len);
    }
}
