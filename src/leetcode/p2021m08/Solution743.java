package leetcode.p2021m08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/2
 * @time 9:10 AM
 */
public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        int   ans      = -1;
        int[] distance = new int[n + 1];

        int[][] weight = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                weight[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < times.length; i++) {
            weight[times[i][0]][times[i][1]] = times[i][2];
        }

        Set<Integer> visited   = new HashSet<>();
        Set<Integer> unvisited = new HashSet<>();

        visited.add(k);
        for (int i = 1; i <= n; i++) {
            if (i != k) {
                unvisited.add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (weight[k][i] != Integer.MAX_VALUE) {
                distance[i] = weight[k][i];
            } else {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        distance[k] = 0;


        for (int i = 0; i < n - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int to      = -1;


            for (int target : unvisited) {
                if (distance[target] < minDist) {
                    minDist = distance[target];
                    to = target;
                }
            }

            if (minDist == Integer.MAX_VALUE) {
                return -1;
            } else {
                System.out.println(to);
                distance[to] = minDist;
                visited.add(to);
                unvisited.remove(to);
                for (int target : unvisited) {
                    if (weight[to][target] != Integer.MAX_VALUE) {
                        distance[target] = Math.min(distance[to] + weight[to][target], distance[target]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans = Math.max(ans, distance[i]);
            }
        }

        System.out.println(Arrays.toString(distance));
        return ans;

    }

    public static void main(String[] args) {
        int[][]     array       = new int[][]{{2, 4, 10}, {5, 2, 38}, {3, 4, 33}, {4, 2, 76}, {3, 2, 64}, {1, 5, 54}, {1, 4, 98}, {2, 3, 61}, {2, 1, 0}, {3, 5, 77}, {5, 1, 34}, {3, 1, 79}, {5, 3, 2}, {1, 2, 59}, {4, 3, 46}, {5, 4, 44}, {2, 5, 89}, {4, 5, 21}, {1, 3, 86}, {4, 1, 95}};
        Solution743 solution743 = new Solution743();
        int         ans         = solution743.networkDelayTime(array, 5, 1);
        System.out.println(ans);
    }
}
