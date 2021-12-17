package leetcode.p2021m12;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/1
 * @time 9:43 PM
 */
public class Solution886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        int[] visited = new int[n + 1];

        Map<Integer, List<Integer>> adjust = new HashMap<>();
        for (int[] item : dislikes) {
            if (!adjust.containsKey(item[0])) {
                adjust.put(item[0], new ArrayList<>());
            }
            adjust.get(item[0]).add(item[1]);
            if (!adjust.containsKey(item[1])) {
                adjust.put(item[1], new ArrayList<>());
            }
            adjust.get(item[1]).add(item[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            visited[i] = 1;
            queue.add(i);

            while (!queue.isEmpty()) {
                int           temp     = queue.poll();
                List<Integer> neighbor = adjust.get(temp);
                if (neighbor.isEmpty()){
                    continue;
                }
                for (int k : neighbor) {
                    if (visited[k] == visited[temp]) {
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
        Solution886 solution886 = new Solution886();
        boolean     ans         = solution886.possibleBipartition(1, new int[][]{});
        System.out.println(ans);
    }
}
