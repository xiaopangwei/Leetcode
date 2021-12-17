package leetcode.p2021m12;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/14
 * @time 8:58 PM
 */
public class Solution111 {

    private int minVal = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return minVal;
    }

    private void dfs(TreeNode root, int depth) {
        if (minVal <= depth) {
            return;
        }
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            minVal = Math.min(minVal, depth);
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
