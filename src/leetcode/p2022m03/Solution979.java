package leetcode.p2022m03;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/8
 * @time 9:02 PM
 */
public class Solution979 {

    int ans = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }


    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a    = dfs(root.left);
        int b    = dfs(root.right);
        int temp = a + b + root.val - 1;
        ans += (Math.abs(a) + Math.abs(b));
//        System.out.println(root.val + "过载量#" + temp);
        return temp;
    }

    public static void main(String[] args) {
        Solution979 solution979 = new Solution979();
        int         ans         = solution979.distributeCoins(TreeNode.ofArray("[1,0,0,null,3]"));
        System.out.println(ans);
    }
}