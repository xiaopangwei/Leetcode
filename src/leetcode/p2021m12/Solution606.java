package leetcode.p2021m12;

import common.Solution;
import common.TreeNode;

import java.util.TreeSet;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/27
 * @time 9:25 PM
 */
public class Solution606 {
    public String tree2str(TreeNode root) {
        if (root==null){
            return "";
        }
        if (root.left == null && root.right==null) {
            return String.valueOf(root.val);
        }


        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        builder.append("(");
        builder.append(tree2str(root.left));
        builder.append(")");

        if (root.right!=null) {
            builder.append("(");
            builder.append(tree2str(root.right));
            builder.append(")");
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Solution606 solution606=new Solution606();
        String str=solution606.tree2str(TreeNode.ofArray("[1,2,3,null,4]"));
        System.out.println(str);

    }
}
