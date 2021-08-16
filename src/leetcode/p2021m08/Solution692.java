package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 10:07 PM
 */
public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freqMap = new HashMap<>();
        for (String item : words) {
            int times = freqMap.getOrDefault(item, 0) + 1;
            freqMap.put(item, times);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) != 0) {
                    return o1.getValue().compareTo(o2.getValue());
                } else if (o1.getKey().compareTo(o2.getKey()) != 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return 0;
            }
        });
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (pq.size() < k) {
                pq.add(entry);
            } else {
                if (!pq.isEmpty()) {
                    Map.Entry<String, Integer> temp = pq.peek();
                    if (entry.getValue() > temp.getValue()) {
                        pq.poll();
                        pq.add(entry);
                    } else if ((entry.getValue().equals(temp.getValue()) && entry.getKey().compareTo(temp.getKey()) < 0)) {
                        pq.poll();
                        pq.add(entry);
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll().getKey());
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        Solution692  solution692 = new Solution692();
        List<String> ans         = solution692.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        System.out.println(ans);
    }
}
