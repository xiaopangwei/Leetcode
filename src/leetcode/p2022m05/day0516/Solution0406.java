package leetcode.p2022m05.day0516;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/16
 * @time 7:52 PM
 */
public class Solution0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode q = p.right;
            while (q.left != null) {
                q = q.left;
            }
            return q;
        } else {
            TreeNode ans = null;
            TreeNode q   = root;
            while (q != null) {
                if (q.val <= p.val) {
                    q = q.right;
                } else {
                    ans = q;
                    q = q.left;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution0406 solution0406 = new Solution0406();
        TreeNode     root         = TreeNodeBuilder.build("[2,1,3]");
        TreeNode     node         = root.right;
        TreeNode     p            = solution0406.inorderSuccessor(root, node);
        if (p == null) {
            System.out.println("NULL");
        } else {
            System.out.println(p.val);
        }
    }
}
