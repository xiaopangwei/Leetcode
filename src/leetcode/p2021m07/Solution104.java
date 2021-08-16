package leetcode.p2021m07;

import example.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 9:59 AM
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root==null){return 0;}
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args){
        Solution104 solution104=new Solution104();
        int depth=solution104.maxDepth(TreeNode.ofArray("[3,9,20,null,null,15,7]"));
        System.out.println(depth);
    }
}
