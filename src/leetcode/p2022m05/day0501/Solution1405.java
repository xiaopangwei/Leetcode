package leetcode.p2022m05.day0501;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 2:52 PM
 */
public class Solution1405 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('a', a);
        freqMap.put('b', b);
        freqMap.put('c', c);

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 0) {
                pq.add(entry);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> temp = pq.poll();
            int                           len  = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == sb.charAt(len - 2) && sb.charAt(len - 1) == temp.getKey()) {
                Map.Entry<Character, Integer> second = pq.poll();
                if (second == null) {
                    break;
                }
                sb.append(second.getKey());
                second.setValue(second.getValue() - 1);
                if (second.getValue() > 0) {
                    pq.add(second);
                }
                pq.add(temp);
            } else {
                int f = temp.getValue();
                if (f >= 2) {
                    sb.append(temp.getKey());
                    sb.append(temp.getKey());
                    f -= 2;
                    if (f > 0) {
                        temp.setValue(f);
                        pq.add(temp);
                    }
                } else {
                    sb.append(temp.getKey());
                    f -= 1;
                    if (f > 0) {
                        temp.setValue(f);
                        pq.add(temp);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1405 solution1405 = new Solution1405();
        String       ans          = solution1405.longestDiverseString(7, 1, 0);
        System.out.println(ans);
    }
}
