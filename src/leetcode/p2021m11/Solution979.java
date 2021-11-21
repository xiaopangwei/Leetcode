package leetcode.p2021m11;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/8
 * @time 9:02 PM
 */
public class Solution979 {
    private int ans = 0;

    public int distributeCoins(TreeNode root) {

        dfs(root);
        return ans;

    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left  = dfs(root.left);
        int right = dfs(root.right);

        int a = 0;
        int b = 0;
        if (root.left != null) {
            a = root.left.val;
        }

        if (root.right != null) {
            b = root.right.val;
        }

        root.val = a + b + root.val;

        int total = 1 + left + right;
        ans += Math.abs(total - root.val);
        return total;
    }

    public static void main(String[] args){
        Solution979 solution979=new Solution979();
        TreeNode root=TreeNode.ofArray("[1,0,0,null,3]");
        int ans=solution979.distributeCoins(root);
        System.out.println(ans);
    }
}
