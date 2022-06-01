package leetcode.p2022m05.day0530;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/30
 * @time 8:50 PM
 */
public class Solution1022 {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0, 1);
        return sum;
    }

    private void dfs(TreeNode root, int s, int base) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum += (s * 2 + root.val);
            return;
        }

        int t = root.val;
        s = s * 2 + t;
        int b = base << 1;
        dfs(root.left, s, b);
        dfs(root.right, s, b);
    }


    public static void main(String[] args) {
        TreeNode     root         = TreeNodeBuilder.build("[1,0,1,0,1,0,1]");
        Solution1022 solution1022 = new Solution1022();
        int          s            = solution1022.sumRootToLeaf(root);
        System.out.println(s);
    }
}
