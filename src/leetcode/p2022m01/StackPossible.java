package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/22
 * @time 2:46 PM
 */
public class StackPossible {
    public void getPossiblePlans(int[] nums, int index, Stack<Integer> stack, List<Integer> ans) {
        if (index == nums.length || ans.size() + stack.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(ans);
            for (int i = stack.size() - 1; i >= 0; i--) {
                temp.add(stack.get(i));
            }
            System.out.println(temp);
            return;
        }
        stack.push(nums[index]);
        getPossiblePlans(nums, index + 1, stack, ans);
        stack.pop();

        if (!stack.isEmpty()) {
            int t = stack.pop();
            ans.add(t);
            getPossiblePlans(nums, index, stack, ans);
            ans.remove(ans.size() - 1);
            stack.push(t);

        }

    }


    // 首先想到的是用递归实现，一共有三种操作
    // ①栈为空时，必须入栈而不能出栈
    // ②入栈
    // ③出栈 这里要注意的是，当全部元素入栈后，出栈序列其实就已经定了
    public int planCount(int m, int n) {
        //准备入栈的个数
        if (m == 0) {
            return 1;
        }
        //在栈中的元素
        if (n == 0) {
            return planCount(m - 1, 1);
        }

        return planCount(m - 1, n + 1) + planCount(m, n - 1);
    }

    public static void main(String[] args) {
        StackPossible stackPossible = new StackPossible();
        int ans=stackPossible.planCount(4,0);
        System.out.println(ans);
//        stackPossible.getPossiblePlans(new int[]{1, 2, 3, 4, 5}, 0, new Stack<>(), new ArrayList<>());
    }
}
