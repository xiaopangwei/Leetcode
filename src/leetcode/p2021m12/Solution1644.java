package leetcode.p2021m12;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/29
 * @time 8:52 PM
 */
public class Solution1644 {
    private boolean isExist(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        } else {
            return isExist(root.left, p) || isExist(root.right, p);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!isExist(root, p) || !isExist(root, q)) {
            return null;
        }
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left  = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (right == null) {
            return left;
        } else {
            return right;
        }

    }
}
