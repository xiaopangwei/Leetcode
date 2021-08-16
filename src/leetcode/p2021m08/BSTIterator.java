package leetcode.p2021m08;

import common.TreeNode;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 3:18 PM
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public int next() {
        TreeNode node  = stack.pop();
        int      ans   = node.val;
        TreeNode right = node.right;
        TreeNode p     = right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return ans;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
