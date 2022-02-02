package leetcode.springfestival.sf20220130;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 10:07 AM
 */
public class SolutionJZOffer54 {
    public int kthLargest(TreeNode root, int k) {

        TreeNode ans = dfs(root, k);
        return ans.val;
    }

    private TreeNode dfs(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        int rightCount = countChild(root.right);

        if (k == rightCount + 1) {
            return root;
        } else if (k <= rightCount) {
            return dfs(root.right, k);
        } else {
            return dfs(root.left, k - rightCount - 1);
        }

    }


    private int countChild(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countChild(root.left) + countChild(root.right) + 1;
    }

    public static void main(String[] args) {
        SolutionJZOffer54 solutionJZOffer54 = new SolutionJZOffer54();
        TreeNode          root              = TreeNode.ofArray("[5,3,6,2,4,null,null,1]");
        int               ans               = solutionJZOffer54.kthLargest(root, 6);
        System.out.println(ans);
    }
}
