package leetcode.p2021m09;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/15
 * @time 9:31 AM
 */
public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution701 solution701 = new Solution701();
        TreeNode    root        = TreeNode.ofArray("[4,2,7,1,3]");
        TreeNode    newRoot     = solution701.insertIntoBST(root, 5);
        System.out.println(newRoot);
    }
}
