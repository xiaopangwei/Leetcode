package leetcode.p2022m06.day0628;

import common.TreeNode;
import common.TreeNodeBuilder;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/4
 * @time 10:22 PM
 */
public class Solution988 {

    String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append((char) (root.val + 'a'));

        if (root.left == null && root.right == null) {
//            System.out.println(sb.toString());
            if (ans == null) {
                ans = sb.reverse().toString();
                sb.reverse();
            } else {
                String t = sb.reverse().toString();
                if (t.compareTo(ans) < 0) {
                    ans = t;
                }
                sb.reverse();
            }
        }

        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeBuilder.build(
                "[25,1,3,1,3,0,2]");
        Solution988 solution988 = new Solution988();
        String      ans         = solution988.smallestFromLeaf(root);
        System.out.println(ans);

//        StringBuilder sb = new StringBuilder();
//        sb.append('1');
//        sb.append('2');
//
//        System.out.println(sb.reverse().toString());
//        System.out.println(sb.reverse());
    }
}
