package leetcode.p2021m10;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/13
 * @time 7:38 PM
 */
public class Solution489 {

    Set<String> visited = new HashSet<>();
    static final int[][] DIRECTIONS = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public void cleanRoom(Robot robot) {

        dfs(0,0,robot,0);
    }

    private void dfs(int x, int y, Robot robot, int directionIndex) {

        robot.clean();
        visited.add(x + "#" + y);

        for (int i = 0; i < DIRECTIONS.length; i++) {

            int newDirection = (directionIndex + i) % 4;
            int newX         = x + DIRECTIONS[newDirection][0];
            int newY         = y + DIRECTIONS[newDirection][1];

            String coordinate = newX + "#" + newY;




            if (!visited.contains(coordinate) && robot.move()) {
                dfs(newX, newY, robot, newDirection);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            } else {
                robot.turnRight();
            }

        }
    }
}
