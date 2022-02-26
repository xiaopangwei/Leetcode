package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/21
 * @time 8:29 PM
 */
public class Solution743Copy {
    public int networkDelayTime(int[][] times, int n, int k) {
        int     maxVal = Integer.MIN_VALUE;
        int[][] graph  = new int[n + 1][n + 1];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < times.length; i++) {
            int source = times[i][0];
            int target = times[i][1];
            graph[source][target] = times[i][2];
        }

        visited[k] = true;

        for (int t = 0; t < n - 1; t++) {
            int minIndex = -1;
            int minDist  = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[k][i] < minDist) {
                    minIndex = i;
                    minDist = graph[k][i];
                }
            }
//            System.out.println(minIndex + " " + minDist);

            if (minIndex == -1) {
                break;
            }
            visited[minIndex] = true;
            graph[k][minIndex] = minDist;
            for (int j = 1; j <= n; j++) {
                if (graph[minIndex][j] != Integer.MAX_VALUE &&
                        graph[k][minIndex] + graph[minIndex][j] < graph[k][j]) {
                    graph[k][j] = graph[k][minIndex] + graph[minIndex][j];
                }
            }
        }

//        System.out.println(Arrays.toString(graph[k]));
        for (int i = 1; i <= n; i++) {
            if (graph[k][i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxVal = Math.max(graph[k][i], maxVal);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Solution743Copy solution743 = new Solution743Copy();
        int             ans         = solution743.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
        System.out.println(ans);
    }
}
