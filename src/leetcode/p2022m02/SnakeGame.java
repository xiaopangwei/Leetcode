package leetcode.p2022m02;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/21
 * @time 9:33 PM
 */
public class SnakeGame {
    int[][] food;
    int     width;
    int     height;

    int               ans   = 0;
    int               index = 0;
    LinkedList<int[]> body  = new LinkedList<>();

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;

        body = new LinkedList<>();
        body.add(new int[]{0, 0});
    }

    public int move(String direction) {
        int[] temp = body.peekFirst();
        int   x    = temp[0];
        int   y    = temp[1];

        if ("D".equalsIgnoreCase(direction)) {
            x++;
        } else if ("U".equalsIgnoreCase(direction)) {
            x--;
        } else if ("L".equalsIgnoreCase(direction)) {
            y--;
        } else if ("R".equalsIgnoreCase(direction)) {
            y++;
        }

        if (!isValid(x, y) || eatSelf(x, y)) {
            return -1;
        }

        if (index < food.length && x == food[index][0] && y == food[index][1]) {
            body.addFirst(new int[]{x, y});
            ans++;
            index++;
        } else {
            body.removeLast();
            body.addFirst(new int[]{x, y});
        }
        return ans;
    }


    private boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= height || y >= width) {
            return false;
        }
        return true;
    }

    private boolean eatSelf(int x, int y) {
        int[] temp = body.pollLast();
        for (int[] t : body) {
            if (t[0] == x && t[1] == y) {
                return true;
            }
        }
        body.addLast(temp);
        return false;
    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
        snakeGame.move("R"); // 返回 0
        snakeGame.move("D"); // 返回 0
        snakeGame.move("R"); // 返回 1 ，蛇吃掉了第一个食物，同时第二个食物出现在 (0, 1)
        snakeGame.move("U"); // 返回 1
        snakeGame.move("L"); // 返回 2 ，蛇吃掉了第二个食物，没有出现更多食物
        snakeGame.move("U"); // 返回 -1 ，蛇与边界相撞，游戏结束

    }
}
