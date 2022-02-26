package leetcode.p2022m02;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/24
 * @time 3:55 PM
 */
public class Solution871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int remained = startFuel;
        int i        = 0;
        int ans      = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        while (true) {
            while (i < stations.length && remained >= stations[i][0]) {
                pq.add(stations[i][1]);
                i++;
            }

            if (pq.isEmpty()) {
                if (remained < target) {
                    return -1;
                } else {
                    return ans;
                }
            }

            remained += pq.poll();
            ans++;
            if (remained >= target) {
                return ans;
            }

        }
    }

    public static void main(String[] args) {
        Solution871 solution871 = new Solution871();
        int         ans         = solution871.minRefuelStops(100, 10,
                new int[][]{{10,60},{20,30},{30,60},{60,40}});
        System.out.println(ans);
    }
}
