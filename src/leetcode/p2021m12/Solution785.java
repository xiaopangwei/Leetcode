package leetcode.p2021m12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/1
 * @time 9:18 PM
 */
public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] visited = new int[len];
        for (int i = 0; i < len; i++) {
            if (visited[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int   temp     = queue.poll();
                int[] adjacent = graph[temp];

                for (int k : adjacent) {
                    if (visited[temp] == visited[k]) {
                        return false;
                    }

                    if (visited[k] == 0) {
                        visited[k] = -visited[temp];
                        queue.add(k);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution785 solution785 = new Solution785();
        //{{1,2,3},{0,2},{0,1,3},{0,2}}
        int[][] array = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        ;
        boolean ans = solution785.isBipartite(array);
        System.out.println(ans);
    }
}
