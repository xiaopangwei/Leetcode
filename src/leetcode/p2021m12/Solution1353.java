package leetcode.p2021m12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/16
 * @time 9:47 PM
 */
public class Solution1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;

        int day=events[0][0];

        int ans=0;


        while (!pq.isEmpty() || i<events.length){

            while (i<events.length && events[i][0]==day){
                pq.add(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek()< day){
                pq.poll();
            }


            if (!pq.isEmpty()){
                pq.poll();
                ans+=1;
            }

            day++;

        }

        return ans;
    }
}
