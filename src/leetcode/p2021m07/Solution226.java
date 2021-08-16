package leetcode.p2021m07;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 11:00 AM
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {

        if(root==null){
            return null;
        }

        TreeNode right=invertTree(root.left);
        TreeNode left=invertTree(root.right);

        root.left=left;
        root.right=right;

        return root;
    }

    public static void main(String[] args){
        Solution226 solution226=new Solution226();
        TreeNode root=TreeNode.ofArray("[4,2,7,1,3,6,9]");

        TreeNode newRoot=solution226.invertTree(root);
        System.out.println(newRoot);
    }
}
