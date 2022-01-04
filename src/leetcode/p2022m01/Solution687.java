package leetcode.p2022m01;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/2
 * @time 7:18 PM
 */
public class Solution687 {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getLongestPath(root);
        return ans;
    }

    private int getLongestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left  = getLongestPath(root.left);
        int right = getLongestPath(root.right);

        int t1 = 0;
        int t2 = 0;
        if (root.left != null && root.left.val == root.val) {
            t1 = left + 1;
        }

        if (root.right != null && root.right.val == root.val) {

            t2 = right + 1;
        }
        ans = Math.max(ans, t1 + t2);
        return Math.max(t1, t2);
    }
}
