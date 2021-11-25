package leetcode.p2021m11;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/24
 * @time 10:07 PM
 */
public class CodecBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder builder = new StringBuilder();
        serialize0(root, builder);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        int len=data.length();

        StringBuilder number=new StringBuilder();
        for (int i=0;i<len;i++){
            if (data.charAt(i)=='['){
                break;
            }else{
                number.append(data.charAt(i));
            }
        }
        TreeNode root=new TreeNode(Integer.valueOf(number.toString()));

        return null;
    }


    private void serialize0(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("X");
            return;
        }


        builder.append("(");
        serialize0(root.left, builder);
        builder.append(")");
        builder.append(root.val);
        builder.append("(");
        serialize0(root.right, builder);
        builder.append(")");
    }

    public static void main(String[] args) {
        CodecBinaryTree codecBinaryTree = new CodecBinaryTree();
        TreeNode        root            = TreeNode.ofArray("[1,2,3,null,null,4,5]");
        String          ans             = codecBinaryTree.serialize(root);
        System.out.println(ans);
    }
}
