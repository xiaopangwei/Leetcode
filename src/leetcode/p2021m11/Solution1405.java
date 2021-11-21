package leetcode.p2021m11;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/9
 * @time 8:56 PM
 */
public class Solution1405 {
    public String longestDiverseString(int a, int b, int c) {

        Map<Character, Integer> freq = new HashMap<>();

        if (a > 0) {
            freq.put('a', a);
        }

        if (b > 0) {
            freq.put('b', b);
        }

        if (c > 0) {
            freq.put('c', c);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder builder = new StringBuilder();

        pq.addAll(freq.entrySet());

        return "";
    }








    //ccbbccbbccbbccbbcc
    //ccbbccbbccbbccbbcc

    public static void main(String[] args) {
        Solution1405 solution1405 = new Solution1405();
        String       ans          = solution1405.longestDiverseString(0, 8, 11);
        System.out.println(ans);
    }
}
