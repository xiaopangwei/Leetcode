package leetcode.p2022m06.day0601;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/2
 * @time 11:16 PM
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode left    = root.left;
            TreeNode newNode = root.right;
            TreeNode p       = root.right;
            while (p.left != null) {
                p = p.left;
            }
            p.left = left;
            return newNode;
        }
    }

    public static void main(String[] args) {
        Solution450 solution450 = new Solution450();
        TreeNode    root        = TreeNodeBuilder.build("[5,3,6,2,4,null,7]");
        TreeNode    newRoot     = solution450.deleteNode(root, 5);
        System.out.println(newRoot);
    }
}
