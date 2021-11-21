package leetcode.p2021m11;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/9
 * @time 10:25 PM
 */
public class Solution222 {
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);

        if (lDepth == rDepth) {
            return (1 << lDepth) + countNodes(root.right);
        } else {
            return (1 << rDepth) + countNodes(root.left);
        }

    }

    private int getDepth(TreeNode root) {
        TreeNode p     = root;
        int      level = 0;
        while (p != null) {

            level++;
            p = p.left;
        }
        return level;
    }

    public static void main(String[] args){
        Solution222 solution222=new Solution222();
        TreeNode root=TreeNode.ofArray("[1,2,3,4,5,6]");
        int cnt=solution222.countNodes(root);
        System.out.println(cnt);
    }
}
