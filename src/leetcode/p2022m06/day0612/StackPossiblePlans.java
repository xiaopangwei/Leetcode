package leetcode.p2022m06.day0612;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/19
 * @time 6:43 PM
 */
public class StackPossiblePlans {
    List<List<Integer>> ans = new ArrayList<>();

    public void plans(int[] nums, List<Integer> out, int index, Stack<Integer> stack) {
        if (index == nums.length) {
            List<Integer> res = new ArrayList<>();
            res.addAll(out);
            for (int i = stack.size() - 1; i >= 0; i--) {
                res.add(stack.get(i));
            }
            ans.add(res);
            return;
        }
        //加入栈中
        stack.push(nums[index]);
        plans(nums, out, index + 1, stack);
        stack.pop();
        //从栈弹出一个元素
        if (!stack.isEmpty()) {
            int t = stack.pop();
            out.add(t);
            plans(nums, out, index, stack);
            out.remove(out.size() - 1);
            stack.push(t);
        }
    }


    //m 准备入栈的 5
    //n 已经入栈的 0
    public int plans(int m, int n) {
        if (m == 0) {
            return 1;
        }
        if (n == 0) {

            return plans(m - 1, n + 1);
        } else {
            return plans(m - 1, n + 1) + plans(m, n - 1);
        }
    }


    public static void main(String[] args) {
        StackPossiblePlans stackPossiblePlans = new StackPossiblePlans();
        stackPossiblePlans.plans(new int[]{1, 2, 3}, new ArrayList<>(), 0, new Stack<>());
        // 5 4 3 2 1
        System.out.println(stackPossiblePlans.ans);
        System.out.println(stackPossiblePlans.ans.size());

        int ans=stackPossiblePlans.plans(5,0);
        System.out.println("ans"+ans);
    }
}
