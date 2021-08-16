package leetcode.p2021m08;

import example.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/12
 * @time 1:21 PM
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        return innerDeleteNode(root, key);

    }

    private TreeNode innerDeleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = innerDeleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = innerDeleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {

                TreeNode p        = root.right;
                TreeNode leftmost = null;
                while (p != null) {
                    leftmost = p;
                    p = p.left;
                }
                leftmost.left = root.left;
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution450 solution450 = new Solution450();
        TreeNode    root        = TreeNode.ofArray("[5,3,6,2,4,null,7]");
        TreeNode    newNode     = solution450.deleteNode(root, 100);
        if (newNode == null) {
            System.out.println("NULL");
        } else {
            System.out.println(newNode.val);
        }
    }
}
