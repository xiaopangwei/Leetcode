package leetcode.p2022m03;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/9
 * @time 8:46 AM
 */
public class Solution767 {
    public String reorganizeString(String s) {
        if (s.length() < 2) {
            return s;
        }
        int                     maxFreq = 0;
        Map<Character, Integer> freq    = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(freq.get(ch), maxFreq);
        }

        if (s.length() % 2 == 0 && maxFreq > s.length() / 2) {
            return "";
        }
        if (s.length() % 2 == 1 && maxFreq > (s.length() + 1) / 2) {
            return "";
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(entry);
        }

        while (!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                if (!pq.isEmpty()) {
                    Map.Entry<Character, Integer> entry = pq.poll();
                    ans.append(entry.getKey());
                    temp.add(entry);
                }
            }
            for (Map.Entry<Character, Integer> e : temp) {
                int f = e.getValue() - 1;
                if (f > 0) {
                    e.setValue(f);
                    pq.add(e);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution767 solution767 = new Solution767();
        String      ans         = solution767.reorganizeString("aaababaacbb");
        System.out.println(ans);
    }
}
