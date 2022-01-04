package leetcode.p2022m01;


import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/2
 * @time 11:30 PM
 */
public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();
        if (n <= 1) {
            ans.add(0);
            return ans;
        }
        int[]                       degree = new int[n];
        Map<Integer, List<Integer>> inMap  = new HashMap<>();
        for (int[] arr : edges) {
            if (!inMap.containsKey(arr[0])) {
                inMap.put(arr[0], new ArrayList<>());
            }
            if (!inMap.containsKey(arr[1])) {
                inMap.put(arr[1], new ArrayList<>());
            }
            inMap.get(arr[0]).add(arr[1]);
            inMap.get(arr[1]).add(arr[0]);

            degree[arr[0]]++;
            degree[arr[1]]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int t = queue.poll();
                ans.add(t);

                List<Integer> neighbors = inMap.get(t);
                if (neighbors!=null && !neighbors.isEmpty()) {
                    for (int k : neighbors) {
                        degree[k]--;
                        if (degree[k] == 1) {
                            queue.add(k);
                        }
                    }
                }

            }
        }

        return ans;

    }


}
