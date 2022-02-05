package leetcode.springfestival.pm20220203;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 4:15 PM
 */
public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null && subRoot != null) {
            return false;
        }
        return isSameTree(root, subRoot) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        return root != null && subRoot != null && root.val == subRoot.val && isSameTree(root.left, subRoot.left)
                && isSameTree(root.right, subRoot.right);
    }
}
