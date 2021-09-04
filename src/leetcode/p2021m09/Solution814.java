package leetcode.p2021m09;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/2
 * @time 3:50 PM
 */
public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {

        return dfs(root, null);
    }


    private TreeNode dfs(TreeNode root, TreeNode parent) {

        if (root == null) {
            return null;
        }


        root.left = dfs(root.left, root);
        root.right = dfs(root.right, root);

        if (root.val == 0 && root.left == null && root.right == null) {
           return null;
        }
        return root;
    }


    public static void main(String[] args) {
        Solution814 solution814 = new Solution814();
        //"[1,1,0,1,1,0,1,0]"
        TreeNode root = TreeNode.ofArray("[1,0,1,0,0,0,1]");
        TreeNode node = solution814.pruneTree(root);

        System.out.println(node);
    }


}
