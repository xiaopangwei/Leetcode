package leetcode.p2022m01;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/6
 * @time 10:03 PM
 */
public class Solution1026 {
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {

        if (root == null) {
            return 0;
        }

        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private void dfs(TreeNode root, int maxVal, int minVal) {
        if (root == null) {
            return;
        }

        int newMaxVal = Math.max(maxVal, root.val);
        int newMinVal = Math.min(minVal, root.val);

        maxDiff = Math.max(maxDiff, Math.abs(newMaxVal - newMinVal));
        dfs(root.left, newMaxVal, newMinVal);
        dfs(root.right, newMaxVal, newMinVal);

    }

    public static void main(String[] args) {
        Solution1026 solution1026 = new Solution1026();
        TreeNode     root         = TreeNodeBuilder.build("[1,null,2,null,0,3]");
        int          ans          = solution1026.maxAncestorDiff(root);
        System.out.println(ans);
    }
}
