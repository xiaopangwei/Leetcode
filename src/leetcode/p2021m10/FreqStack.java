package leetcode.p2021m10;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/13
 * @time 9:00 PM
 */
public class FreqStack {


    public int                   index = 0;
    public Map<Integer, Integer> map   = new HashMap<>();

    public PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            }
            return o2[2] - o1[2];
        }
    });

    public FreqStack() {

    }

    public void push(int val) {

        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
        pq.add(new int[]{val,freq,index++});

    }

    public int pop() {
        int[] array = pq.poll();
        int   key   = array[0];

        int freq = array[1];

        map.put(key, freq - 1);

        return key;
    }

    public static void main(String[] args) {
        FreqStack s = new FreqStack();
        s.push(5);
        s.push(7);
        s.push(5);
        s.push(7);

        s.push(4);
        s.push(5);

        for (int i = 0; i < 4; i++) {
            System.out.println(s.pop());
        }
    }
}
