package leetcode.p2021m09;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/26
 * @time 11:19 AM
 */
public class Solution742 {
    int                           ans   = -1;
    Map<TreeNode, List<TreeNode>> map   = new HashMap<>();
    Queue<TreeNode>               queue = new LinkedList<>();

    public int findClosestLeaf(TreeNode root, int k) {

        dfs(root, null, k);
        bfs(new HashSet<>());

        return ans;
    }

    private void bfs(Set<TreeNode> visited) {
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            visited.add(temp);
            if (temp.left == null && temp.right == null) {
                ans = temp.val;
                break;
            }

            List<TreeNode> next = map.getOrDefault(temp, new ArrayList<>());
            for (TreeNode node : next) {
                if (visited.contains(node)) {
                    continue;
                }
                queue.add(node);
            }
        }
    }

    private void dfs(TreeNode root, TreeNode parent, int k) {

        if (root == null) {
            return;
        }

        if (root.val == k) {

            queue.add(root);
        }

        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<>());
        }

        if (parent != null) {
            map.get(root).add(parent);
        }
        if (parent != null && !map.containsKey(parent)) {
            map.put(parent, new ArrayList<>());
        }
        if (parent != null) {
            map.get(parent).add(root);
        }

        dfs(root.left, root, k);
        dfs(root.right, root, k);

    }


    public static void main(String[] args) {
        Solution742 solution742 = new Solution742();
        TreeNode    root        = TreeNode.ofArray("[1,2,3,4,null,null,null,5,null,6]");
        int         ans         = solution742.findClosestLeaf(root, 2);
        System.out.println(ans);
    }
}
