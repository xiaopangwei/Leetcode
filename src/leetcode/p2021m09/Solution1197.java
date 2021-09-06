package leetcode.p2021m09;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/5
 * @time 8:11 PM
 */
public class Solution1197 {
//    int[][] directions = new int[][]{{1, 2}, {2, 1}};


    int[][] directions = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};


    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        Set<String>  map   = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        map.add("0#0");

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == x && curr[1] ==y) {
                return curr[2];
            }
            int temp = getDist(x, y, curr[0], curr[1]);
            for (int i = 0; i < directions.length; i++) {
                int    newX = curr[0] + directions[i][0];
                int    newY = curr[1] + directions[i][1];
                String key  = newX + "#" + newY;
                if (map.contains(key)) {
                    continue;
                }
                int distance = getDist(x, y, newX, newY);

                if (distance > temp && distance > 4) {
                    continue;
                }

                queue.add(new int[]{newX, newY, curr[2] + 1});
                map.add(key);

            }
        }

        return -1;
    }


    private int getDist(int x, int y, int currentX, int currentY) {
        return Math.abs(x - currentX) + Math.abs(y - currentY);
    }

    public static void main(String[] args) {
        Solution1197 solution1197 = new Solution1197();
        int          ans          = solution1197.minKnightMoves(130, -86);
        System.out.println(ans);
    }

}
