package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/29
 * @time 10:18 PM
 */
public class SnakeGame {

    LinkedList<int[]> body = new LinkedList<>();
    int w;
    int h;
    List<int[]> foods = new ArrayList<>();

    int foodIndex = 0;


    public SnakeGame(int width, int height, int[][] food) {
        this.w = width;
        this.h = height;
        for (int[] f : food) {
            foods.add(f);
        }
        body.addFirst(new int[]{0, 0});
    }

    public int move(String direction) {
        int[] headPos = body.peekFirst();
        int   x       = headPos[0];
        int   y       = headPos[1];
        if ("U".equals(direction)) {
            x--;
        } else if ("D".equals(direction)) {
            x++;
        } else if ("L".equals(direction)) {
            y--;
        } else {
            y++;
        }

        if (!isValid(x, y) || eatSelf(x, y)) {
            return -1;
        }


        if (foodIndex < foods.size() && foods.get(foodIndex)[0] == x &&
                foods.get(foodIndex)[1] == y) {
            foodIndex++;
            body.addFirst(new int[]{x, y});
        } else {
            body.removeLast();
            body.addFirst(new int[]{x, y});
        }


        return body.size() - 1;

    }

    private boolean eatSelf(int x, int y) {
        int[]   temp = body.pollLast();
        boolean flag = false;
        for (int[] t : body) {
            if (x == t[0] && y == t[1]) {
                flag = true;
                break;
            }
        }
        body.addLast(temp);
        return flag;
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= this.h || y >= this.w) {
//            System.out.println(x+" "+y+" not ok!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
        System.out.println(snakeGame.move("R")); // 返回 0
        System.out.println(snakeGame.move("D")); // 返回 0
        System.out.println(snakeGame.move("R")); // 返回 1 ，蛇吃掉了第一个食物，同时第二个食物出现在 (0, 1)
        System.out.println(snakeGame.move("U")); // 返回 1
        System.out.println(snakeGame.move("L")); // 返回 2 ，蛇吃掉了第二个食物，没有出现更多食物
        System.out.println(snakeGame.move("U")); // 返回 -1 ，蛇与边界相撞，游戏结束
    }
}
