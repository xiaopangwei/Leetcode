package leetcode.p2022m05.day0514;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 5:14 PM
 */
public class Solution358 {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (!o2.getValue().equals(o1.getValue())) {
                    return o2.getValue().compareTo(o1.getValue());
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            pq.add(e);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                if (pq.isEmpty()) {
                    if (sb.length() != s.length()) {
                        return "";
                    } else {
                        break;
                    }
                }
                Map.Entry<Character, Integer> e = pq.poll();
                sb.append(e.getKey());
                if (e.getValue() > 1) {
                    e.setValue(e.getValue() - 1);
                    queue.add(e);
                }
            }

            while (!queue.isEmpty()) {
                pq.add(queue.poll());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution358 solution358 = new Solution358();
        System.out.println(solution358.rearrangeString("abb", 2));
    }
}
