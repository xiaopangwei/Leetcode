package leetcode.p2021m08;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/8
 * @time 10:35 PM
 */
public class Solution636 {


    public int[] exclusiveTime(int n, List<String> logs) {

        int            prev  = 0;
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[n];
        for (int i = 0; i < logs.size(); i++) {
            String[] currentLogArray = logs.get(i).split(":");
            int temp = Integer.parseInt(currentLogArray[2]);
            if ("start".equals(currentLogArray[1])) {
                if (!stack.isEmpty()){
                    int idx  = stack.peek();
                    ans[idx] += (temp - prev);
                }
                stack.push(Integer.parseInt(currentLogArray[0]));
                prev = temp;
            } else {
                int length = temp - prev + 1;
                int idx    = stack.pop();
                ans[idx] += length;
                prev = temp + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution636 solution636 = new Solution636();
        int[] ans = solution636.exclusiveTime(2,
                Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"));
        System.out.println(Arrays.toString(ans));
    }
}
