package leetcode.p2021m07.p20210701;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/2
 * @time 10:38 PM
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] T) {


        Stack<Integer> stack=new Stack<>();
        //top : 大
        //buttom :小
        int newLength=T.length;
        int[] res=new int[newLength];
        int[] newArray=new int[newLength];
        System.arraycopy(T,0,newArray,0,T.length);
        stack.push(0);
        for (int i=1;i<newLength;i++){
            while (!stack.isEmpty() && newArray[i]>newArray[stack.peek()]){
                int index=stack.pop();
                res[index]=i-index;
            }
            //newArray[i]<newArray[stack.peek()]
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args){
        Solution739 solution739=new Solution739();
        int[] res=solution739.dailyTemperatures(new int[]{73, 73,74});
        System.out.println(Arrays.toString(res));
    }
}
