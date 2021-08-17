package leetcode.p2021m08;

import common.TreeNode;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 3:35 PM
 */
public class Solution270 {
    public int closestValue(TreeNode root, double target) {

        double minDist = Integer.MAX_VALUE;
        int    realVal = -1;

        TreeNode p = root;
        while (p != null) {
            if (p.val == target) {
                return p.val;
            }
            if (Math.abs(p.val - target) < minDist) {
                minDist = Math.abs(p.val - target);
                realVal = p.val;
            }
            if (target < p.val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        return realVal;

    }


    public int[] closestValue(TreeNode root, TreeNode targetNode) {


        TreeNode p = targetNode.left;
        TreeNode q = targetNode.right;

        while (p.right != null) {
            p = p.right;
        }

        while (q.left != null) {
            q = q.left;
        }

        return new int[]{p.val, q.val};
    }

    public static void main(String[] args) {
        Solution270 solution270 = new Solution270();
        TreeNode    root        = TreeNode.ofArray("[4,2,5,1,3]");
        TreeNode    target      = TreeNode.search(root, 5);
        int[]       ans         = solution270.closestValue(root, target);
        System.out.println(Arrays.toString(ans));

    }
}
