package leetcode.p2022m06.day0612;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/21
 * @time 8:06 PM
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>               ans      = new ArrayList<>();
        Map<Integer, List<Integer>> nextList = new HashMap<>();
        int[]                       degree   = new int[numCourses];

        for (int[] item : prerequisites) {
            //item[1]->item[0]
            degree[item[0]]++;
            if (!nextList.containsKey(item[1])) {
                nextList.put(item[1], new ArrayList<>());
            }
            nextList.get(item[1]).add(item[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                ans.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            count++;
            List<Integer> list = nextList.get(t);
            if (list != null && !list.isEmpty()) {
                for (int v : list) {
                    degree[v]--;

                    if (degree[v] == 0) {
                        queue.add(v);
                        ans.add(v);
                    }
                }
            }
        }

        if (count != numCourses) {
            return new int[0];
        }
        int[] temp = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            temp[i] = ans.get(i);
        }
        return temp;
    }
}
