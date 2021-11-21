package leetcode.p2021m11;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/14
 * @time 10:47 AM
 */
public class Solution1038 {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }


    public static void main(String[] args) {
        Solution1038 solution1038 = new Solution1038();
        TreeNode     root         = TreeNode.ofArray("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        solution1038.bstToGst(root);

        System.out.println(root);
    }
}
