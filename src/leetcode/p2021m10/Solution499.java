package leetcode.p2021m10;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/9
 * @time 11:02 AM
 */
public class Solution499 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int[][] distance;

    String[][] path;

    Map<Integer, String> pathLetter = new HashMap<>();


    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        pathLetter.put(0, "u");
        pathLetter.put(1, "d");
        pathLetter.put(2, "r");
        pathLetter.put(3, "l");
        return shortestDistance(maze, ball, hole);
    }


    public String shortestDistance(int[][] maze, int[] start, int[] destination) {
        distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        path = new String[maze.length][maze[0].length];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i], "");
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        distance[start[0]][start[1]] = 0;


        while (!queue.isEmpty()) {

            int[] prev = queue.poll();
            int   x    = prev[0];
            int   y    = prev[1];

            int prevDist = distance[x][y];
            getCandidates(maze, new int[]{x, y}, prevDist, queue, destination);

        }

        int dist = distance[destination[0]][destination[1]];
        return dist == Integer.MAX_VALUE ? "impossible" : path[destination[0]][destination[1]];
    }


    private void getCandidates(int[][] maze, int[] current,
                               int prevStep, Queue<int[]> queue, int[] target) {


        String prevPath = path[current[0]][current[1]];
        for (int i = 0; i < directions.length; i++) {
            int     x    = current[0];
            int     y    = current[1];
            boolean flag = false;
            int     temp = 0;

            String totalPath = prevPath;
            while (isValid(x + directions[i][0],
                    y + directions[i][1], maze) &&
                    maze[x + directions[i][0]][y + directions[i][1]] == 0) {
                x += directions[i][0];
                y += directions[i][1];
                temp++;
                flag = true;
                if (x == target[0] && y == target[1]) {
                    break;
                }
            }
            if (flag) {
                if (isValid(x, y, maze)) {

                    totalPath = totalPath + pathLetter.get(i);
                    int newStep = prevStep + temp;
//                    || (newStep == distance[x][y] && totalPath.compareTo(path[x][y]) < 0)
                    if (newStep < distance[x][y]) {
                        distance[x][y] = newStep;
                        path[x][y] = totalPath;
                        int[] t = new int[]{x, y};
                        System.out.println(x + "," + y + " " + newStep + " " + path[x][y]);
                        queue.add(t);
                    }
                }
            }

        }

    }

    private boolean isValid(int x, int y, int[][] maze) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution499 solution499 = new Solution499();
        int[][] array = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        String ans = solution499.findShortestWay(array, new int[]{4, 3},
                new int[]{0, 1});
        System.out.println(ans);
    }
}
