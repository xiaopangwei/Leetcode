package leetcode.p2021m09;

import common.TreeNode;

import java.util.Arrays;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 2:40 PM
 */
public class Solution549 {


    int maxRes = 0;
    public int longestConsecutive(TreeNode root) {
        postOrder(root);
        return maxRes;
    }

    /*
        arr[0] increasing for this root
        arr[1] decreasing for this root
    */
    private int[] postOrder(TreeNode root){
        int[] arr = new int[2];
        if(root == null)
        {   return arr;}

        arr[0] = 1;
        arr[1] = 1;

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        //left
        if(root.left != null){
            if(root.left.val + 1 == root.val){
                arr[0] = left[0] + 1;
            }else if(root.left.val -1 == root.val){
                arr[1] = left[1] + 1;
            }
        }

        //right
        if(root.right != null){
            if(root.right.val + 1 == root.val){
                arr[0] = Math.max(right[0] + 1, arr[0]);
            }else if(root.right.val - 1 == root.val){
                arr[1] = Math.max(right[1] + 1, arr[1]);
            }
        }
        maxRes = Math.max(maxRes, arr[0] + arr[1] - 1);
        System.out.println(root.val+":"+ Arrays.toString(arr));
        return arr;
    }


    public static void main(String[] args) {


        TreeNode root = new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        root.left=node9;
        node9.left=new TreeNode(10);

        TreeNode node7 = new TreeNode(7);
        root.right=node7;

        Solution549 solution549=new Solution549();
        int ans=solution549.longestConsecutive(root);
        System.out.println(ans);

    }
}
