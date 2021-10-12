package leetcode.p2021m10;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/8
 * @time 7:46 PM
 */
public class Solution490 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        Set<String>   visited = new HashSet<>();
        Queue<String> queue   = new LinkedList<>();
        String        begin   = start[0] + "#" + start[1];
        queue.add(begin);
        visited.add(begin);

        while (!queue.isEmpty()) {

            String[] prev = queue.poll().split("#");
            int      x    = Integer.parseInt(prev[0]);
            int      y    = Integer.parseInt(prev[1]);

            List<int[]> candidates = getCandidates(maze, new int[]{x, y}, visited);
            for (int[] next : candidates) {
                if (next[0] == destination[0] && next[1] == destination[1]) {
                    return true;
                }

                String coodinate = next[0] + "#" + next[1];
//                System.out.println((x + "#" + y) + " " + coodinate);
                queue.add(coodinate);
                visited.add(coodinate);
            }

        }

        return false;


    }

    private List<int[]> getCandidates(int[][] maze, int[] current, Set<String> visited) {

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < directions.length; i++) {
            int x = current[0];
            int y = current[1];
            boolean flag=false;
            while (isValid(x + directions[i][0],
                    y + directions[i][1], maze) &&
                    maze[x + directions[i][0]][y + directions[i][1]] == 0) {
                x += directions[i][0];
                y += directions[i][1];
                flag=true;
            }
            if (flag) {
                if (isValid(x, y, maze)
                        && !visited.contains(x + "#" + y)) {
                    res.add(new int[]{x,y});
                }
            }

        }
        return res;
    }

    private boolean isValid(int x, int y, int[][] maze) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution490 solution490 = new Solution490();
        int[][]     array       = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};

        boolean ans = solution490.hasPath(array, new int[]{0, 4}, new int[]{2, 3});
        System.out.println(ans);
    }
}
