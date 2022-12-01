package leetcode.p2022q4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/30
 * @time 10:36 PM
 */
public class Solution2423 {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            freq.put(word.charAt(i), freq.getOrDefault(word.charAt(i), 0) + 1);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            map.put(e.getValue(), map.getOrDefault(e.getValue(), 0) + 1);
        }

        if (map.keySet().size() != 2) {
            return false;
        }

        return Math.abs(map.lastEntry().getValue() - map.firstEntry().getValue()) == 1;
    }

    public static void main(String[] args) {
        Solution2423 solution2423 = new Solution2423();
        System.out.println(solution2423.equalFrequency("bac"));
    }
}
