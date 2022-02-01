package leetcode.p2022m01;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 3:45 PM
 */
public class Solution222 {
    private int getDepth(TreeNode root) {

        TreeNode p     = root;
        int      count = 0;
        while (p != null) {
            count++;
            p = p.left;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight  = getDepth(root.left);
        int rightHeight = getDepth(root.right);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else if (leftHeight >= rightHeight) {
            return (1 << rightHeight) + countNodes(root.left);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution222 solution222 = new Solution222();
        TreeNode    root        = TreeNodeBuilder.build("[1,2,3,4,5,6]");
        int ans=solution222.countNodes(root);
        System.out.println(ans);
    }
}
