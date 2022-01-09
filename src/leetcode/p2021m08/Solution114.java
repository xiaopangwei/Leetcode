package leetcode.p2021m08;

import common.TreeNode;

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

        TreeNode left  = root.left;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(root.right);

        root.right = left;
        root.left = null;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;


    }

    public static void main(String[] args) {

        Solution114 solution114 = new Solution114();
        TreeNode    root        = TreeNode.ofArray("[1,2,5,3,4,null,6]");
        solution114.flatten(root);
        System.out.println(root);
    }
}
