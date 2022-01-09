package leetcode.p2022m01;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/6
 * @time 10:23 PM
 */
public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        String[]      array = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            String val = array[i];
            stack.push(val);


            while (stack.size() >= 3 &&
                    stack.get(stack.size() - 1).equals("#") &&
                    stack.get(stack.size() - 2).equals("#") &&
                    !stack.get(stack.size() - 3).equals("#")) {

                stack.pop();
                stack.pop();
                stack.pop();

                stack.push("#");
            }

        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        Solution331 solution331 = new Solution331();
        boolean     ans         = solution331.isValidSerialization("1,#,#,#");
//        Stack<Integer> stack = new Stack<>();

        System.out.println(ans);
    }
}
