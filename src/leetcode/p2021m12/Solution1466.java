package leetcode.p2021m12;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/2
 * @time 10:18 PM
 */
public class Solution1466 {
    public int minReorder(int n, int[][] connections) {
        int                         ans    = 0;
        Map<Integer, List<Integer>> inMap  = new HashMap<>();
        Map<Integer, List<Integer>> outMap = new HashMap<>();

        for (int i = 0; i < connections.length; i++) {
            int[] biArr = connections[i];
            if (!inMap.containsKey(biArr[0])) {
                inMap.put(biArr[0], new ArrayList<>());
            }
            inMap.get(biArr[0]).add(biArr[1]);

            if (!outMap.containsKey(biArr[1])) {
                outMap.put(biArr[1], new ArrayList<>());
            }
            outMap.get(biArr[1]).add(biArr[0]);
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            List<Integer> inNextList = inMap.get(temp);

            if (inNextList != null) {
                for (int item : inNextList) {
                    if (!visited[item]) {
                        ans++;
                        queue.add(item);
                    }
                }
            }


            List<Integer> outNextList = outMap.get(temp);
            if (outNextList != null) {

                for (int item : outNextList) {
                    if (!visited[item]) {
                        queue.add(item);
                    }
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        Solution1466 solution1466 = new Solution1466();
        int          ans          = solution1466.minReorder(3, new int[][]{{1,0},{2,0}});
        System.out.println(ans);
    }
}
