package leetcode.p20210312;

import leetcode.p20210209.Solution19;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/12
 * @time 2:26 PM
 */
public class Solution199 {



       static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }





    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>   ans   =new LinkedList<>();
        if (root==null){
            return ans;

        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            for (int i=0;i<len;i++)
            {
                TreeNode node=queue.poll();
                if (len-1==i){
                    ans.add(node.val);
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }

        }
        return ans;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode a1=new TreeNode(2);
        TreeNode a2=new TreeNode(3);
        root.left=a1;
        root.right=a2;

        TreeNode a3=new TreeNode(5);
        a1.right=a3;
        TreeNode a4=new TreeNode(4);
        a2.right=a4;

        Solution199 solution199=new Solution199();
        List<Integer> list=solution199.rightSideView(root);
        System.out.println(list);
    }
}
