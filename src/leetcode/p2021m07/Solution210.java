package leetcode.p2021m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 4:16 PM
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[]               ans     = new int[numCourses];
        int                 index   = 0;
        int[]               degree  = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        if (prerequisites!=null && prerequisites.length>0) {
            for (int[] item : prerequisites) {
                degree[item[0]]++;
                adjList.get(item[1]).add(item[0]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int count=0;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            int t = queue.poll();
            ans[index++] = t;
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
        if (count==numCourses){
            return ans;
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        Solution210 solution210 = new Solution210();
        int[]       ans         = solution210.findOrder(1, new int[][]{{}});
        System.out.println(Arrays.toString(ans));
    }
}
