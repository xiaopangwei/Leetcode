package leetcode.p2021m08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/24
 * @time 9:53 PM
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch     = s.charAt(i);
            char target = t.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, target);
            } else {
                if (map.get(ch) != target) {
                    return false;
                }
            }
        }

        Set<Character> sets = new HashSet<>();
        for (char ch : map.values()) {
            sets.add(ch);
        }


        return map.values().size() == sets.size();
    }

    public static void main(String[] args) {
//        "badc"
//        "baba"
        Solution205 solution205 = new Solution205();
        System.out.println(solution205.isIsomorphic("badc", "baba"));
    }
}
