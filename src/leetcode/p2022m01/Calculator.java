package leetcode.p2022m01;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/16
 * @time 7:59 PM
 */
public class Calculator {

    public int calculate(String expr) {
        char[]           array    = expr.toCharArray();
        int              i        = 0;

        Stack<Character> oprStack = new Stack<>();
        Stack<Integer>   numStack = new Stack<>();
        numStack.push(0);
        while (i < array.length) {

            char ch = array[i];
            if (ch == ' ') {
                i++;
                continue;
            }
            if (ch == '(') {
                oprStack.push(ch);
                i++;
            } else if (ch == ')') {
                while (!oprStack.isEmpty() && oprStack.peek() != '(') {
                    tidy(numStack, oprStack);
                }
                oprStack.pop();
                i++;
            } else if (ch >= '0' && ch <= '9') {
                int temp = 0;
                int j    = i;
                while (j < array.length) {
                    if (array[j] == ' ') {
                        j++;
                        continue;
                    }
                    if (array[j] >= '0' && array[j] <= '9') {
                        temp = temp * 10 + (array[j] - '0');
                    } else {
                        break;
                    }
                    j++;
                }
                numStack.push(temp);
                i = j;
            } else {
                //+ - * //
                //3*2+1
                if (ch == '+' || ch == '-') {
                    if (i > 0 && (array[i - 1] == '(' || array[i - 1] == '+' || array[i - 1] == '-')) {
                        numStack.push(0);
                    }
                }

                while (!oprStack.isEmpty() && getPriority(oprStack.peek()) >= getPriority(ch)) {
                    tidy(numStack, oprStack);
                }
                oprStack.push(ch);
                i++;

            }

        }

        while (!oprStack.isEmpty()) {
            tidy(numStack, oprStack);
        }

        return numStack.pop();
    }

    private void tidy(Stack<Integer> numStack, Stack<Character> oprStack) {
        char opr   = oprStack.pop();
        int  right = numStack.pop();

        int left = numStack.pop();

        int res = getResult(left, opr, right);
        numStack.push(res);
    }

    private int getPriority(char ch) {
        if (ch == '+' || ch == '-') {
            return 0;
        } else if (ch == '*' || ch == '/') {
            return 1;
        } else {
            return -1;
        }
    }

    private int getResult(int left, char ch, int right) {
        if (ch == '+') {
            return left + right;
        } else if (ch == '-') {
            return left - right;
        } else if (ch == '/') {
            return left / right;
        } else {
            return left * right;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int        ans        = calculator.calculate("-2+1");
        System.out.println(ans);
    }
}
