package leetcode.p2022m06.day0601;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 9:40 PM
 */
public class Solution772 {
    public int calculate(String s) {
        Stack<Character> oprStack = new Stack<>();
        Stack<Integer>   numStack = new Stack<>();
        int              n        = s.length();
        int              i        = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                int j   = i;
                int num = 0;
                while (j < n && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                numStack.push(num);
                i = j;
            } else if (s.charAt(i) == '(') {
                oprStack.push('(');
                i++;
            } else if (s.charAt(i) == ')') {
                while (!oprStack.isEmpty() && oprStack.peek() != '(') {
                    char sign  = oprStack.pop();
                    int  right = numStack.pop();
                    int  left  = numStack.pop();
                    int  res   = calc(left, right, sign);
                    numStack.push(res);
                }
                oprStack.pop();
                i++;
            } else {
                while (!oprStack.isEmpty() && getPriority(oprStack.peek()) >= getPriority(s.charAt(i))) {
                    char sign  = oprStack.pop();
                    int  right = numStack.pop();
                    int  left  = numStack.pop();
                    int  res   = calc(left, right, sign);
                    numStack.push(res);
                }
                oprStack.push(s.charAt(i));
                i++;
            }

        }

        while (!oprStack.isEmpty()) {
            char sign  = oprStack.pop();
            int  right = numStack.pop();
            int  left  = numStack.pop();
            int  res   = calc(left, right, sign);
            numStack.push(res);
        }

        return numStack.pop();

    }

    public int calc(int left, int right, char sign) {
        switch (sign) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
        }
        return -1;
    }


    private int getPriority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args){
        Solution772 solution772=new Solution772();
        int ans=solution772.calculate("0");
        System.out.println(ans);
    }
}
