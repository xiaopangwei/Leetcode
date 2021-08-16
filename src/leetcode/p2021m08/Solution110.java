package leetcode.p2021m08;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 1:52 PM
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepth(root) >= 0;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight  = getDepth(root.left);
        int rightHeight = getDepth(root.right);
        if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
