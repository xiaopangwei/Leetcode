package leetcode.p2021m07;

import example.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 4:48 PM
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root==p || root==q){
            return root;
        }
        TreeNode node1=lowestCommonAncestor(root.left,p,q);
        TreeNode node2=lowestCommonAncestor(root.right,p,q);

        if (node1!=null && node2!=null){
            return root;
        }
        else if (node1!=null){
            return node1;
        }else if (node2!=null){
            return node2;
        }else{
            return null;
        }
    }

    public static void main(String[] args){
        Solution236 solution236=new Solution236();
        TreeNode treeNode=TreeNode.ofArray("[1,2]");
        TreeNode p=TreeNode.search(treeNode,1);
        TreeNode q=TreeNode.search(treeNode,2);
        System.out.println(solution236.lowestCommonAncestor(treeNode,p,q).val);
    }



}
