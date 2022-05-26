package leetcode.p2022m05.day0512;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 9:05 PM
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {

            while (true) {
                if (stack.isEmpty() || (stack.peek() * asteroids[i] > 0) || (stack.peek() < 0 && asteroids[i] > 0)) {
                    stack.push(asteroids[i]);
                    break;
                }
                if (stack.peek() > 0 && asteroids[i] < 0) {
                    int v1 = stack.peek();
                    int v2 = Math.abs(asteroids[i]);
                    if (v1 == v2) {
                        stack.pop();
                        break;
                    } else if (v1 < v2) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }

        }
        int size = stack.size();
        if (size == 0) {
            return new int[0];
        }

        int[] ans   = new int[size];
        int   index = size - 1;
        while (index >= 0)

        {
            ans[index--] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution735 solution735 = new Solution735();
        int[]       ans         = solution735.asteroidCollision(new int[]{5, 10, -5});
        System.out.println(Arrays.toString(ans));

//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(20);
//        stack.push(23);
//        System.out.println(stack.get(0));
    }
}
