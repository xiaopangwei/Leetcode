package leetcode;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/16
 * @time 10:11 PM
 */
public class Solution298 {
    int maxValue = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int temp1 = dfs(root.left) + 1;
        int temp2 = dfs(root.right) + 1;
        if (root.left != null && root.val + 1 != root.left.val) {
            temp1 = 1;
        }


        if (root.right != null && root.val + 1 != root.right.val) {
            temp2 = 1;
        }
        int t = Math.max(temp1, temp2);
        maxValue = Math.max(maxValue, t);
//        System.out.println(root.val + " ==> " + t);
        return t;
    }

    public static void main(String[] args) {
        Solution298 solution298 = new Solution298();
        TreeNode    node1       = new TreeNode(1);
        TreeNode    node2       = new TreeNode(2);
        TreeNode    node3       = new TreeNode(3);
        TreeNode    node4       = new TreeNode(2);
//        TreeNode    node5       = new TreeNode(5);
        node2.right = node3;
        node3.left = node4;
        node4.left = node1;

        TreeNode root = node2;
        int      ans  = solution298.longestConsecutive(root);
        System.out.println(ans);
    }
}
