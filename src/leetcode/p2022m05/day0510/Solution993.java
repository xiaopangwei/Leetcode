package leetcode.p2022m05.day0510;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 8:25 PM
 */
public class Solution993 {
    TreeNode parentX = null;
    TreeNode parentY = null;
    int      depthX  = -1;
    int      depthY  = -1;

    int x;
    int y;

    public boolean isCousins(TreeNode root, int x, int y) {

        this.x = x;
        this.y = y;
        dfs(root, null, 0);
        if (parentX != parentY && depthX == depthY) {
            return true;
        }
        return false;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            parentX = parent;
            depthX = depth;
        }
        if (root.val == y) {
            parentY = parent;
            depthY = depth;
        }
        dfs(root.left, root, depth + 1);
        dfs(root.right, root, depth + 1);
    }
}
