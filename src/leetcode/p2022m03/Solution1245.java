package leetcode.p2022m03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/14
 * @time 9:25 PM
 */
public class Solution1245 {
    public int treeDiameter(int[][] edges) {

        int                 length = edges.length + 1;
        List<List<Integer>> grid   = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            grid.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            grid.get(edges[i][0]).add(edges[i][1]);
            grid.get(edges[i][1]).add(edges[i][0]);
        }

        int farest = bfs1(grid);
//        System.out.println(farest);
        int ans    = bfs2(grid, farest);
        return ans;
    }

    private int bfs2(List<List<Integer>> grid, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[grid.size()];
        visited[start] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int j = 0; j < grid.get(temp).size(); j++) {
                    int index=grid.get(temp).get(j);
                    if (!visited[index]) {
                        visited[index] = true;
                        queue.add(index);
                    }
                }
            }
            level++;
        }
        return level - 1;
    }

    private int bfs1(List<List<Integer>> grid) {
        Queue<Integer> queue = new LinkedList<>();
        int            last  = 0;
        queue.add(0);
        boolean[] visited = new boolean[grid.size()];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                last = temp;
                for (int j = 0; j < grid.get(temp).size(); j++) {
                    int index=grid.get(temp).get(j);
                    if (!visited[index]) {
                        visited[index] = true;
                        queue.add(index);
                    }
                }
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[][]      grid         = new int[][]{{0, 1}, {1, 2},{2,3},{1,4},{4,5}};
        Solution1245 solution1245 = new Solution1245();
        int          farest       = solution1245.treeDiameter(grid);
        System.out.println(farest);
    }
}
