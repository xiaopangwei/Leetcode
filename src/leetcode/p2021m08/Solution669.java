package leetcode.p2021m08;

import example.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 11:03 PM
 */
public class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public static void main(String[] args) {
        Solution669 solution669 = new Solution669();
        TreeNode    root        = TreeNode.ofArray("[3,0,4,null,2,null,null,1]");
        TreeNode    node        = solution669.trimBST(root, 1, 3);
        System.out.println(node);
    }
}
