package common;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/21
 * @time 4:19 PM
 */
public class StackTest {
    public static void main(String[] args){
        Stack stack =new Stack();
        stack.push(11);
        stack.push(22);

        System.out.println(stack.get(0));
        System.out.println(stack.get(1));

    }
}
