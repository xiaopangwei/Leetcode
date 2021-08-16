package leetcode.p2021m08;

import example.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 3:58 PM
 */
public class Solution543 {
    private int maxVal = -1;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return maxVal;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left  = dfs(root.left);
        int right = dfs(root.right);
        maxVal = Math.max(maxVal, left + right + 1);
        int temp = Math.max(left, right) + 1;

        return temp;
    }

}
