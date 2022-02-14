package leetcode.p2022m02;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/13
 * @time 8:19 PM
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int                 size = queue.size();
            LinkedList<Integer> row  = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (flag) {
                    row.addLast(node.val);
                } else {
                    row.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
            ans.add(row);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution103         solution103 = new Solution103();
        List<List<Integer>> ans         = solution103.zigzagLevelOrder(TreeNodeBuilder.build("[1]"));
        System.out.println(ans);
    }
}
