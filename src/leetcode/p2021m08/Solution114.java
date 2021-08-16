package leetcode.p2021m08;

import example.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 3:04 PM
 */
public class Solution114 {
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.println(root.val);
        TreeNode lTree = root.left;
        flatten(root.left);


        TreeNode p = lTree;
        while (p != null && p.right != null) {
            p = p.right;
        }

        TreeNode rTree = root.right;
        flatten(root.right);


        root.left = null;
        if (lTree != null) {
            root.right = lTree;
        } else {
            root.right = rTree;
        }

        if (lTree != null && p != null) {
            p.right = rTree;
        }

    }

    public static void main(String[] args) {

        Solution114 solution114 = new Solution114();
        TreeNode    root        = TreeNode.ofArray("[0]");
        solution114.flatten(null);
        System.out.println(root);
    }
}
