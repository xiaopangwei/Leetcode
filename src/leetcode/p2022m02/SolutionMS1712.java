package leetcode.p2022m02;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/10
 * @time 9:18 PM
 */
public class SolutionMS1712 {
    TreeNode prev = null, head = null;

    public TreeNode convertBiNode(TreeNode root) {

        dfs(root);
        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left  = root.left;
        TreeNode right = root.right;
        dfs(left);
        if (head == null) {
            head = root;
            prev = head;
        } else {
            root.left = null;
            prev.right = root;
            prev = root;
        }

        dfs(right);
    }

    public static void main(String[] args) {
        SolutionMS1712 solutionMS1712 = new SolutionMS1712();
        TreeNode       root           = TreeNodeBuilder.build("[4,2,5,1,3,null,6,0]");
        TreeNode       newRoot        = solutionMS1712.convertBiNode(root);
        System.out.println(newRoot);
    }
}
