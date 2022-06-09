package leetcode.p2022m06.day0601;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/4
 * @time 10:29 AM
 */
public class Solution871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int maxDist = startFuel;
        int count   = 0;


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int i = 0;

        while (true) {
            while (i < stations.length && stations[i][0] <= maxDist) {
                pq.add(stations[i][1]);
                i++;
            }

            if (pq.isEmpty()) {
                if (maxDist < target) {
                    return -1;
                } else {
                    return count;
                }
            } else {
                int temp = pq.poll();
                count++;
                maxDist += temp;
                if (maxDist >= target) {
                    return count;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution871 solution871 = new Solution871();
        //target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
        int max = solution871.minRefuelStops(100, 1, new int[][]{{10, 100}});
        System.out.println(max);
    }
}
