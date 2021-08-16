package leetcode.p2021m07;

import example.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 10:33 PM
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {

      return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root,long minVal,long maxVal){

        if (root==null){
            return true;
        }

//        System.out.println(root.val+" minVal:"+minVal+" maxVal:"+maxVal);
        if (root.val<=minVal || root.val>=maxVal){
            return false;
        }


        return dfs(root.left,minVal,root.val) && dfs(root.right,root.val,maxVal);
    }
    public static void main(String[] args){
        Solution98 solution98=new Solution98();

        boolean ans=solution98.isValidBST(TreeNode.ofArray("[2147483647]"));
        System.out.println(ans);
    }
}
