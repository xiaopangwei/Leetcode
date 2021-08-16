package leetcode.p20210630;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 3:40 PM
 */


public class Solution108 {


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

    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length-1);
    }

    private TreeNode create(int[] nums,int left,int right){
        if (left==right){
              return new TreeNode(nums[left]);
        }else if(left>right){
            return null;
        }
        else {
            int      mid   = left + (right - left) / 2;
            TreeNode root  = new TreeNode(nums[mid]);
            TreeNode lTree = create(nums, left, mid - 1);
            root.left = lTree;
            TreeNode rTree = create(nums, mid + 1, right);
            root.right = rTree;
            return root;
        }
    }


    public static void main(String[] args){
          Solution108 solution108=new Solution108();
          TreeNode root=solution108.sortedArrayToBST(new int[]{-10,-3,0,5,9});
          System.out.println(root);
    }
}
