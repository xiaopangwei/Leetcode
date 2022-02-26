package leetcode.p2022m02;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/22
 * @time 10:05 PM
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(entry);
        }

        int ans = 0;

        int cycle = n + 1;

        while (!pq.isEmpty()) {
            Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
            int                                  count = 0;
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    Map.Entry<Character, Integer> entry = pq.poll();
                    queue.add(entry);
                    count++;
                }
            }

            while (!queue.isEmpty()) {
                Map.Entry<Character, Integer> entry   = queue.poll();
                int                           newFreq = entry.getValue() - 1;
                if (newFreq > 0) {
                    entry.setValue(newFreq);
                    pq.add(entry);
                }
            }
            if (pq.isEmpty()) {
                ans += count;
            } else {
                ans += cycle;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution621 solution621 = new Solution621();
        int         ans         = solution621.leastInterval(new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'B' }, 2);
        System.out.println(ans);
    }
}
