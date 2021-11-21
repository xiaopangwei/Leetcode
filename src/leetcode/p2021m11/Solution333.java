package leetcode.p2021m11;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/20
 * @time 10:54 AM
 */
public class Solution333 {
    int maxVal = 0;

    public int largestBSTSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        dfs(root);


        return maxVal;


    }


    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            maxVal = Math.max(getSubNodes(root), maxVal);
        }
        dfs(root.left);
        dfs(root.right);
    }


    private int getSubNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return getSubNodes(node.left) + getSubNodes(node.right) + 1;
    }


    private boolean isBST(TreeNode root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        }
        if (root.val > lowerBound && root.val < upperBound) {

            return isBST(root.left, lowerBound, root.val) && isBST(root.right, root.val, upperBound);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution333 solution333 = new Solution333();
        TreeNode    root        = TreeNode.ofArray("[4,2,7,2,3,5,null,2,null,null,null,null,null,1]");
        int         cnt         = solution333.largestBSTSubtree(root);
        System.out.println(cnt);
    }
}
