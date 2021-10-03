package leetcode.p2021m10;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 9:34 AM
 */
public class Solution772 {
    public int calculate(String s) {
        s=s+"+0";
        int              i        = 0;
        Stack<Integer>   numStack = new Stack<>();
        Stack<Character> oprStack = new Stack<>();
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {

                int j    = i;
                int temp = 0;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    temp = temp * 10 + s.charAt(j) - '0';
                    j++;
                }
                numStack.push(temp);
                i = j;

            } else if (ch == '(') {

                oprStack.push(ch);
                i++;


            } else if (ch == ')') {

                while (!oprStack.isEmpty() && oprStack.peek() != '(') {
                    char opr    = oprStack.pop();
                    int  right  = numStack.pop();
                    int  left   = numStack.pop();
                    int  result = getResult(opr, left, right);
                    numStack.push(result);
                }

                oprStack.pop();
                i++;
            } else {

                while (!oprStack.isEmpty() && getPriority(oprStack.peek()) >= getPriority(ch)) {
                    char op     = oprStack.pop();
                    int  right  = numStack.pop();
                    int  left   = numStack.pop();
                    int  result = getResult(op, left, right);
                    numStack.push(result);
                }
                oprStack.push(ch);
                i++;
            }

        }




        LinkedList<Integer>   list1 = new LinkedList<>();
        LinkedList<Character> list2 = new LinkedList<>();
        while (!oprStack.isEmpty()) {
            list2.addFirst(oprStack.pop());
        }
        while (!numStack.isEmpty()) {
            list1.addFirst(numStack.pop());
        }

        while (!list2.isEmpty()) {
            char op     = list2.removeFirst();
            int  left   = list1.removeFirst();
            int  right  = list1.removeFirst();
            int  result = getResult(op, left, right);
//            System.out.println(result);
            list1.addFirst(result);
        }

        return list1.pop();
    }

    private int getResult(char ch, int a, int b) {
        switch (ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return -1;
    }

    private int getPriority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        Solution772 solution772 = new Solution772();
        int         ans         = solution772.calculate("10/2/5");
        System.out.println(ans);

    }
}
