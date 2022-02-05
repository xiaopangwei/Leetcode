package leetcode.springfestival.pm20220203;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 4:42 PM
 */
public class SolutionJZOffer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return compare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean compare(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return true;
        }

        if (A.val != B.val) {
            return false;
        }

        return compare(A.left, B.left) && compare(A.right, B.right);
    }
}
