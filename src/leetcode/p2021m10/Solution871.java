package leetcode.p2021m10;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/16
 * @time 2:49 PM
 */
public class Solution871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int maxPos = startFuel;

        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stations.length; i++) {
            if (maxPos >= stations[i][0]) {
                pq.add(stations[i][1]);
            } else {
                while (!pq.isEmpty() && maxPos < stations[i][0]) {
                    int temp = pq.poll();
                    maxPos += temp;
                    count++;
                }

                if (maxPos < stations[i][0]) {
                    return -1;
                }

                pq.add(stations[i][1]);
            }
        }

        if (maxPos >= target) {
            return count;
        }
        while (!pq.isEmpty() && maxPos < target) {
            int temp = pq.poll();
            maxPos += temp;
            count++;
        }

        if (maxPos < target) {
            return -1;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        Solution871 solution871 = new Solution871();
        int         ans         = solution871.minRefuelStops(100, 25, new int[][]{{25,25},{50,25},{75,25}});
        System.out.println(ans);
    }
}
