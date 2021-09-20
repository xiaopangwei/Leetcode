package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/20
 * @time 10:14 PM
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {

        String[] array = s.split(" ");

        if (array.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        int                    i    = 0;
        int                    j    = 0;
        while (i < pattern.length() && j < array.length) {
            char ch = pattern.charAt(i);
            if (!map1.containsKey(ch)) {
                if (map2.containsKey(array[j])){
                    return false;
                }else {
                    map1.put(ch, array[j]);
                    map2.put(array[j], ch);
                    i++;
                    j++;
                }
            } else {
                if (!map1.get(ch).equals(array[j])) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution290 solution290 = new Solution290();
        boolean     ans         = solution290.wordPattern("abba", "dog cat cat dog");
        System.out.println(ans);

    }
}
