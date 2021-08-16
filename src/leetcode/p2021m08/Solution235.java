package leetcode.p2021m08;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 11:43 PM
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root.val > min && root.val < max) {
            return root;
        } else if (max < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args){
        Solution235 solution235=new Solution235();

        TreeNode root=TreeNode.ofArray("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p=TreeNode.search(root,9);
        TreeNode q=TreeNode.search(root,7);
        TreeNode node=solution235.lowestCommonAncestor(root,p,q);
        System.out.println(node.val);
    }
}
