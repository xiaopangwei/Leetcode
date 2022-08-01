package common.ms;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/9/3
 * @time 10:21 PM
 */
public class Daily0903 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int     m  = nums1.length;
        int     n  = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return dp[m][n];
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len=inorder.length;
        return build(inorder,0,len-1,postorder,0,len-1);
    }

    private TreeNode build(int[] inOrder, int s1, int e1, int[] postOrder, int s2, int e2) {
        if (s1 > e1) {
            return null;
        }
        if (s1 == e1) {
            return new TreeNode(inOrder[s1]);
        }

        int rootVal   = postOrder[e2];
        int rootIndex = -1;
        for (int i = s1; i <= e1; i++) {
            if (rootVal == inOrder[i]) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root=new TreeNode(rootVal);

        int len=rootIndex-s1;
        root.left=build(inOrder,s1,rootIndex-1,postOrder,s2,s2+len-1);
        root.right=build(inOrder,rootIndex+1,e1,postOrder,s2+len,e2-1);
        return root;
    }

    public static void main(String[] args) {
        Daily0903 daily0903 = new Daily0903();
//        TreeNode  root      = daily0903.removeLeafNodes(TreeNodeBuilder.build("[1,2,3,2,null,2,4]"), 2);
//        int len = daily0903.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1});
        TreeNode root=daily0903.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
        System.out.println(root);
    }


}
