package leetcode.springfestival.pm20220204;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 4:05 PM
 */
public class Solution617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }
        TreeNode left  = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);

        int newVal = root1.val + root2.val;
        root1.val = newVal;
        root1.left = left;
        root1.right = right;

        return root1;
    }
}
