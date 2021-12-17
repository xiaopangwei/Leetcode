package leetcode.p2021m12;

import common.TreeNode;

import java.util.Arrays;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/16
 * @time 10:06 PM
 */
public class Solution889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }


        int idx = 0;

        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == preorder[1]) {
                idx = i;
                break;
            }
        }

        int leftLen = idx + 1;

        int rightLen=preorder.length-leftLen-1;

        root.left=constructFromPrePost(Arrays.copyOfRange(preorder, 1, 1+leftLen), Arrays.copyOfRange(postorder, 0, leftLen));
        root.right=constructFromPrePost(Arrays.copyOfRange(preorder, 1+leftLen, preorder.length), Arrays.copyOfRange(postorder, postorder.length-rightLen-1, postorder.length-1));
        return root;
    }

    public static void main(String[] args){
        Solution889 solution889=new Solution889();
        TreeNode node =solution889.constructFromPrePost(new int[]{1,2,4,5,3,6,7},new int[]{4,5,2,6,7,3,1});
        System.out.println(node);
    }
}
