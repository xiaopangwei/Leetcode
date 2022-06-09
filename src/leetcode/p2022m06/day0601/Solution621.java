package leetcode.p2022m06.day0601;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 11:19 PM
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        int T = n + 1;

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(entry);
        }
        int ans = 0;

        while (!pq.isEmpty()) {
            Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
            int                                  count = 0;
            for (int i = 0; i < T; i++) {
                if (pq.isEmpty()) {
                    break;
                }
                count++;

                Map.Entry<Character, Integer> e = pq.poll();

                queue.add(e);

            }

//            System.out.println(count);

            while (!queue.isEmpty()) {
                Map.Entry<Character, Integer> e = queue.poll();
                if (e.getValue() - 1 > 0) {
                    e.setValue(e.getValue() - 1);
                    pq.add(e);
                }
            }

            if (!pq.isEmpty()) {
                ans += T;
            } else {
                ans += count;
            }
            System.out.println("ans:" + ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution621 solution621 = new Solution621();
        int         ans         = solution621.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        System.out.println(ans);
    }
}
