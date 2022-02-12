package leetcode.p2022m02;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/10
 * @time 10:34 PM
 */
public class Solution863 {
    Map<TreeNode, TreeNode> pMap = new HashMap<>();

    List<TreeNode> visited = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                visited.add(temp);
                if (count == k) {
                    ans.add(temp.val);
                }
                if (temp.left != null && !queue.contains(temp.left) && !visited.contains(temp.left)) {
                    queue.add(temp.left);
                }
                if (temp.right != null && !queue.contains(temp.right) && !visited.contains(temp.right)) {
                    queue.add(temp.right);
                }

                TreeNode pNode = pMap.get(temp);
                if (pNode != null && !queue.contains(pNode) && !visited.contains(pNode)) {
                    queue.add(pNode);
                }
            }

            if (count == k) {
                break;
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        pMap.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public static void main(String[] args) {
        Solution863   solution683 = new Solution863();
        TreeNode      root        = TreeNodeBuilder.build("[1]");
        List<Integer> ans         = solution683.distanceK(root, root, 0);
        System.out.println(ans);
    }
}
