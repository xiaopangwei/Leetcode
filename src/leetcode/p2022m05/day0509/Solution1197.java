package leetcode.p2022m05.day0509;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 8:33 PM
 */
public class Solution1197 {
    int[][] directions = new int[][]{{-2, -1}, {-2, 1}, {2, 1}, {2, -1}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};

    public int minKnightMoves(int x, int y) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("0#0", 0);
        Queue<int[]> queue1 = new LinkedList<>();
        queue1.add(new int[]{0, 0});
        Map<String, Integer> map2   = new HashMap<>();
        Queue<int[]>         queue2 = new LinkedList<>();
        map2.put(x + "#" + y, 0);
        queue2.add(new int[]{x, y});

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() < queue2.size()) {
                int[]  temp = queue1.poll();
                String key  = temp[0] + "#" + temp[1];
                if (map2.containsKey(key)) {
                    return map1.get(key) + map2.get(key) + 1;
                }
                for (int i = 0; i < directions.length; i++) {
                    int    newX  = temp[0] + directions[i][0];
                    int    newY  = temp[1] + directions[i][1];
                    String biKey = newX + "#" + newY;
                    if (map1.containsKey(biKey)) {
                        continue;
                    }
                    queue1.add(new int[]{newX, newY});
                    map1.put(biKey, map1.get(key) + 1);
                }
            } else {
                int[]  temp = queue2.poll();
                String key  = temp[0] + "#" + temp[1];
                if (map1.containsKey(key)) {
                    return map1.get(key) + map2.get(key) + 1;
                }
                for (int i = 0; i < directions.length; i++) {
                    int    newX  = temp[0] + directions[i][0];
                    int    newY  = temp[1] + directions[i][1];
                    String biKey = newX + "#" + newY;
                    if (map2.containsKey(biKey)) {
                        continue;
                    }
                    queue2.add(new int[]{newX, newY});
                    map2.put(biKey, map2.get(key) + 1);
                }
            }
        }
        return -1;
    }
}
