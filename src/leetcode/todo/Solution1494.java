package leetcode.todo;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 2:54 PM
 */
public class Solution1494 {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int                         ans         = 0;
        int[]                       degree      = new int[n + 1];
        Map<Integer, List<Integer>> nextCourses = new HashMap<>();
        for (int[] array : relations) {
            degree[array[1]]++;
            if (!nextCourses.containsKey(array[0])) {
                nextCourses.put(array[0], new ArrayList<>());
            }
            nextCourses.get(array[0]).add(array[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size % k == 0) {
                ans += size / k;
            } else {
                ans += (size / k) + 1;
            }
            for (int i = 0; i < size; i++) {
                int           temp = queue.poll();
                List<Integer> adj  = nextCourses.get(temp);
                if (adj != null && !adj.isEmpty()) {
                    for (int item : adj) {
                        degree[item]--;
                        if (degree[item] == 0) {
                            queue.add(item);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1494 solution1494 = new Solution1494();
        int          n            = solution1494.minNumberOfSemesters(11, new int[][]{}, 2);
        System.out.println(n);
    }
}
