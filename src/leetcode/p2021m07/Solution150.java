package leetcode.p2021m07;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 10:26 PM
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {

        int          i       = 0;
        Stack<Integer> stack=new Stack<>();
        List<String> oprList = Arrays.asList("+", "-", "*", "/");
        while (i < tokens.length) {
            if (oprList.contains(tokens[i])) {
                int b=stack.pop();
                int a=stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                    default:
                        break;
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }

        return stack.peek();

    }

    public static void main(String[] args){
        Solution150 solution150=new Solution150();
        int ans=solution150.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(ans);
    }
}
