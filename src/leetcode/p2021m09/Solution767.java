package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/2
 * @time 10:19 PM
 */
public class Solution767 {
    public String reorganizeString(String s) {

        char[] charArray = s.toCharArray();

        Map<Character, Integer> freq = new HashMap<>();

        int maxFreq = 0;
        for (char ch : charArray) {
            int temp = freq.getOrDefault(ch, 0) + 1;
            maxFreq = Math.max(temp, maxFreq);
            freq.put(ch, temp);
        }

        int length = charArray.length;
        if (length % 2 == 0 && maxFreq > length / 2) {
            return "";
        } else if (length % 2 != 0 && maxFreq > (length + 1) / 2) {
            return "";
        }


        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue().compareTo(o1.getValue());
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(entry);
        }


        int    typesCount = 2;
        char[] ans        = new char[charArray.length];
        int    k          = 0;

        while (true) {
            if (k >= length) {
                break;
            }

            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
            for (int i = 0; i < typesCount; i++) {
                if (pq.isEmpty()) {
                    break;
                }
                Map.Entry<Character, Integer> entry = pq.poll();
                temp.add(entry);
            }

            for (Map.Entry<Character, Integer> item : temp) {
                ans[k++] = item.getKey();
                int newF = item.getValue().intValue();
                item.setValue(--newF);
            }
            for (Map.Entry<Character, Integer> item : temp) {
                if (!item.getValue().equals(0)) {
                    pq.add(item);
                }
            }
        }

        return new String(ans);

    }

    public static void main(String[] args) {
        Solution767 solution767 = new Solution767();
        String      ans         = solution767.reorganizeString("aaabbbccc");
        System.out.println(ans);
    }

}
