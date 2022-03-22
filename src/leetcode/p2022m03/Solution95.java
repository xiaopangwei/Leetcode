package leetcode.p2022m03;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/27
 * @time 8:47 PM
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> nodes = new ArrayList<>();
        if (left > right) {
            //highlights
            nodes.add(null);
            return nodes;
        }
        if (left == right) {
            nodes.add(new TreeNode(left));
            return nodes;
        }

        for (int i = left; i <= right; i++) {
            TreeNode       root       = new TreeNode(i);
            List<TreeNode> leftNodes  = dfs(left, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, right);

            for (TreeNode l : leftNodes) {
                for (TreeNode r : rightNodes) {
                    root.left = l;
                    root.right = r;
                    nodes.add(clone(root));
                }
            }
        }
        return nodes;
    }

    private TreeNode clone(TreeNode original) {
        if (original == null) {
            return null;
        }
        TreeNode root = new TreeNode(original.val);
        root.left = clone(original.left);
        root.right = clone(original.right);
        return root;
    }

    public static void main(String[] args) {
        Solution95     solution95 = new Solution95();
        List<TreeNode> nodes      = solution95.generateTrees(3);
        System.out.println(nodes);
    }
}
