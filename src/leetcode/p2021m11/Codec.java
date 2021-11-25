package leetcode.p2021m11;

import common.TreeNode;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/22
 * @time 9:36 PM
 */
public class Codec {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        builder.setLength(builder.length() - 1);
        String res = builder.toString();
        return res;
    }

    private void dfs(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        dfs(root.left, builder);
        dfs(root.right, builder);
        builder.append(root.val);
        builder.append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null){
            return null;
        }
        String[] array=data.split(",");

        int[] postOrderArray=new int[array.length];
        for (int i=0;i<postOrderArray.length;i++){
            postOrderArray[i]=Integer.parseInt(array[i]);
        }

        int[] inOrderArray=postOrderArray.clone();
        Arrays.sort(inOrderArray);

        return buildTree(inOrderArray,postOrderArray);
    }

    public static void main(String[] args){
        Codec codec=new Codec();
        TreeNode root=TreeNode.ofArray("[2,1,3]");
        String res=codec.serialize(root);
        System.out.println(res);
        TreeNode node=codec.deserialize(res);
        System.out.println(node);

    }
}
