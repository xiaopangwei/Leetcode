package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/4
 * @time 2:38 PM
 */
public class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        char[] charArray = s.toCharArray();

        int left  = 0;
        int right = 0;

        int maxWidth = 1;

        Map<Character, Integer> freq = new HashMap<>();

        while (right < charArray.length) {
            char           ch   = charArray[right];
            Set<Character> curr = freq.keySet();
            if (curr.contains(ch)) {

                freq.put(ch, freq.get(ch) + 1);
                right++;
//                System.out.println("ADD " + ch + " " + freq.get(ch));
            } else {
                if (curr.size() < 2) {
                    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
                    right++;
//                    System.out.println("ADD " + ch + " " + freq.get(ch));
                } else {
                    //>=2
                    while (left < right) {
                        char temp  = charArray[left];
                        int  times = freq.get(temp);
                        if (times <= 1) {
//                            System.out.println("REMOVE " + temp);
                            freq.remove(temp);
                            left++;
                            break;
                        } else {
                            freq.put(temp, times - 1);
//                            System.out.println("DESC " + temp);
                            left++;
                        }
                    }
                    freq.put(ch, 1);
                    right++;

                }
            }


            int w = right - left;
            maxWidth = Math.max(w, maxWidth);

        }

        return maxWidth;
    }

    public static void main(String[] args) {
        Solution159 solution159 = new Solution159();
        int         ans         = solution159.lengthOfLongestSubstringTwoDistinct("abcabcabc");
        System.out.println(ans);
    }
}
