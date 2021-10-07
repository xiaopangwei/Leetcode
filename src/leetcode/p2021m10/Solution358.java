package leetcode.p2021m10;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/4
 * @time 11:42 PM
 */
public class Solution358 {
    public String rearrangeString(String s, int k) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(entry);
        }

        Queue<Map.Entry<Character, Integer>> queue   = new LinkedList<>();
        StringBuilder                        builder = new StringBuilder();
        while (!pq.isEmpty()) {


            Map.Entry<Character, Integer> temp = pq.poll();
            System.out.println(temp + " " + builder.toString());
            builder.append(temp.getKey());
            temp.setValue(temp.getValue() - 1);
            queue.add(temp);


            if (queue.size() == k) {
                Map.Entry<Character, Integer> t = queue.poll();
                if (t.getValue() > 0) {
                    pq.add(t);
                }
            }


        }


        String ans = builder.toString();
        if (ans.length() == s.length()) {
            return ans;
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Solution358 solution358 = new Solution358();
        String      ans         = solution358.rearrangeString("aaadbbcc", 2);
        System.out.println(ans);

    }
}
