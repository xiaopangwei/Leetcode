package leetcode.p20210629;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/29
 * @time 10:04 AM
 */
public class Solution100 {
  public class TreeNode {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {

      if (p==null && q==null) {return true;}
      else if (p==null && q!=null) {return false;}
      else if (p!=null && q==null) {return false;}
      else if (p.val!=q.val) {return false;}
      return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }

    public static void main(String[] args){
        Solution100 solution100=new Solution100();

    }
}
