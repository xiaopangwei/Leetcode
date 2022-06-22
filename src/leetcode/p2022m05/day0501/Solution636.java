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
        Stack<int[]> threadIdStack = new Stack<>();
        int[]        ans           = new int[n];

        for (String log : logs) {
            String[] array  = log.split(":");
            int      thread = Integer.parseInt(array[0]);
            int      time   = Integer.parseInt(array[2]);
            String   flag   = array[1];
            if ("start".equals(flag)) {
                threadIdStack.push(new int[]{thread, time});
            } else {
                int[] t   = threadIdStack.pop();
                int   len = time - t[1] + 1;
                ans[t[0]] += len;
                if (!threadIdStack.isEmpty()) {
                    ans[threadIdStack.peek()[0]] -= len;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution636 solution636 = new Solution636();
        int[]       ans         = solution636.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
        System.out.println(Arrays.toString(ans));
    }
}
