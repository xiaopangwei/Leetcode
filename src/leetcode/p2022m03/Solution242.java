package leetcode.p2022m03;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/9
 * @time 8:31 AM
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freqS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqS.put(s.charAt(i), freqS.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> freqT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            freqT.put(t.charAt(i), freqT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return freqS.equals(freqT);
    }
}
