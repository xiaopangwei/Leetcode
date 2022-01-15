package leetcode.p2022m01;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/13
 * @time 9:13 PM
 */
public class BST {
    public TreeNode insert(TreeNode root, int target) {

        if (root == null) {
            return new TreeNode(target);
        }

        if (root.val > target) {
            root.left = insert(root.left, target);

        }

        if (target > root.val) {
            root.right = insert(root.right, target);

        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeBuilder.build("[5,1,10,null,3,7,null]");
        BST      bst  = new BST();
        TreeNode node = bst.insert(root, 4);
        System.out.println(node);
    }
}
