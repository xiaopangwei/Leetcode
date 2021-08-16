package leetcode.p20210629;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/29
 * @time 11:07 PM
 */
public class Solution112 {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
         if (root==null) return false;
         return dfs(root,targetSum,0);
    }


    public boolean dfs(TreeNode root, final int targetSum,int currentSum){
         if (root==null ){
             if (targetSum==currentSum)
             {return true;}
             return false;
         }
         int temp=currentSum+root.val;
         if (root.left!=null && root.right!=null) {
             return dfs(root.left, targetSum, temp) || dfs(root.right, targetSum, temp);
         }else if (root.left==null && root.right!=null)
         {
             return dfs(root.right, targetSum, temp);
         }
         else if (root.left!=null && root.right==null)
         {
             return dfs(root.left, targetSum, temp);
         }else{
             if (targetSum==temp){
                 return true;
             }else{
                 return false;
             }
         }
    }

    public static void main(String[] args){
        Solution112 solution112=new Solution112();
//        TreeNode t1=new TreeNode(1);
//        TreeNode t7=new TreeNode(7);
//        TreeNode t2=new TreeNode(2);
//        TreeNode t13=new TreeNode(13);
//        TreeNode t4Copy1=new TreeNode(4,null,t1);
//
//        TreeNode t11=new TreeNode(11,t7,t2);
//        TreeNode t8=new TreeNode(8,t13,t4Copy1);
//
//        TreeNode t4Copy2=new TreeNode(4,t11,null);
//
//        TreeNode t5=new TreeNode(5,t4Copy2,t8);

        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);

        t1.left=t2;
        System.out.println(solution112.hasPathSum(t1,1));
    }



}
