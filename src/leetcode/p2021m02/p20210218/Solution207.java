package leetcode.p2021m02.p20210218;


import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 11:17 AM
 */
public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[]               degree  = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            degree[item[0]]++;
            adjList.get(item[1]).add(item[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int t = queue.poll();
            count++;
            List<Integer> nextCourses = adjList.get(t);
            if (nextCourses != null) {
                for (int next : nextCourses) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        Solution207 solution131 = new Solution207();
        boolean     ans         = solution131.canFinish(2, new int[][]{{1, 0}});

//        boolean     ans         = solution131.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
        System.out.println(ans);


    }


}
