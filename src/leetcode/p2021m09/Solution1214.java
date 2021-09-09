package leetcode.p2021m09;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/7
 * @time 3:44 PM
 */
public class Solution1214 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        return dfs(root1, target, root2);

    }

    private boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        } else if (root.val < target) {
            return search(root.right, target);
        } else {
            return search(root.left, target);
        }
    }

    private boolean dfs(TreeNode root1, int target, TreeNode root2) {

        if (root1 == null) {
            return false;
        }

        int temp = target - root1.val;

        boolean flag = search(root2, temp);
        if (flag) {
            return true;
        }

        if (dfs(root1.left, target, root2) || dfs(root1.right, target, root2)) {
            return true;
        }
        return false;
    }
}
