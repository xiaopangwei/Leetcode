package leetcode.p2022m01;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/3
 * @time 10:52 AM
 */
public class Solution1110 {
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> sets = new HashSet<>();
        for (int item : to_delete) {
            sets.add(item);
        }
        root = remove(root, sets);

        if (root != null) {
            ans.add(root);
        }

        return ans;
    }

    private TreeNode remove(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return null;
        }

        root.left = remove(root.left, set);
        root.right = remove(root.right, set);

        if (set.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            root = null;
        }
        return root;

    }

    public static void main(String[] args) {
        Solution1110   solution1110 = new Solution1110();
        TreeNode       root         = TreeNode.ofArray("[1,2,3,4,5,6,7]");
        List<TreeNode> ans          = solution1110.delNodes(root, new int[]{3, 5});
        System.out.println(ans);
    }

}
