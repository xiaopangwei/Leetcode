package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/2
 * @time 9:10 AM
 */
public class Solution743II {
    static class BiKey {
        public int id;
        public int distance;

        @Override
        public boolean equals(Object obj) {
            BiKey biKey = (BiKey) obj;
            if (biKey.id == this.id) {
                return true;
            }
            return false;
        }

        public BiKey(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> edge = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            if (!edge.containsKey(times[i][0])) {
                edge.put(times[i][0], new ArrayList<>());
            }
            edge.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        PriorityQueue<BiKey> queue = new PriorityQueue<>(new Comparator<BiKey>() {
            @Override
            public int compare(BiKey o1, BiKey o2) {
                return o1.distance - o2.distance;
            }
        });
        queue.add(new BiKey(k, 0));
        boolean[] visited  = new boolean[n + 1];
        int[]     distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        while (!queue.isEmpty()) {
            BiKey temp = queue.poll();
            int   idx  = temp.id;
            if (visited[idx]) {
                System.out.println("Abandon "+idx+" "+temp.distance);
                continue;
            }
            visited[idx] = true;
            distance[idx] = temp.distance;
            System.out.println(idx + " " + distance[idx]);
            List<int[]> neigborhood = edge.get(temp.id);
            //5 3 2 4
            if (neigborhood != null) {
                for (int[] array : neigborhood) {
                    int targetId = array[0];
                    int dest     = array[1];
                    if (visited[targetId]) {
                        continue;
                    }
                    distance[targetId] = Math.min(distance[targetId], dest + temp.distance);
                    queue.add(new BiKey(targetId, distance[targetId]));
                }
            }
        }

        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans = Math.max(ans, distance[i]);
            }
        }
        return ans;
    }

    //        5
//        3
//        2
//        4
//        [0, 0, 59, 56, 69, 54]
    public static void main(String[] args) {
        int[][]       array       = new int[][]{{2, 4, 10}, {5, 2, 38}, {3, 4, 33}, {4, 2, 76}, {3, 2, 64}, {1, 5, 54}, {1, 4, 98}, {2, 3, 61}, {2, 1, 0}, {3, 5, 77}, {5, 1, 34}, {3, 1, 79}, {5, 3, 2}, {1, 2, 59}, {4, 3, 46}, {5, 4, 44}, {2, 5, 89}, {4, 5, 21}, {1, 3, 86}, {4, 1, 95}};
        Solution743II solution743 = new Solution743II();
        int           ans         = solution743.networkDelayTime(array, 5, 1);
        System.out.println(ans);
    }
}
