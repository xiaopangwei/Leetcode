package leetcode.p2022m06.day0612;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/20
 * @time 10:15 PM
 */
public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] temp   = pq.poll();
            int   vertex = temp[0];
            int   d      = temp[1];
            if (dist[vertex] < d) {
                continue;
            }
            for (int[] t : times) {
                if (t[0] == vertex && d + t[2] < dist[t[1]]) {
                    dist[t[1]] = d + t[2];
                    pq.add(new int[]{t[1], dist[t[1]]});
                }
            }
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxLen = Math.max(maxLen, dist[i]);
        }

        return maxLen;

    }

    public int networkDelayTime2(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }
        for (int[] t : times) {
            graph[t[0]][t[1]] = t[2];
        }

        boolean[] visited = new boolean[n + 1];
        int[]     minDist = new int[n + 1];
        Arrays.fill(minDist,Integer.MAX_VALUE);
        minDist[k] = 0;
        visited[k] = true;
        for (int i = 0; i < n - 1; i++) {
            int[] temp = findMin(graph, k, visited, n);
            int   v    = temp[0];
            int   d    = temp[1];
            if (v != -1 && d != Integer.MAX_VALUE) {
                minDist[v] = d;
                visited[v] = true;
                for (int j = 1; j <= n; j++) {
                    if (!visited[j] && graph[v][j] != Integer.MAX_VALUE && d + graph[v][j] < minDist[j]) {
                        minDist[j] = d + graph[v][j];
                    }
                }
            }
        }

        int maxLen = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(minDist));
        for (int i = 1; i <= n; i++) {
            if (minDist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxLen = Math.max(maxLen, graph[k][i]);
        }
        return maxLen;

    }


    private int[] findMin(int[][] graph, int k, boolean[] visited, int n) {
        int minIndex = -1;
        int minDist  = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[k][i] < minDist) {
                minDist = graph[k][i];
                minIndex = i;
            }
        }
        return new int[]{minIndex, minDist};
    }

    public static void main(String[] args) {
        //输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
        int[][]     array       = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        Solution743 solution743 = new Solution743();
        int         ans         = solution743.networkDelayTime2(array, 4, 2);
        System.out.println(ans);
    }
}
