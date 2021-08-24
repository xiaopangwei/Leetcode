package leetcode.p2021m08;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/24
 * @time 10:20 AM
 */
public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        //dst,fee,hop
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int target = flights[i][1];
            int fee    = flights[i][2];
            if (!map.containsKey(source)) {
                map.put(source, new HashMap<>());
            }
            map.get(source).put(target, fee);
        }

        pq.add(new int[]{src, 0, 0});

//        boolean[] visited = new boolean[n];

//        visited[src] = true;
        while (!pq.isEmpty()) {

            int[] temp = pq.poll();

//            visited[temp[0]] = true;
            if (temp[0] == dst) {
                return temp[1];
            }

            if (temp[2] <= K) {
                if (map.containsKey(temp[0])) {
                    Map<Integer, Integer> distance = map.get(temp[0]);
                    for (Map.Entry<Integer, Integer> entry : distance.entrySet()) {
                        int key = entry.getKey();
                        int val = entry.getValue();
//                        if (!visited[key]) {
                            pq.add(new int[]{key, temp[1] + val, temp[2] + 1});
//                        }
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution787 solution787 = new Solution787();
        int[][] array={{11,12,74},{1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},{4,0,91},{11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},{6,2,8},{4,3,54},{3,11,76},{3,12,23},{11,6,79},{6,12,36},{2,11,100},{2,5,49},{7,0,17},{5,8,95},{3,9,98},{8,10,61},{2,12,38},{5,7,58},{9,4,37},{8,6,79},{9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},{6,9,53},{7,4,90},{0,5,43},{11,2,52},{11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},{12,0,26},{10,5,38},{12,8,50},{0,2,77},{11,0,13},{9,10,76},{2,6,67},{5,6,34},{9,7,62},{5,3,67}};
        int         ans         = solution787.findCheapestPrice(13, array, 10, 1, 10);
        System.out.println(ans);
    }
}
