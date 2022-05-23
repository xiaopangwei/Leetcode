package leetcode.p2022m05.day0501;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 1:22 PM
 */
public class Solution1448 {
    int ans = 0;

    public int goodNodes(TreeNode root) {
        dfs(root,Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(TreeNode root, int currentMax) {
        if (root == null) {
            return;
        }

        if (root.val >= currentMax) {
            currentMax = root.val;
            ans++;
        }

        dfs(root.left, currentMax);
        dfs(root.right, currentMax);
    }

    public static void main(String[] args){
        TreeNode root=TreeNodeBuilder.build("[3,1,4,3,null,1,5]");
        Solution1448 solution1448=new Solution1448();
        int ans=solution1448.goodNodes(root);
        System.out.println(ans);
    }
}
