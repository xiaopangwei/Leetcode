package leetcode.p2022m05.day0512;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 8:26 PM
 */
public class Solution270 {

    double minGap = Double.MAX_VALUE;

    int closed = -1;

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return closed;
    }

    private void dfs(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        double gap = Math.abs(root.val - target);
        if (gap < minGap) {
            minGap = gap;
            closed = root.val;
        }

        if (root.val < target) {
            dfs(root.right, target);
        }
        if (root.val > target) {
            dfs(root.left, target);
        }
    }

    public static void main(String[] args) {
        Solution270 solution270 = new Solution270();
        int ans=solution270.closestValue(TreeNodeBuilder.build("[4,2,5,1,3]"),3.714286);
        System.out.println(ans);
    }


}
