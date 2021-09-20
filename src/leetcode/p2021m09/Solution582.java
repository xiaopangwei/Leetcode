package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/17
 * @time 10:12 PM
 */
public class Solution582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            int item = ppid.get(i);
            if (!nextMap.containsKey(item)) {
                nextMap.put(item, new ArrayList<>());
            }
            nextMap.get(item).add(pid.get(i));
        }

        List<Integer>  ans   = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            ans.add(temp);

            if (nextMap.containsKey(temp)) {
                List<Integer> nextList = nextMap.get(temp);
                for (int item : nextList) {
                    queue.add(item);
                }
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        Solution582 solution582 = new Solution582();
        List<Integer> ans = solution582.killProcess(Arrays.asList(1, 3, 10, 5),
                Arrays.asList(3, 0, 5, 3), 3);
        System.out.println(ans);
    }
}
