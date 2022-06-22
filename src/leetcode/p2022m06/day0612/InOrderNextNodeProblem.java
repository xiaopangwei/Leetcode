package leetcode.p2022m06.day0612;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/18
 * @time 11:25 PM
 */
public class InOrderNextNodeProblem {

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public TreeNode next(TreeNode root, TreeNode p) {
        dfs(root, null);
        if (p.right != null) {
            TreeNode l = p.right;
            while (l.left != null) {
                l = l.left;
            }
            return l;
        }
        if (parentMap.get(p) != null && parentMap.get(p).left == p) {
            return parentMap.get(p);
        } else {
            TreeNode parent = parentMap.get(p);
            while (parent.left != p) {
                p = parent;
                parent = parentMap.get(parent);
                if (parent == null) {
                    return null;
                }
            }
            return parent;
        }
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }

        parentMap.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public static void main(String[] args) {
        TreeNode               root    = TreeNodeBuilder.build("[1,2,3,4,5,6,7,8]");
        InOrderNextNodeProblem problem = new InOrderNextNodeProblem();
        TreeNode               node    = problem.next(root, root.right.left);
        if (node == null) {
            System.out.println("NULL");
        } else {
            System.out.println(node.val);
        }
    }
}
