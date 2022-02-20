package leetcode.p2022m02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/15
 * @time 8:54 PM
 */
public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int   length  = graph.length;
        int[] visited = new int[length];
        //0 表示未染色
        //1 表示染成1
        //2 表示染成2
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            visited[i] = 1;
            queue.add(i);
            while (!queue.isEmpty()) {
                int   temp  = queue.poll();
                int   color = visited[temp];
                int[] adj   = graph[temp];
                for (int item : adj) {
                    if (visited[item] == 0) {
                        visited[item] = color == 1 ? 2 : 1;
                        queue.add(item);
                    } else if (visited[item] == color) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Solution785 solution785 = new Solution785();
        boolean     ans         = solution785.isBipartite(new int[][]{{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}});
        System.out.println(ans);
    }
}
