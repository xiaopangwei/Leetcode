package leetcode.p2021m11;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/13
 * @time 4:52 PM
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {


        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {


            while (true) {
                if (stack.isEmpty()) {
                    stack.push(asteroids[i]);
                    break;
                } else if (stack.peek() * asteroids[i] > 0 || (stack.peek() < 0 && asteroids[i] > 0)) {
                    stack.push(asteroids[i]);
                    break;
                }
                int prev = stack.peek();

                int a = Math.abs(prev);
                int b = Math.abs(asteroids[i]);

                if (a == b) {
                    stack.pop();
                    break;
                }else if (a>b){
                    break;
                }else{
                    stack.pop();
                }
            }


        }

        int   size  = stack.size();
        int[] res   = new int[size];
        int   index = size - 1;


        while (index >= 0) {
            res[index--] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution735 solution735 = new Solution735();
        int[]       ans         = solution735.asteroidCollision(new int[]{-2,-1,1,2});
        System.out.println(Arrays.toString(ans));
    }
}
