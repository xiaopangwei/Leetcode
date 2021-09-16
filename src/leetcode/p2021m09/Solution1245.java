package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/15
 * @time 10:05 PM
 */
public class Solution1245 {
    int maxLength = -1;

    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end   = edges[i][1];
            if (!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            }
            if (!map.containsKey(end)) {
                map.put(end, new ArrayList<>());
            }

            map.get(start).add(end);
            map.get(end).add(start);
        }

        int[] arr1 = bfs(edges[0][0], map);
        int[] arr2 = bfs(arr1[0], map);

        Set<Integer> visited = new HashSet<>();
        dfs(arr1[0], arr2[0], map, 0, visited);
        return maxLength;
    }

    private void dfs(int start, int end, Map<Integer, List<Integer>> map, int level, Set<Integer> visited) {
        if (start == end) {
            maxLength = Math.max(maxLength, level);
            return;
        }

        visited.add(start);
        List<Integer> list = map.get(start);
        for (int item : list) {
            if (visited.contains(item)) {
                continue;
            }
            dfs(item, end, map, level + 1, visited);

        }
        visited.remove((Integer) start);
    }

    private int[] bfs(int vertex, Map<Integer, List<Integer>> map) {
        Queue<int[]> queue       = new LinkedList<>();
        int          farestIndex = -1;
        int          step        = -1;
        queue.add(new int[]{vertex, 0});
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[1] > step) {
                farestIndex = temp[0];
                step = temp[1];
            }
            visited.add(temp[0]);
            List<Integer> list = map.get(temp[0]);
            for (int item : list) {
                if (!visited.contains(item)) {
                    queue.add(new int[]{item, temp[1] + 1});
                }
            }
        }
        return new int[]{farestIndex, step};

    }

    public static void main(String[] args) {
        Solution1245 solution1245 = new Solution1245();
        int          ans          = solution1245.treeDiameter(new int[][]{{0, 1}, {0, 2}});
        System.out.println(ans);
    }
}
