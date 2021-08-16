package leetcode.p20210627;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 11:21 AM
 */
public class Solution1712 {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      TreeNode(int x,TreeNode left,TreeNode right) { val = x;this.left=left;this.right=right; }
  }

    public TreeNode convertBiNode(TreeNode root) {
        Deque<TreeNode> stack =new ArrayDeque<>();
        if (root!=null){
            stack.push(root);
        }

        TreeNode prev=new TreeNode(-1);
        TreeNode newRoot=prev;
        TreeNode top=root;
        while (!stack.isEmpty()){

            while (top!=null && top.left!=null){
                stack.push(top.left);
                top=top.left;
            }
            if (!stack.isEmpty()) {
                TreeNode temp = stack.pollFirst();
                System.out.println(temp.val);
                temp.left=null;
                prev.right=temp;
                prev=temp;
                top = temp.right;
                if (top!=null) {
                    stack.push(top);
                }
            }
        }
        return newRoot.right;
    }

    public static void main(String[] args){
        Solution1712 solution1712=new Solution1712();
        TreeNode t0=new TreeNode(0,null,null);
        TreeNode t3=new TreeNode(3,null,null);
        TreeNode t6=new TreeNode(6,null,null);
        TreeNode t1=new TreeNode(1,t0,null);
        TreeNode t2=new TreeNode(2,t1,t3);
        TreeNode t5=new TreeNode(5,null,t6);
        TreeNode root=new TreeNode(4,t2,t5);
        TreeNode res=solution1712.convertBiNode(root);
        System.out.println(res);
    }

}
