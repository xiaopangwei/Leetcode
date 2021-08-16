package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 4:35 PM
 */
public class Solution621 {
    static class Item {
        public char k;
        public int  freq;

        public Item(char k, int freq) {
            this.k = k;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "(" + k + " " + freq + ")";
        }
    }

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.freq != o2.freq) {
                    return o2.freq - o1.freq;
                } else {
                    return o1.k - o2.k;
                }
            }
        });
        for (char ch : freq.keySet()) {
            queue.add(new Item(ch, freq.get(ch)));
        }

        int period = n + 1;

        int count = 0;
        int everyLineBlank=0;
        while (!queue.isEmpty()) {
            Queue<Item> tempQueue = new LinkedList<>();
            everyLineBlank=0;
            for (int i = 0; i < period; i++) {
                if (!queue.isEmpty()) {
                    Item selected = queue.poll();
//                    System.out.println(selected+" "+count);
                    tempQueue.add(selected);
                    count++;
                }else{
                    count++;
                    everyLineBlank++;
                }
            }

//            System.out.println("--------------");
            while (!tempQueue.isEmpty()) {
                Item prev = tempQueue.poll();
                if (prev.freq > 1) {
                    Item next = new Item(prev.k, prev.freq - 1);
                    queue.add(next);
                }
            }
        }

        return count-everyLineBlank;
    }

    public static void main(String[] args) {
        Solution621 solution621 = new Solution621();
        char[]      array       = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int         cnt         = solution621.leastInterval(array, 0);
        System.out.println(cnt);
    }
}
