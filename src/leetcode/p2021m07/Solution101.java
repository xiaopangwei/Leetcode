package leetcode.p2021m07;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 11:06 AM
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {

        if (root==null){
            return true;
        }

        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode lTree,TreeNode rTree) {
        if (lTree == null && rTree != null) {
            return false;
        }

        if (lTree != null && rTree == null) {
            return false;
        }

        if (lTree == null && rTree == null) {
            return true;
        }
        if (lTree.val != rTree.val) {
            return false;
        }
        return dfs(lTree.right, rTree.left) && dfs(lTree.left, rTree.right);
    }

    public static void main(String[] args){
        Solution101 solution101=new Solution101();
        boolean ans=solution101.isSymmetric(TreeNode.ofArray("[1,2,2,null,3,null,3]"));
        System.out.println(ans);
    }

}
