package leetcode.p2021m08;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 4:00 PM
 */
public class Solution1448 {
    int ans = 0;

    public int goodNodes(TreeNode root) {
        preOrderTraverse(root, Integer.MIN_VALUE);
        return ans;
    }

    private void preOrderTraverse(TreeNode root, int currentMax) {
        if (root == null) {
            return;
        }

        if (currentMax <= root.val) {
            ans++;
            currentMax = root.val;
        }

        preOrderTraverse(root.left, currentMax);

        preOrderTraverse(root.right, currentMax);

//        data.remove(data.size() - 1);

    }

    public static void main(String[] args) {
        Solution1448 solution1448 = new Solution1448();
        TreeNode     root         = TreeNode.ofArray("[3,3,null,4,2]");
        int ans=solution1448.goodNodes(root);
        System.out.println(ans);
    }
}
