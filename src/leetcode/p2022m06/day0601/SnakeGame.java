package leetcode.p2022m06.day0601;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 10:47 PM
 */
public class SnakeGame {
    int     w;
    int     h;
    int[][] food;

    int n;


    LinkedList<int[]> position = new LinkedList<>();

    int index = 0;

    public SnakeGame(int width, int height, int[][] food) {
        this.w = width;
        this.h = height;
        this.food = food;
        this.n = food.length;
        position.addLast(new int[]{0, 0});
    }

    public int move(String direction) {
        int[] temp = position.peekFirst();
        int   x    = temp[0];
        int   y    = temp[1];
        switch (direction) {
            case "R":
                y++;
                break;
            case "D":
                x++;
                break;
            case "U":
                x--;
                break;
            case "L":
                y--;
                break;
        }

        if (x < 0 || y < 0 || x >= h || y >= w) {
            return -1;
        }
        int[]   last = position.pollLast();
        boolean flag = false;
        for (int[] item : position) {
            if (item[0] == x && item[1] == y) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return -1;
        }

        position.addLast(last);

        if (index < food.length && food[index][0] == x && food[index][1] == y) {
            position.addFirst(new int[]{x, y});
            index++;
        } else {
            position.addFirst(new int[]{x, y});
            position.removeLast();
        }

        return position.size() - 1;
    }

    public static void main(String[] args) {
//        ["SnakeGame", "move", "move", "move", "move", "move", "move"]
//[[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
//        输出：
//[null, 0, 0, 1, 1, 2, -1]
        SnakeGame snakeGame = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("U"));


    }
}
