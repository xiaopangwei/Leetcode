package leetcode.p2021m08;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/14
 * @time 1:51 PM
 */
public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

//        String a = (root == null ? "NULL" : String.valueOf(root.val));
//        String b = (subRoot == null ? "NULL" : String.valueOf(subRoot.val));
//        System.out.println(a + " " + b);
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null && subRoot != null) {
            return false;
        } else if (root != null && subRoot == null) {
            return true;
        }

        if (root.val == subRoot.val) {
            boolean flag = isSame(root, subRoot);
            if (flag) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);


    }


    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null && subRoot != null) {
            return false;
        } else if (root != null && subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        } else {
            return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
        }

    }


    public static void main(String[] args) {
        Solution572 solution572 = new Solution572();
        TreeNode    root        = TreeNode.ofArray("[3,4,5,1,2]");
        TreeNode    subTree     = TreeNode.ofArray("[4,1,2]");
        boolean     flag        = solution572.isSubtree(root, subTree);
        System.out.println(flag);
    }
}
