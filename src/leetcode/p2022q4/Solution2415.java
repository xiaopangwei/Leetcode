package leetcode.p2022q4;

import common.TreeNode;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/30
 * @time 9:39 PM
 */
public class Solution2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        bfs(root);
        return root;
    }

    private void bfs(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level % 2 == 1) {
                int i = 0;
                int j = size - 1;
                while (i < j) {
                    TreeNode node1 = queue.get(i);
                    TreeNode node2 = queue.get(j);
                    int      temp  = node1.val;
                    node1.val = node2.val;
                    node2.val = temp;
                    i++;
                    j--;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            level++;
        }
    }

    public static void main(String[] args){
        TreeNode treeNode=TreeNode.ofArray("[0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]");
        Solution2415 solution2415=new Solution2415();
        TreeNode root=solution2415.reverseOddLevels(treeNode);

    }
}
