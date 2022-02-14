package leetcode.p2022m02;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/13
 * @time 8:43 PM
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return build(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private TreeNode build(int[] preorder, int start1, int end1,
                           int[] inorder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }
        if (start1 == end1) {
            return new TreeNode(preorder[start1]);
        }

        int rootVal = preorder[start1];

        int index = -1;
        for (int i = start2; i <= end2; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        //start2~index-1
        int leftLen = index - start2;
        //index+1~end2
        int rightLen = end2 - index;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, start1 + 1, start1 + leftLen, inorder, start2, index - 1);
        root.right = build(preorder, start1 + leftLen + 1, end1, inorder, index + 1, end2);

        return root;
    }

    public static void main(String[] args) {
        //[3,9,20,15,7], inorder = [9,3,15,20,7]
        Solution105 solution105 = new Solution105();
        TreeNode    node        = solution105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
    }
}
