package leetcode.p2022q4;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/1
 * @time 10:35 PM
 */
public class Solution2384 {
    public String largestPalindromic(String num) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (char ch : num.toCharArray()) {
            int t = ch - '0';
            freq.put(t, freq.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (!o1.getValue().equals(o2.getValue())) {
                    return o2.getValue() - o1.getValue();
                }
                return o2.getKey() - o1.getKey();
            }
        });


        for (Map.Entry<Integer,Integer> entry:freq.entrySet()){
            pq.add(entry);
        }

        StringBuilder       sb   = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            if (entry.getValue() % 2 != 0) {
                sb.append(entry.getKey());
                break;
            } else {
                for (int i = 0; i < entry.getValue() / 2; i++) {
                    sb.append(entry.getKey());
                    list.addFirst(entry.getKey());
                }
            }
        }

        for (int item : list) {
            int t = freq.get(item) / 2;
            for (int i = 0; i < t; i++) {
                sb.append(item);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2384 solution2384 = new Solution2384();
        System.out.println(solution2384.largestPalindromic("444947137"));
    }
}
