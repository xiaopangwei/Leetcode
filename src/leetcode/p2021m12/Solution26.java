package leetcode.p2021m12;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/18
 * @time 10:29 AM
 */
public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);


    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return dfs(A.left, B.left) && dfs(A.right, B.right);

    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        boolean    ans        = solution26.isSubStructure(TreeNode.ofArray("[3,4,5,1,2]"), TreeNode.ofArray("[4,1]"));
        System.out.println(ans);
    }
}
