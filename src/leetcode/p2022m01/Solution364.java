package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/8
 * @time 4:17 PM
 */
public class Solution364 {
    int sum = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        bfs(nestedList);
        return 0;
    }

    private void bfs(List<NestedInteger> nestedList) {

        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);
        List<List<Integer>> lists = new ArrayList<>();
        int                 depth = 1;
        while (!queue.isEmpty()) {
            int           size = queue.size();
            List<Integer> rows = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NestedInteger temp = queue.poll();
                if (temp.isInteger()) {
                    rows.add(temp.getInteger());
                } else {
                    queue.addAll(temp.getList());
                }
            }

            lists.add(rows);

            depth++;
        }

        System.out.println(lists);
        System.out.println(depth);
    }
}
