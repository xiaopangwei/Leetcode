package leetcode.p2022m01;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/11
 * @time 8:47 PM
 */
public class Solution129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new LinkedList<>());
        return sum;
    }

    public void dfs(TreeNode root, LinkedList<Integer> temp) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            int t = 0;
            for (int i = 0; i < temp.size(); i++) {
                t = t * 10 + temp.get(i);
            }
            t = t * 10 + root.val;
            sum += t;
            return;
        }

        temp.add(root.val);
        dfs(root.left, temp);
        dfs(root.right, temp);
        temp.removeLast();
    }


    public static void main(String[] args) {
        TreeNode    root        = TreeNodeBuilder.build("[1,2,3]");
        Solution129 solution129 = new Solution129();
        int         ans         = solution129.sumNumbers(root);
        System.out.println(ans);
    }
}
