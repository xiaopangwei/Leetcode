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
 * @date 2021/11/21
 * @time 9:46 PM
 */
public class Solution451 {
    public String frequencySort(String s) {

        Map<Character,Integer> freq=new HashMap<>();
        for (int i=0;i<s.length();i++){
            int t=freq.getOrDefault(s.charAt(i),0)+1;
            freq.put(s.charAt(i),t);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        for (Map.Entry<Character,Integer> entry:freq.entrySet()){
            pq.add(entry);
        }

        StringBuilder builder=new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry<Character,Integer> entry=pq.poll();
            int times=entry.getValue();
            char ch=entry.getKey();
            for (int i=0;i<times;i++){
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Solution451 solution451=new Solution451();
        String ans=solution451.frequencySort("Aabb");
        System.out.println(ans);
    }
}
