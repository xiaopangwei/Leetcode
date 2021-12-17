package leetcode.p2021m12;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/14
 * @time 8:56 PM
 */
public class Solution938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null){
            return 0;
        }
        int ans=0;
        if (low<=root.val && root.val<=high){
            ans+=root.val;
        }

        ans+=rangeSumBST(root.left,low,high);
        ans+=rangeSumBST(root.right,low,high);
        return ans;
    }
}
