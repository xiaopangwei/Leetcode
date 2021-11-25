package leetcode.p2021m11;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/23
 * @time 10:13 PM
 */
public class Solution545 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }

        ans.add(root.val);
        getLeft(root.left);

        walkLeaveNode(root);
        getRight(root.right);



        return ans;

    }

    private void walkLeaveNode(TreeNode root) {


        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return;
        }


        walkLeaveNode(root.left);

        walkLeaveNode(root.right);

    }


    private void getLeft(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        ans.add(root.val);
        if (root.left != null) {
            getLeft(root.left);
        } else {
            getLeft(root.right);
        }
    }

    private void getRight(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            getLeft(root.right);
        } else {
            getLeft(root.left);
        }
        ans.add(root.val);
    }

    public static void main(String[] args) {
        Solution545   solution545 = new Solution545();
        TreeNode      root        = TreeNode.ofArray("[1,null,2,3,4]");
        List<Integer> ans         = solution545.boundaryOfBinaryTree(root);
        System.out.println(ans);
    }
}
