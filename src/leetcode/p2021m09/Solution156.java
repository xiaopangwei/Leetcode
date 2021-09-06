package leetcode.p2021m09;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/4
 * @time 10:42 AM
 */
public class Solution156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }


        TreeNode newNode = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;


        return newNode;


    }

    public static void main(String[] args) {
        TreeNode    root        = TreeNode.ofArray("[1,2,3,4,5]");
        Solution156 solution156 = new Solution156();
        TreeNode    node        = solution156.upsideDownBinaryTree(root);

        System.out.println(node);
    }
}
