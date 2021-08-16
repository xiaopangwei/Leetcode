package leetcode.p2021m06.p20210619;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/23
 * @time 1:31 PM
 */
public class Solution124 {

    private int ret=Integer.MIN_VALUE;
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
    public int maxPathSum(TreeNode root) {

        if (root==null){return 0;}
        int left=0,right=0;
        left=Math.max(0,maxPathSum(root.left));
        right=Math.max(0,maxPathSum(root.right));

        ret=Math.max(ret,left+right+root.val);

        return Math.max(left,right)+root.val;


    }


    private boolean isGreaterThan(int val,int... target){
          for (int item:target){
              if (val<item){
                  return false;
              }
          }
          return true;
    }

    public static void main(String[] args){
//
          TreeNode root=new TreeNode(1);
          TreeNode l1=new TreeNode(-2);
          TreeNode r1=new TreeNode(3);
          root.left=l1;
          root.right=r1;

//        TreeNode root=new TreeNode(-10);
//        TreeNode l1=new TreeNode(9);
//        TreeNode r1=new TreeNode(20);
//
//        TreeNode r12=new TreeNode(15);
//        TreeNode l13=new TreeNode(7);
//        root.left=l1;
//        root.right=r1;
//
//        r1.left=r12;
//        r1.right=l13;

//        TreeNode root=new TreeNode(-3);

          Solution124 solution124=new Solution124();
          System.out.println(solution124.maxPathSum(root));

    }
}
