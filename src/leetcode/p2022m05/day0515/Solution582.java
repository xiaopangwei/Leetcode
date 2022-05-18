package leetcode.p2022m05.day0515;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/15
 * @time 9:12 PM
 */
public class Solution582 {
    Map<Integer, List<Integer>> map;
    List<Integer> list = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int p1 = pid.get(i);
            int p2 = ppid.get(i);
            if (!map.containsKey(p2)) {
                map.put(p2, new ArrayList<>());
            }
            map.get(p2).add(p1);
        }

        System.out.println(map);
        list.addAll(bfs(kill));
        return list;
    }

    private Set<Integer> bfs(int kill) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        Set<Integer> visited = new HashSet<>();
        visited.add(kill);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!map.containsKey(temp)) {
                continue;
            }
            for (int item : map.get(temp)) {
                if (!visited.contains(item)) {
                    visited.add(item);
                    queue.add(item);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {

        Solution582 solution582 = new Solution582();
        System.out.println(solution582.killProcess(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(0, 1, 1, 1, 1), 1));


    }
}
