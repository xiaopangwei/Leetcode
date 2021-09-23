package leetcode.p2021m09;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 7:53 PM
 */
public class Solution366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        TreeNode node = root;
        while (node != null) {
            List<Integer> temp = new ArrayList<>();
            TreeNode      t    = dfs(node, null, temp);
            list.add(temp);
            node = t;
        }
        return list;
    }

    private TreeNode dfs(TreeNode root, TreeNode parent, List<Integer> data) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            data.add(root.val);
            if (parent != null) {
                if (parent.left == root) {
                    parent.left = null;
                }
                if (parent.right == root) {
                    parent.right = null;
                }
            }
            return null;
        }
        root.left = dfs(root.left, root, data);
        root.right = dfs(root.right, root, data);
        return root;
    }

    public static void main(String[] args) {
        Solution366 solution366 = new Solution366();
        TreeNode    root        = TreeNode.ofArray("[1,2,3,4,5]");
        System.out.println(solution366.findLeaves(root));
    }
}
