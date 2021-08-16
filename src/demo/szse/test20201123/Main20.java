package demo.szse.test20201123;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2020/11/23
 * @time 8:07 PM
 */
public class Main20 {
    public static void main(String[] args){
        Main20 main20=new Main20();
        System.out.println(main20.isValid("]"));
    }

    public boolean isValid(String s) {

        Stack<Character> stack=new Stack<>();
        char[] array=s.toCharArray();
        for (char item:array) {
//            System.out.println(item);
            switch (item) {
                case '{':
                case '(':
                case '[':
                    stack.push(item);
                    break;

                case '}':
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (!stack.peek().equals('{')) {
                        return false;
                    }
                    stack.pop();
                    break;

                case ')':
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (!stack.peek().equals('(')) {
                        return false;
                    }
                    stack.pop();
                    break;


                case ']':
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (!stack.peek().equals('[')) {
                        return false;
                    }
                    stack.pop();
                    break;

                default:
                    break;
            }
        }

            if (stack.isEmpty()){
                return true;
            }
            else{
                return false;
            }
        }


}
