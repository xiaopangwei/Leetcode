package leetcode.p2022m01;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/12
 * @time 8:14 PM
 */
public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for (int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }
        return  stack.isEmpty();
    }

    public static void main(String[] args){
        Solution946 solution946=new Solution946();
        boolean ans=solution946.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
        System.out.println(ans);
    }
}
