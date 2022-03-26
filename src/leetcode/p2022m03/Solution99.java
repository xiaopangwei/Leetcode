package leetcode.p2022m03;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/2
 * @time 10:35 PM
 */
public class Solution99 {
    TreeNode first  = null;
    TreeNode second = null;

    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        System.out.println(first.val+" "+second.val);
        if (first != null && second != null) {
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            first = root;
            if (second == null) {
                second = prev;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        Solution99 solution99 = new Solution99();
        //3 2 1
        TreeNode root = TreeNodeBuilder.build("[7,2,6,1,3,5,4]");
        solution99.recoverTree(root);

//        System.out.println(root);

    }
}
