package leetcode.p2021m09;

import common.TreeNode;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 2:40 PM
 */
public class Solution549 {


    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        int t1  = getMaxLength(root);
        int t2  = longestConsecutive(root.left);
        int t3  = longestConsecutive(root.right);

        ans = Math.max(t1, ans);
        ans = Math.max(t2, ans);
        ans = Math.max(t3, ans);
        return ans;
    }

    private int getMaxLength(TreeNode root) {
        return postOrderDesc(root) + postOrderAsc(root) - 1;
    }

    private int postOrderAsc(TreeNode root) {
        //左小右大
        if (root == null) {
            return 0;
        }

        int t1 = 0;
        if (root.left != null && root.left.val == root.val + 1) {
            t1 = postOrderAsc(root.left);
        }

        int t2 = 0;
        if (root.right != null && root.right.val == root.val + 1) {
            t2 = postOrderAsc(root.right);
        }

        return Math.max(t1, t2) + 1;

    }


    private int postOrderDesc(TreeNode root) {
        //左大右小
        if (root == null) {
            return 0;
        }

        int t1 = 0;
        if (root.left != null && root.left.val == root.val - 1) {
            t1 = postOrderDesc(root.left);
        }

        int t2 = 0;
        if (root.right != null && root.right.val == root.val - 1) {
            t2 = postOrderDesc(root.right);
        }

        return Math.max(t1, t2) + 1;

    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node3.left = node1;
        node1.right = node2;

        Solution549 solution549 = new Solution549();
        int         ans         = solution549.longestConsecutive(node3);
        System.out.println(ans);

    }
}
