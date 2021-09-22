package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/20
 * @time 10:35 PM
 */
public class Solution291 {
    String pattern;
    String target;

    List<Map<Character, String>> ans = new ArrayList<>();

    public boolean wordPatternMatch(String pattern, String s) {

        this.pattern = pattern;
        this.target = s;

        return match(new HashMap<>(), 0, 0);
    }

    private boolean match(Map<Character, String> charAndStrMap,
                          int pIndex, int tIndex) {


        if (pattern.length() == pIndex && target.length() == tIndex) {

            Set<String> distinct = new HashSet<>(charAndStrMap.values());
            if (distinct.size() == charAndStrMap.values().size()) {
                System.out.println(charAndStrMap);
                return true;
            }
            return false;

        }
        if (pattern.length() == pIndex && target.length() != tIndex) {
            return false;
        }
        if (pattern.length() != pIndex && target.length() == tIndex) {
            return false;
        }
        //pattern的第一个字符 跟target的前一位，前两位...前i位匹配
        for (int i = tIndex + 1; i <= target.length(); i++) {
            String sub = target.substring(tIndex, i);
            char   ch  = pattern.charAt(pIndex);
            if (charAndStrMap.containsKey(ch) && !sub.equals(charAndStrMap.get(ch))) {
                continue;
            }
//            System.out.println(ch + " <==> " + sub + " " + pIndex + " " + tIndex + " " + charAndStrMap.get(ch));
            if (charAndStrMap.containsKey(ch)) {
                String temp = charAndStrMap.get(ch);
                //pIndex tIndex
                int     idx  = 0;
                boolean flag = true;
                while (idx < temp.length()) {
                    if (idx + tIndex >= target.length()) {
                        flag = false;
                        break;
                    } else if (temp.charAt(idx) != target.charAt(idx + tIndex)) {
                        flag = false;
                        break;
                    }
                    idx++;
                }
                if (flag) {
                    if (match(charAndStrMap, pIndex + 1, tIndex + temp.length())) {
                        return true;
                    }
                }
            } else {
                charAndStrMap.put(ch, sub);
                if (match(charAndStrMap, pIndex + 1, i)) {
                    return true;
                }
                charAndStrMap.remove(ch);
            }


        }

        return false;

    }

    public static void main(String[] args) {
        Solution291 solution291 = new Solution291();
        //pattern = "abab", s = "redblueredblue"
        boolean ans = solution291.wordPatternMatch("aabb", "xyzabcxzyabc");
//        boolean ans = solution291.wordPatternMatch("aba", "ege");
        System.out.println(ans);
    }
}
