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
 * @date 2021/8/15
 * @time 4:49 PM
 */
public class Solution1647 {

    public int minDeletions(String s) {
        Map<Character, Integer> charAndFreqRefMap = new HashMap<>();
        int                     len               = s.length();
        for (int i = 0; i < len; i++) {
            int times = charAndFreqRefMap.getOrDefault(s.charAt(i), 0)+1;
            charAndFreqRefMap.put(s.charAt(i), times);
        }
        //<size,Map<Character,Integer>>

        Set<Character> keyset = charAndFreqRefMap.keySet();

        Set<Integer> freqSet = new HashSet<>();
        int          ans     = 0;
        for (Character ch : keyset) {
            int freq = charAndFreqRefMap.get(ch);
            if (!freqSet.contains(freq)) {
                freqSet.add(freq);
            } else {
                while (true) {
                    if (freq == 0) {
                        break;
                    }
                    freq--;
                    ans++;
                    if (!freqSet.contains(freq)) {
                        freqSet.add(freq);
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1647 solution1647 = new Solution1647();
        int          ans          = solution1647.minDeletions("ceabaacb");
        System.out.println(ans);
    }
}
