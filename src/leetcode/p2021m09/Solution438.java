package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/11
 * @time 3:59 PM
 */
public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        final int windowSize = p.length();

        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : p.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int freqKeySize = freq.keySet().size();

        int left = 0;

        if (s.length() < p.length()) {
            return ans;
        }

        Map<Character, Integer> temp = new HashMap<>();

        for (int i = 0; i < windowSize; i++) {
            temp.put(s.charAt(i), temp.getOrDefault(s.charAt(i), 0) + 1);
        }

        while (left < s.length()) {

            int right = left + windowSize - 1;
            if (right >= s.length()) {
                break;
            }

//            System.out.println(temp);
            Set<Character> keys = temp.keySet();
            boolean        flag = true;
            if (freqKeySize == temp.size()) {
                for (Character c : keys) {
                    if (!freq.containsKey(c)) {
                        flag = false;
                        break;
                    } else {
                        if (!freq.get(c).equals(temp.get(c))) {
                            flag = false;
                            break;
                        }
                    }
                }
            } else {
                flag = false;
            }

            if (flag) {
                ans.add(left);
            }

            char leftChar = s.charAt(left);
            int  newFreq  = temp.getOrDefault(leftChar, 0) - 1;
            if (newFreq == 0) {
                temp.remove(leftChar);
            } else {
                temp.put(leftChar, newFreq);
            }

            int newRight = right + 1;
            if (newRight < s.length()) {
                temp.put(s.charAt(newRight), temp.getOrDefault(s.charAt(newRight), 0) + 1);
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        System.out.println(solution438.findAnagrams("abab", "ab"));
    }
}
