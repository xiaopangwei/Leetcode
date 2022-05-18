package leetcode.p2022m05.day0516;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/16
 * @time 8:54 PM
 */
public class Solution333 {
    int maxVal = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return maxVal;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            maxVal = Math.max(maxVal, getSubNodes(root));
        }

        dfs(root.left);
        dfs(root.right);
    }

    private boolean isBST(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }

        if (left <= root.val && root.val <= right) {
            return isBST(root.left, left, root.val) && isBST(root.right, root.val, right);
        } else {
            return false;
        }
    }


    private int getSubNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSubNodes(root.left) + getSubNodes(root.right) + 1;
    }


}
