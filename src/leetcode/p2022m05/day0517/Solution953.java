package leetcode.p2022m05.day0517;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/17
 * @time 8:18 PM
 */
public class Solution953 {
    Map<Character, Integer> orderMap = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String s, String t) {
        int minLen = Math.min(s.length(), t.length());
        for (int i = 0; i < minLen; i++) {
            int p1 = orderMap.get(s.charAt(i));
            int p2 = orderMap.get(t.charAt(i));
            if (s.charAt(i) != t.charAt(i)) {
                if (p1 < p2) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return s.length() <= t.length();
    }

    public static void main(String[] args) {
        Solution953 solution953 = new Solution953();
        boolean     ans         = solution953.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(ans);
    }
}
