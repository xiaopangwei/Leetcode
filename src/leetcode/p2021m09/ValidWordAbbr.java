package leetcode.p2021m09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/17
 * @time 8:58 PM
 */
public class ValidWordAbbr {
    public Map<String, Set<String>> cache = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String item : dictionary) {
            String k = shorten(item);
            if (!cache.containsKey(k)) {
                cache.put(k, new HashSet<>());
            }
            cache.get(k).add(item);
        }
    }

    public boolean isUnique(String word) {
        String abbr = shorten(word);
        if (!cache.containsKey(abbr)) {
            return true;
        }
        Set<String> sets = cache.get(abbr);
        if (sets.size() == 1 && sets.contains(word)) {
            return true;
        }
        return false;

    }

    public String shorten(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int len = s.length();
        return s.substring(0, 1) + String.valueOf(len - 2) + s.substring(len - 1, len);
    }

    public static void main(String[] args) {
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        validWordAbbr.isUnique("cake");
    }
}
