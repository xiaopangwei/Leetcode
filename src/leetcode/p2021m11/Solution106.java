package leetcode.p2021m11;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/22
 * @time 9:40 PM
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode root=build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;

    }

    private TreeNode build(final int[] inorder, final int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int      rootVal = postorder[postEnd];
        TreeNode root    = new TreeNode(rootVal);
        int      idx     = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }
        int leftLength = idx - inStart;
        if (idx == inStart) {
            root.left = null;
            root.right = build(inorder, postorder, idx + 1, inEnd, postStart + leftLength, postEnd - 1);
        } else if (idx == inEnd) {
            root.left = build(inorder, postorder, inStart, idx - 1, postStart, postStart + leftLength - 1);

            root.right = null;
        } else {
            root.left = build(inorder, postorder, inStart, idx - 1, postStart, postStart + leftLength - 1);
            root.right = build(inorder, postorder, idx + 1, inEnd, postStart + leftLength, postEnd - 1);
        }

        return root;

    }


    public static void main(String[] args){
        Solution106 solution106=new Solution106();
        TreeNode root=solution106.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
        System.out.println(root);
    }
}
