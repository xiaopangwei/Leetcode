package leetcode.p20210627;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 9:56 AM
 */
public class Solution653 {
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

        public boolean findTarget(TreeNode root, int k) {
//            List<Integer> list=new ArrayList<>();
//            inorder(root,list);
            int[] sum=new int[1];
            int ret=inorder(root,sum);
            System.out.println(ret);

//            int i=0;
//            int j=list.size()-1;
//
//            while (i<j){
//                if (list.get(i)+list.get(j)==k){
//                    return true;
//                }else if (list.get(i)+list.get(j)<k){
//                    i++;
//                }else{
//                    j--;
//                }
//            }

            return false;

        }


        private void inorder(TreeNode root,List<Integer> list){
            if (root==null) return;
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }

        private int inorder(TreeNode root,int[] val){
            if (root==null) return 1;
            int left=inorder(root.left,val);
            val[0]+=root.val;
            int right=inorder(root.right,val);
            System.out.println(root.val+" "+left+" "+right);
            return left+right+1;
        }




    public static void main(String[] args){
        Solution653 solution653=new Solution653();
        TreeNode left=new TreeNode(3,new TreeNode(2),new TreeNode(4));
        TreeNode right=new TreeNode(6,null,new TreeNode(7));
        TreeNode root=new TreeNode(5,left,right);
        System.out.println(solution653.findTarget(root,13));
    }
}
