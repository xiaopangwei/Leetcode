package leetcode.p2021m11;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/22
 * @time 9:20 PM
 */
public class Solution1008 {
    public TreeNode bstFromPreorder(int[] preorder) {

        //[8,5,1,7,10,12]
        TreeNode root = build(preorder, 0, preorder.length - 1);
        return root;
    }

    private TreeNode build(int[] preorder, int lower, int upper) {
        if (lower > upper) {
            return null;
        }
        int rootVal    = preorder[lower];
        int rightIndex = -1;
        for (int i = lower + 1; i <= upper; i++) {
            if (preorder[i] > rootVal) {
                rightIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);

        if (rightIndex!=-1) {
            root.left = build(preorder, lower + 1, rightIndex - 1);

            root.right = build(preorder, rightIndex, upper);
        }else{
            root.left = build(preorder, lower + 1, upper);
        }

        return root;

    }

    public static void main(String[] args){
        Solution1008 solution1008=new Solution1008();
        TreeNode root=solution1008.bstFromPreorder(new int[]{4,2});
        System.out.println(root);
    }
}
