package leetcode.p2022m05.day0501;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 4:38 PM
 */
public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> threadIdStack = new Stack<>();
        int            prev          = 0;
        int[]          ans           = new int[n];
        for (String item : logs) {
            String[] array    = item.split(":");
            int      threadId = Integer.parseInt(array[0]);
            String   flag     = array[1];
            int      curr     = Integer.parseInt(array[2]);

            if ("start".equalsIgnoreCase(flag)) {
                if (!threadIdStack.isEmpty()) {
                    ans[threadIdStack.peek()] += (curr - prev);
                }
                prev = curr;
                threadIdStack.push(threadId);
            } else {
                ans[threadIdStack.pop()] += (curr - prev + 1);
                prev = curr + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Solution636 solution636=new Solution636();
        int[] ans=solution636.exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
        System.out.println(Arrays.toString(ans));
    }
}
