package leetcode.p2021m07;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 2:05 PM
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1==null && root2==null){
            return null;
        }

        else if (root1!=null && root2==null){
            return root1;
        }

        else if (root1==null && root2!=null){
           return  root2;
        }

        root1.val=root1.val+root2.val;
        TreeNode left=mergeTrees(root1.left,root2.left);
        TreeNode right=mergeTrees(root1.right,root2.right);

        root1.left=left;
        root1.right=right;

        return root1;
    }

    public static void main(String[] args){
        Solution617 solution617=new Solution617();
        TreeNode root1=TreeNode.ofArray("[1,3,2,5,null,null,null]");
        TreeNode root2=TreeNode.ofArray("[2,1,3,null,4,null,7]");
        TreeNode newRoot=solution617.mergeTrees(root1,root2);
        System.out.println(newRoot);
    }
}
