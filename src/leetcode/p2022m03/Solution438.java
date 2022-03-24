package leetcode.p2022m03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/9
 * @time 8:35 AM
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>           ans   = new ArrayList<>();
        int                     len   = p.length();
        Map<Character, Integer> freqP = new HashMap<>();
        Map<Character, Integer> freqS = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            freqP.put(p.charAt(i), freqP.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < Math.min(len, s.length()); i++) {
            freqS.put(s.charAt(i), freqS.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (freqP.equals(freqS)) {
            ans.add(0);
        }
        for (int i = len; i < s.length(); i++) {
            freqS.put(s.charAt(i), freqS.getOrDefault(s.charAt(i), 0) + 1);
            char left = s.charAt(i - len);
            freqS.put(left, freqS.getOrDefault(left, 0) - 1);
            if (freqS.get(left) <= 0) {
                freqS.remove(left);
            }
            if (freqP.equals(freqS)) {
                ans.add(i-len+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution438   solution438 = new Solution438();
        List<Integer> ans         = solution438.findAnagrams("abab", "ab");
        System.out.println(ans);
    }
}
