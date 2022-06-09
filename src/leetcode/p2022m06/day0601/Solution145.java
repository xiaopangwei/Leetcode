package leetcode.p2022m06.day0601;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 11:43 PM
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        List<Integer> ans = new ArrayList<>();

        while (p != null || !stack.isEmpty()) {


            while (p != null) {
                ans.add(p.val);
                System.out.println(ans);
                stack.push(p);
                p = p.right;
            }

            TreeNode t = stack.pop();
            p = t.left;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution145   solution145 = new Solution145();
        List<Integer> ans         = solution145.postorderTraversal(TreeNodeBuilder.build("[1,2,3]"));
        System.out.println(ans);
    }
}
