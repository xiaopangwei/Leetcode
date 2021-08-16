package leetcode.p2021m08;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 3:46 PM
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        int left = getSubNodeCount(root.left);
        if (left == k - 1) {
            return root.val;
        } else if (left >= k) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - left - 1);
        }
    }

    public int getSubNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSubNodeCount(root.left) + getSubNodeCount(root.right) + 1;
    }

    public static void main(String[] args) {
        Solution230 solution230 = new Solution230();
        TreeNode    root        = TreeNode.ofArray("[5,3,6,2,4,null,null,1]");
        for (int i = 0; i < 6; i++) {
            int ans = solution230.kthSmallest(root, i + 1);
            System.out.println(ans);
        }


    }
}
