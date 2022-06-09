package leetcode.p2022m06.day0601;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 10:21 PM
 */
public class Solution114 {

    TreeNode head = null;
    TreeNode last = null;

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode lTree = root.left;
        TreeNode rTree = root.right;

        if (head == null) {
            head = root;
            head.left = null;
        } else {
            root.left = null;
            last.right = root;
        }
        last = root;
        dfs(lTree);
        dfs(rTree);
    }

    public static void main(String[] args) {
        Solution114 solution114 = new Solution114();
        TreeNode    root        = TreeNode.ofArray("[1,2,5,3,4,null,6]");
        solution114.flatten(root);
        System.out.println(root);
    }
}
