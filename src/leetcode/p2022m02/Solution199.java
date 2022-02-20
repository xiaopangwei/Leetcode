package leetcode.p2022m02;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 2:47 PM
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int      size = queue.size();
            TreeNode temp = null;
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if (temp != null) {
                ans.add(temp.val);
            }
        }
        return ans;
    }
}
